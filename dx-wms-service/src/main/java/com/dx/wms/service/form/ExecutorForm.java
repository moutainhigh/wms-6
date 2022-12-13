/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ExecutorReportManagementServiceImpl.java
 * Author:   张祥韵
 * Date:     2015年11月19日 上午11:56:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.form;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.RoleVo;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.dal.util.DalUtils;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.constant.WMSConstants;
import com.google.gson.Gson;

/**
 * 执委会报表信息管理实现类
 * 
 * @author zhangxiangyun
 */
@Service
public class ExecutorForm extends FormRegister {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(ExecutorForm.class);

    @Override
    public String init(Map<String, Object> param) {
        return "reportManagement/list";
    }

    @Override
    public Boolean supports(Map<String, Object> param) {
        @SuppressWarnings("unchecked")
        List<RoleVo> roleVos = (List<RoleVo>) param.get("roleVos");
        return commonService.hasRoleExist(roleVos, RoleConstant.ZWH);
    }

    @Override
    public PaginationResult<List<FormDto>> query(Map<String, Object> param, Pagination page) {
        LOG.info("**doQuery() param={}**", new Gson().toJson(param));
        FormParamDto reportManagementQueryDto = (FormParamDto) param
                .get("reportManagementQueryDto");
        Pagination pagination = (Pagination) param.get("pagination");
        return dalClient.queryForList("reportManagement.queryForPage", DalUtils.convertToMap(reportManagementQueryDto),
                FormDto.class, pagination);
    }

    @Override
    public List<FormDto> getExcelVos(Map<String, Object> param) {
        FormParamDto reportManagementQueryDto = (FormParamDto) param
                .get("reportManagementQueryDto");
        Assert.notNull("**getExcelVos() reportManagementQueryDto can not be null**", reportManagementQueryDto);
        LOG.info("**queryForExcel() activityManagerDto={}**", new Gson().toJson(reportManagementQueryDto));
        List<FormDto> reportManagementDtos = dalClient.queryForList("reportManagement.queryForPage",
                reportManagementQueryDto, FormDto.class);
        return reportManagementDtos;
    }

