package com.dx.wms.test.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.xmlbeans.impl.xb.ltgfmt.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.report.IPastReportService;
import com.dx.cmm.service.report.IPastViewService;
import com.dx.cmm.service.report.dto.PastParamDto;
import com.dx.cmm.service.report.dto.PastProtocolViewResult;
import com.dx.cmm.service.report.dto.PastResult;
import com.dx.cmm.service.view.excel.ExcPastResult;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public class PastTest extends BaseTest{
	@Autowired
	IPastReportService pastService;
	
	@Autowired
	IPastViewService pastViewService;
	
	

	
	@Test
	public void pastTest(){
		Pagination page = new Pagination();
		page.setPagesize(20);
		PastParamDto dto = new PastParamDto();
		dto.setCreateTime("2016-09-20");
		dto.setReportDate("2016-11-1");
		
		PaginationResult<List<PastResult>> results = pastService.queryPastList(dto, page);
		List<PastResult> result = new ArrayList<PastResult>();
		for(PastResult r : results.getR()){
			result.add(r);
		}
		System.out.println("条数"+result.size());
		System.out.println("结果是"+JSON.toJSON(result));
	}
	
	@Test
	public void queryView(){
		
		PastProtocolViewResult result = pastViewService.getPreData("L0021001508280001-002", "2016-09-19", "2016-11-1");
		
		System.out.println("结果是"+JSON.toJSON(result));
		System.out.println("reportDayView:"+ result.getReportDayView());
	}
	
	@Test
	public void queryPdf(){
		PastParamDto param = new PastParamDto();
		List<String> codes = new ArrayList<String>();
		codes.add("L0532021701070003-001");
		codes.add("L0532021701070002-001");
		param.setLenderCodes(codes);
		param.setCreateTime("2017-01-01");
		param.setReportDate("2017-2-16");
		List<PastProtocolViewResult> results = pastViewService.getPdfData(param);
		
		for(PastProtocolViewResult result : results){
			System.out.println("结果是："+JSON.toJSON(result));
			System.out.println("reportDay"+JSON.toJSONString(result.getReportDay()));
			System.out.println("reportDayVierw"+JSON.toJSONString(result.getReportDayView()));
			
		}
		
	}
	
	@Test
	public void queryAllPdf(){
		PastParamDto param = new PastParamDto();
		param.setIsQuery("query");
		param.setCreateTime("2016-12-01 10:06:16");
		param.setReportDate("2017-1-16");
		
		List<PastProtocolViewResult> results = pastViewService.getPdfData(param);
		OutputStreamWriter pw = null;
		try {
			pw = new OutputStreamWriter(new FileOutputStream("E:/result4test.txt"),"GBK");
			for(PastProtocolViewResult result : results){
				//System.out.println("结果是:"+ JSON.toJSONString(result));
				pw.write(JSON.toJSONString(result));
			}
			pw.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// 
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            System.err.println("results size is"+results.size());
		
	}
	
	
	@Test
	public void queryExcel(){
		PastParamDto dto = new PastParamDto();
		List<String> lenderCodes = new ArrayList<String>();
		lenderCodes.add("L0021001508280001-002");
		dto.setLenderCodes(lenderCodes);
		dto.setCreateTime("2016-09-19");
		dto.setReportDate("2016-11-1");
		
		
		List<ExcPastResult> result = pastViewService.queryExc(dto);
		
		/*
		 * 方法使用格式
		 */
		List<String> headTitle = new ArrayList<String>();
		String[] HEAD = {"出借人邮编","出借人地址","受让人姓名","身份证号","出借编号","报告日","借款人姓名","借款人身份证号码","初始出借金额","本次转让对价","需支付对价","借款人职业情况","借款人借款用途","还款起始日期","还款期数(月)","剩余还款月数","预计债权收益率(年)","账单日"};
		excelExoprt(headTitle, HEAD, null, result, null, "数据导出",
                "yyyy-mm-dd");
	}
	
	public static final String HYPHEN = "-";
	
	public static void excelExoprt(List<String> requirements, String[] headTitle, String[] subTitle, List<?> objectList,
            String path, String pathName, String dateFormat) {

        HSSFWorkbook workbook = null;
        workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(pathName);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        int y = 0;

        HSSFRow row = null;
        if (null != requirements && requirements.size() > 0) {
            for (String requirement : requirements) {
                row = sheet.createRow(y);
                HSSFCell ce = row.createCell(0);
                sheet.addMergedRegion(new CellRangeAddress(y, y, 0, 3));
                ce.setCellValue(requirement);
                ++y;
            }
        }

        Class<?> classType = null;
        Field[] fields = null;
        Field field = null;
        HSSFCell cell = null;
        Method getMethod = null;

        if (null != headTitle && headTitle.length > 0) {
            String[] as = null;
            int x = 0;
            row = sheet.createRow(y);
            for (int i = 0; i < headTitle.length; i++) {
                as = headTitle[i].split(HYPHEN);
                HSSFCell ce = row.createCell(x);
                int firstRow = 1;
                if (as.length > 1) {
                    firstRow = Integer.parseInt(as[0]);
                    sheet.addMergedRegion(new CellRangeAddress(y, y, x, x + firstRow - 1));
                    ce.setCellValue(as[1]);
                } else {
                    ce.setCellValue(as[0]);
                }

                x = x + firstRow;
            }
            y++;
        }

        if (null != subTitle && subTitle.length > 0) {
            String[] as = null;
            int x = 0;
            row = sheet.createRow(y);
            for (int i = 0; i < subTitle.length; i++) {
                as = subTitle[i].split(HYPHEN);
                int firstRow = Integer.parseInt(as[0]);
                sheet.addMergedRegion(new CellRangeAddress(y, y, x, x + firstRow - 1));
                HSSFCell ce = row.createCell(x);
                ce.setCellValue(String.valueOf(as[1]));
                x = x + firstRow;
            }
            y++;
        }

        int x = 0;
        String fieldName = null;
        String firstLetter = null;
        String getMethodName = null;
        Object obj = null;

        if (null != objectList) {
            try {
                for (int i = 0; i < objectList.size(); i++) {
                    classType = objectList.get(i).getClass();
                    obj = objectList.get(i);
                    fields = classType.getDeclaredFields();
                    row = sheet.createRow(y);
                    for (int j = 0; j < fields.length; j++) {
                        field = fields[j];
                        fieldName = field.getName();
                        if("serialVersionUID"==fieldName){
                        	continue;
                        }
                        firstLetter = fieldName.substring(0, 1).toUpperCase();
                        getMethodName = "get" + firstLetter + fieldName.substring(1);
                        getMethod = classType.getMethod(getMethodName, new Class[] {});
                        Object value = getMethod.invoke(obj);
                        cell = row.createCell(x++);
                        if (value instanceof Date) {
                            String dateStr = DateUtils.formatForDay((Date) value, "");
                            cell.setCellValue(dateStr);
                        } else if (value instanceof Code) {
                            // cell.setCellValue(((Code) value).getName());
                        } else {
                            cell.setCellValue((value != null) ? String.valueOf(value) : "");
                        }
                    }
                    x = 0;
                    y++;
                }
            } catch (NoSuchMethodException e) {
                
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                
            }
        }
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        FileOutputStream out = null;
        File file = null;
        try {
        	file = new File("E:/test.xls");
            out = new FileOutputStream(file);
            workbook.write(out);
        } catch (IOException e) {
            
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                   
                }
            }
        }
    }
	
	
	
	@Test
	public void testName(){
		
		PastParamDto param = new PastParamDto();
		List<String> codes = new ArrayList<String>();
		codes.add("L0021001508280001-002");
		codes.add("L0532051509170001-001");
		param.setLenderCodes(codes);
		param.setCreateTime("2016-09-19");
		param.setReportDate("2016-11-1");
		List<PastProtocolViewResult> result = pastViewService.getPdfData(param);
		
		
		System.out.println("结果是"+JSON.toJSON(result));
	}
}