    @Override
    public void queryExcel(Map<String, Object> param) {
        List<FormExcelVo> reportManagementExcelVos = (List<FormExcelVo>) param.get("excellist");
        HttpServletResponse response = (HttpServletResponse) param.get("response");
        FormExcel reportManagermentExcelDto = (FormExcel) param
                .get("reportManagermentExcelDto");
        OrgVo orgVo = (OrgVo) param.get("orgVo");
        String chooselistvalue = (String) param.get("chooselistvalue");
        String wmsTopClass = orgVo.getName();
        HSSFWorkbook workbook = null;
        workbook = new HSSFWorkbook();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFSheet sheet = workbook.createSheet("信息报表");
        int y = 0;
        HSSFRow row = null;
        HSSFCell cell = null;
        HSSFCell cell2 = null;
        List<String> title = new ArrayList<String>();
        title.add("理财端:" + wmsTopClass);
        title.add("生成时间:" + DateUtils.formatForFull(ts));
        if (Assert.checkParam(reportManagermentExcelDto.getProductQueryName())) {
            title.add("出借方式:" + reportManagermentExcelDto.getProductQueryName());
        } else {
            title.add("出借方式:");
        }
        if (Assert.checkParam(reportManagermentExcelDto.getLenderAmountAreaQueryName())) {
            title.add("出借金额:" + reportManagermentExcelDto.getLenderAmountAreaQueryName());
        } else {
            title.add("出借金额:");
        }
        if (Assert.checkParam(reportManagermentExcelDto.getAreaOrgIdsQueryName())) {
            title.add("区域:" + reportManagermentExcelDto.getAreaOrgIdsQueryName());
        } else {
            title.add("区域:");
        }
        if (Assert.checkParam(reportManagermentExcelDto.getBranchOfficeIdsQueryName())) {
            title.add("分公司:" + reportManagermentExcelDto.getBranchOfficeIdsQueryName());
        } else {
            title.add("分公司:");
        }
        if (Assert.checkParam(reportManagermentExcelDto.getOrgIdQueryName())) {
            title.add("营业部:" + reportManagermentExcelDto.getOrgIdQueryName());
        } else {
            title.add("营业部:");
        }
        if (Assert.checkParam(reportManagermentExcelDto.getClusterQueryName())) {
            title.add("大团:" + reportManagermentExcelDto.getClusterQueryName());
        } else {
            title.add("大团:");
        }
        if (Assert.checkParam(reportManagermentExcelDto.getTeamIdQueryName())) {
            title.add("团队:" + reportManagermentExcelDto.getTeamIdQueryName());
        } else {
            title.add("团队:");
        }
        String begtime = "";
        String endtime = "";
        if (Assert.checkParam(reportManagermentExcelDto.getSettlementDateBegQueryName())) {
            begtime = reportManagermentExcelDto.getSettlementDateBegQueryName();
        }
        if (Assert.checkParam(reportManagermentExcelDto.getSettlementDateEndQueryName())) {
            endtime = reportManagermentExcelDto.getSettlementDateEndQueryName();
        }
        if (Assert.checkParam(begtime + endtime)) {
            title.add("生效时间:" + begtime + "-" + endtime);
        } else {
            title.add("生效时间:");
        }
        if (Assert.checkParam(reportManagermentExcelDto.getStatementDateQueryName())) {
            title.add("账单日:" + reportManagermentExcelDto.getStatementDateQueryName());
        } else {
            title.add("账单日:");
        }
        if (reportManagementExcelVos.size() > 0) {
            if (reportManagementExcelVos.get(0).getInvestment() != null) {
                title.add("总投资数:" + reportManagementExcelVos.get(0).getInvestment());
            } else {
                title.add("总投资数:");
            }
            if (reportManagementExcelVos.get(0).getAllLenderAmount() != null) {
                title.add("总金额:" + reportManagementExcelVos.get(0).getAllLenderAmount());
            } else {
                title.add("总金额:");
            }
        } else {
            title.add("总投资数:");
            title.add("总金额:");
        }
        if (Assert.checkParam(chooselistvalue)) {
            try {
                chooselistvalue = new String(chooselistvalue.getBytes("iso-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < title.size(); i++) {

            row = sheet.createRow(y);
            cell2 = row.createCell(0);
            cell2.setCellValue(title.get(i));
            y++;

        }
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        String[] titleArr = chooselistvalue.split(",");

        List<String> titleList = new ArrayList<String>();

        for (int i = 0; i < titleArr.length; i++) {
            titleList.add(titleArr[i]);
        }
        String[] titlearr = titleList.toArray(new String[titleList.size()]);
        if (null != titlearr && titlearr.length > 0) {
            String[] as = null;
            int x = 0;
            row = sheet.createRow(y);
            for (int i = 0; i < titlearr.length; i++) {
                as = titlearr[i].split(WMSConstants.HYPHEN);
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
        for (int j = 0; j < reportManagementExcelVos.size(); j++) {
            row = sheet.createRow(y);
            for (int i = 0; i < titleList.size(); i++) {
                if (titleList.get(i).equals("序号")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getIndex());
                }
                if (titleList.get(i).equals("签单日期")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getSignDate() == null ? ""
                            : reportManagementExcelVos.get(j).getSignDate());

                }
                if (titleList.get(i).equals("出借编号")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getLenderCode() == null ? ""
                            : reportManagementExcelVos.get(j).getLenderCode());

                }
                if (titleList.get(i).equals("客户姓名")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getCustName() == null ? ""
                            : reportManagementExcelVos.get(j).getCustName());

                }
                if (titleList.get(i).equals("性别")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getSex() == null ? ""
                            : reportManagementExcelVos.get(j).getSex());

                }
                if (titlearr[i].equals("匹配时间")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getMatchDate() == null ? ""
                            : reportManagementExcelVos.get(j).getMatchDate());
                }
                if (titleList.get(i).equals("证件号码")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getIdCard() == null ? ""
                            : reportManagementExcelVos.get(j).getIdCard());
                }
                if (titleList.get(i).equals("出借方式")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getProductName() == null ? ""
                            : reportManagementExcelVos.get(j).getProductName());
                }
                if (titleList.get(i).equals("出借金额")) {
                    cell = row.createCell(i);
                    if (Assert.checkParam(reportManagementExcelVos.get(j).getLenderAmount())) {
                        cell.setCellValue(reportManagementExcelVos.get(j).getLenderAmount().toString());
                    }
                }
                if (titleList.get(i).equals("生效日期")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getSettlementDate() == null ? ""
                            : reportManagementExcelVos.get(j).getSettlementDate());
                }
                if (titleList.get(i).equals("账单日")) {
                    cell = row.createCell(i);
                    if (Assert.checkParam(reportManagementExcelVos.get(j).getStatementDate())) {
                        cell.setCellValue(reportManagementExcelVos.get(j).getStatementDate().toString());
                    }
                }
                if (titleList.get(i).equals("客户分类")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getCustCategory());
                }
                if (titleList.get(i).equals("预计出借日期")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getExpectLenderDate());
                }
                if (titleList.get(i).equals("支付方式")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getPayWayName());
                }
                if (titleList.get(i).equals("划扣银行")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getGiveBankCategory());
                }
                if (titleList.get(i).equals("划扣账号")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getGiveAccountNum());
                }
                if (titleList.get(i).equals("回款银行")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getGetBankCategory());
                }
                if (titleList.get(i).equals("回款账号")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getGetAccountNum());
                }
                if (titleList.get(i).equals("账户名")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getAccountName());
                }
                if (titleList.get(i).equals("联系地址")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getAddress());
                }
                if (titleList.get(i).equals("邮编")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getZipCode());
                }
                if (titleList.get(i).equals("区域")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getAreaName());
                }
                if (titleList.get(i).equals("分公司")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getBranchOfficeName());
                }
                if (titleList.get(i).equals("营业部")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getOrgName());
                }
                if (titleList.get(i).equals("大团")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getClusterName());
                }
                if (titleList.get(i).equals("团队")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getTeamName());
                }
                if (titleList.get(i).equals("团队经理")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getTeamUserName());
                }
                if (titleList.get(i).equals("客户经理")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getCreateUser());
                }
                if (titleList.get(i).equals("接受文件方式")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getMsgWay());
                }
                if (titleList.get(i).equals("电子邮箱")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getEmail());
                }
                if (titleList.get(i).equals("客户手机号")) {
                    cell = row.createCell(i);
                    cell.setCellValue(reportManagementExcelVos.get(j).getMobile());
                }

            }
            y++;
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + "信息报表" + ts + ".xls\"");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    LOG.error("out close failure---" + e);
                }
            }
        }
    }

    @Override
    public Map<String, Object> getRequestMap(Map<String, Object> param) {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpServletRequest request = (HttpServletRequest) param.get("request");
        OrgVo orgVo = (OrgVo) param.get("orgVo");
        String productId = request.getParameter("productId");
        String lenderAmountArea = request.getParameter("lenderAmountArea");
        String branchOfficeId = request.getParameter("branchOfficeIds");
        String orgId = request.getParameter("orgId");
        String cluster = request.getParameter("cluster");
        String teamId = request.getParameter("teamId");
        String statementDate = request.getParameter("statementDate");
        String settlementDateBeg = request.getParameter("settlementDateBeg");
        String settlementDateEnd = request.getParameter("settlementDateEnd");
        String areaOrgIds = request.getParameter("areaOrgIds");
        map.put("productId", productId);
        map.put("lenderAmountArea", lenderAmountArea);
        map.put("branchOfficeId", branchOfficeId);
        map.put("orgId", orgId);
        map.put("cluster", cluster);
        map.put("teamId", teamId);
        map.put("statementDate", statementDate);
        map.put("settlementDateBeg", settlementDateBeg);
        map.put("settlementDateEnd", settlementDateEnd);
        map.put("areaOrgIds", areaOrgIds);
        return map;
    }

    @Override
    public FormParamVo getManagementQueryVo(Map<String, Object> param) {
        FormParamVo reportManagementQueryVo = (FormParamVo) param
                .get("reportManagementQueryVo");
        return reportManagementQueryVo;
    }

    @Override
    public Map<String, String> getAttributeMap(Map<String, Object> param) {
        Map<String, String> orgView = new LinkedHashMap<String, String>();
        List<OrgVo> orgVos = (List<OrgVo>) param.get("orgVos");
        for (int i = 0; i < orgVos.size(); i++) {
            if (orgVos.get(i).getCode().indexOf("LQY") >= 0) {
                if (orgVos.get(i).getName().equals("综合部")) {
                    continue;
                }
                orgView.put(orgVos.get(i).getOrgId().toString(), orgVos.get(i).getName());
            }
        }
        return orgView;
    }

    @Override
    public FormDto queryallLenderAmount(Map<String, Object> param) {
        FormParamDto reportManagementQueryDto = (FormParamDto) param
                .get("reportManagementQueryDto");
        Assert.notNull("**queryallLenderAmount() reportManagementQueryDto can not be null**", reportManagementQueryDto);
        LOG.info("**queryallLenderAmount() reportManagementDto={}**", new Gson().toJson(reportManagementQueryDto));
        List<FormDto> reportManagementDtos = dalClient.queryForList("reportManagement.queryForPage",
                reportManagementQueryDto, FormDto.class);
        BigDecimal allLenderAmount = new BigDecimal(0);
        Integer count = 0;
        for (int i = 0; i < reportManagementDtos.size(); i++) {
            allLenderAmount = allLenderAmount.add(reportManagementDtos.get(i).getLenderAmount());
            ++count;
        }
        if (reportManagementDtos.size() > 0) {
            reportManagementDtos.get(0).setAllLenderAmount(allLenderAmount);
            reportManagementDtos.get(0).setInvestment(count);
            return reportManagementDtos.get(0);
        } else {
            return null;
        }
    }

}
