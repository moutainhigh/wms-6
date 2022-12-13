/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: ExportExcelUtil.java
 * Author:   廖叶萍
 * Date:     2015年3月5日 上午9:42:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.xmlbeans.impl.xb.ltgfmt.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.common.fileUpload.utils.FileUtil;
import com.dx.common.service.utils.DateUtils;

/**
 * excel导出服务<br>
 * 〈功能详细描述〉
 * 
 * @author v_Lijiang
 */
public class ExportExcelUtil {
    /**
     * logger对象
     */
    private static Logger LOG = LoggerFactory.getLogger(ExportExcelUtil.class);

    /**
     * 
     * 功能描述: 导出<br>
     * 〈功能详细描述〉
     * 
     * @param headTitle 标题
     * @param subTitle 副标题
     * @param objectList 数据
     * @param path 路径
     * @param pathName 路径名称
     * @param response 响应对象
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void excelExoprt(String[] headTitle, String[] subTitle, List<?> objectList, String path, String pathName,
            HttpServletResponse response) {
        excelExoprt(headTitle, subTitle, objectList, path, pathName, response, WebConstants.DATE_FORMART_STRING);
    }

    /**
     * 
     * 功能描述: 导出<br>
     * 〈功能详细描述〉
     * 
     * @param headTitle 标题
     * @param subTitle 副标题
     * @param objectList 数据
     * @param path 路径
     * @param pathName 路径名称
     * @param response 响应对象
     * @param dateFormat 日期格式化
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void excelExoprt(String[] headTitle, String[] subTitle, List<?> objectList, String path,
            String pathName, HttpServletResponse response, String dateFormat) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(pathName);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        int y = 0;
        Class<?> classType = null;
        Field[] fields = null;
        Field field = null;
        HSSFCell cell = null;
        Method getMethod = null;
        HSSFRow row = null;
        if (null != headTitle && headTitle.length > 0) {
            String[] as = null;
            int x = 0;
            row = sheet.createRow(y);
            for (int i = 0; i < headTitle.length; i++) {
                as = headTitle[i].split(WebConstants.HYPHEN);
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
                as = subTitle[i].split(WebConstants.HYPHEN);
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
                LOG.error("no this method---" + e);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                LOG.error(" method is error---" + e);
            }
        }
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + pathName + ts + ".xls\"");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            workbook.write(out);
        } catch (IOException e) {
            LOG.error("io---" + e);
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

    /**
     * 
     * 功能描述: 导出<br>
     * 〈功能详细描述〉
     * 
     * @param searchCondition 查询条件
     * @param headTitle 标题
     * @param objectList 数据
     * @param path 路径
     * @param pathName 路径名称
     * @param response 响应对象
     * @param dateFormat 日期格式化
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void excelExoprtForSearch(String[] searchCondition, String[] headTitle, List<?> objectList,
            String path, String pathName, HttpServletResponse response, String dateFormat) {

        HSSFWorkbook workbook = null;
        workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(pathName);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        int y = 0;

        Class<?> classType = null;
        Field[] fields = null;
        Field field = null;
        HSSFCell cell = null;
        Method getMethod = null;
        HSSFRow row = null;

        if (null != searchCondition && searchCondition.length > 0) {
            String[] as = null;
            int x = 0;
            row = sheet.createRow(y);
            for (int i = 0; i < searchCondition.length; i++) {
                as = searchCondition[i].split(WebConstants.HYPHEN);
                int firstRow = Integer.parseInt(as[0]);
                sheet.addMergedRegion(new CellRangeAddress(y, y, x, x + firstRow - 1));
                HSSFCell ce = row.createCell(x);
                ce.setCellValue(String.valueOf(as[1]));
                x = x + firstRow;
            }
            y++;
        }
        if (null != headTitle && headTitle.length > 0) {
            String[] as = null;
            int x = 0;
            row = sheet.createRow(y);
            for (int i = 0; i < headTitle.length; i++) {
                as = headTitle[i].split(WebConstants.HYPHEN);
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
                LOG.error("no this method---" + e);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                LOG.error(" method is error---" + e);
            }
        }
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=\"wms" + ts + ".xls\"");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            workbook.write(out);
        } catch (IOException e) {
            LOG.error("io---" + e);
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

    /**
     * 
     * 功能描述: 导出到指定文件夹<br>
     * 
     * @param headTitle 标题
     * @param subTitle 副标题
     * @param objectList 数据
     * @param path 路径
     * @param fileName 文件名
     * @param sheetName Sheet名称
     * @param dateFormat 日期格式化(默认为yyyy-MM-dd)
     */
    public static void excelExoprtToFolder(String[] headTitle, String[] subTitle, List<?> objectList, String path,
            String fileName, String sheetName, String dateFormat) {
        if (dateFormat == null) {
            dateFormat = WebConstants.DATE_FORMART_STRING;
        }

        HSSFWorkbook workbook = null;
        workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        DataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("@"));

        int y = 0;

        Class<?> classType = null;
        Field[] fields = null;
        Field field = null;
        HSSFCell cell = null;
        Method getMethod = null;
        HSSFRow row = null;

        if (null != headTitle && headTitle.length > 0) {
            String[] as = null;
            int x = 0;
            row = sheet.createRow(y);
            for (int i = 0; i < headTitle.length; i++) {
                as = headTitle[i].split(WebConstants.HYPHEN);
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
                as = subTitle[i].split(WebConstants.HYPHEN);
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
                        firstLetter = fieldName.substring(0, 1).toUpperCase();
                        getMethodName = "get" + firstLetter + fieldName.substring(1);
                        getMethod = classType.getMethod(getMethodName, new Class[] {});
                        Object value = getMethod.invoke(obj);
                        cell = row.createCell(x++);
                        cell.setCellStyle(style);
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
                LOG.error("no this method---" + e);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                LOG.error(" method is error---" + e);
            }
        }

        // 创建文件夹
        FileUtil.createAllDir(path);
        // 输出到文件夹
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path + fileName);
            workbook.write(out);
        } catch (IOException e) {
            LOG.error("io---" + e);
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

    /**
     * 
     * 功能描述: 导出<br>
     * 〈功能详细描述〉
     * 
     * @param headTitle 标题
     * @param subTitle 副标题
     * @param objectList 数据
     * @param path 路径
     * @param pathName 路径名称
     * @param response 响应对象
     * @param dateFormat 日期格式化
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void excelExoprt(List<String> requirements, String[] headTitle, String[] subTitle, List<?> objectList,
            String path, String pathName, HttpServletResponse response, String dateFormat) {

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
                as = headTitle[i].split(WebConstants.HYPHEN);
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
                as = subTitle[i].split(WebConstants.HYPHEN);
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
                LOG.error("no this method---" + e);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                LOG.error(" method is error---" + e);
            }
        }
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=\"wms" + ts + ".xls\"");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            workbook.write(out);
        } catch (IOException e) {
            LOG.error("io---" + e);
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

    // /**
    // *
    // * 功能描述: 格式化标题<br>
    // * 〈功能详细描述〉
    // *
    // * @param headTitle 标题
    // * @return 标题信息
    // * @see [相关类/方法](可选)
    // * @since [产品/模块版本](可选)
    // */
    // public static String[] getHeadTitleArray(String headTitle) {
    // String[] headTitlen = null;
    // if (!headTitle.isEmpty()) {
    // String headTitleTemp = "";
    // try {
    // headTitleTemp = URLDecoder.decode(headTitle, "UTF-8");
    // } catch (UnsupportedEncodingException e) {
    // logger.error("headTitle---" + headTitle + "encode---" + e);
    // }
    // if (!headTitleTemp.isEmpty()) {
    // headTitlen = headTitleTemp.split(SettlementConstants.COMMA);
    // }
    // }
    // return headTitlen;
    // }
    //
    // public void excelAuditMonth(String[] headTitle, List<?> objectList, HttpServletResponse response) {
    // HSSFWorkbook workbook = new HSSFWorkbook();
    // HSSFSheet sheet = workbook.createSheet(headTitle[0]);
    // HSSFCellStyle style = workbook.createCellStyle();
    // style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    // style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    // // 第一行
    // HSSFRow row = sheet.createRow(0);
    // HSSFCell cell = row.createCell(0);
    // cell.setCellValue(headTitle[1]);
    // // 四个参数分别是：起始行，起始列，结束行，结束列
    // sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 3));
    // cell.setCellStyle(style);
    //
    // cell = row.createCell(4);
    // cell.setCellValue(headTitle[2]);
    // sheet.addMergedRegion(new Region(0, (short) 4, 0, (short) 7));
    // cell.setCellStyle(style);
    //
    // cell = row.createCell(8);
    // cell.setCellValue(headTitle[3]);
    // sheet.addMergedRegion(new Region(0, (short) 8, 0, (short) 11));
    // cell.setCellStyle(style);
    //
    // // 第二行
    // row = sheet.createRow(1);
    // cell = row.createCell(0);
    // cell.setCellValue(headTitle[4]);
    // cell.setCellStyle(style);
    // // 四个参数分别是：起始行，起始列，结束行，结束列
    // sheet.addMergedRegion(new Region(1, (short) 0, 2, (short) 0));
    //
    // cell = row.createCell(1);
    // cell.setCellValue(headTitle[5]);
    // cell.setCellStyle(style);
    // sheet.addMergedRegion(new Region(1, (short) 1, 2, (short) 1));
    //
    // cell = row.createCell(2);
    // cell.setCellValue(headTitle[6]);
    // cell.setCellStyle(style);
    // sheet.addMergedRegion(new Region(1, (short) 2, 2, (short) 2));
    //
    // cell = row.createCell(3);
    // cell.setCellValue(headTitle[7]);
    // cell.setCellStyle(style);
    // sheet.addMergedRegion(new Region(1, (short) 3, 2, (short) 3));
    //
    // String success = headTitle[8];
    // String failure = headTitle[9];
    // cell = row.createCell(4);
    // cell.setCellValue(success);
    // cell.setCellStyle(style);
    // sheet.addMergedRegion(new Region(1, (short) 4, 1, (short) 5));
    //
    // cell = row.createCell(6);
    // cell.setCellValue(failure);
    // cell.setCellStyle(style);
    // sheet.addMergedRegion(new Region(1, (short) 6, 1, (short) 7));
    //
    // cell = row.createCell(8);
    // cell.setCellValue(success);
    // cell.setCellStyle(style);
    // sheet.addMergedRegion(new Region(1, (short) 8, 1, (short) 9));
    //
    // cell = row.createCell(10);
    // cell.setCellValue(failure);
    // cell.setCellStyle(style);
    // sheet.addMergedRegion(new Region(1, (short) 10, 1, (short) 11));
    //
    // String summaryItems = "汇总笔数";
    // String summaryAmount = "汇总金额";
    //
    // // 第三行
    // row = sheet.createRow(2);
    // cell = row.createCell(4);
    // cell.setCellValue(summaryItems);
    // cell.setCellStyle(style);
    // cell = row.createCell(5);
    // cell.setCellValue(summaryAmount);
    // cell.setCellStyle(style);
    //
    // cell = row.createCell(6);
    // cell.setCellValue(summaryItems);
    // cell.setCellStyle(style);
    // cell = row.createCell(7);
    // cell.setCellValue(summaryAmount);
    // cell.setCellStyle(style);
    //
    // cell = row.createCell(8);
    // cell.setCellValue(summaryItems);
    // cell.setCellStyle(style);
    // cell = row.createCell(9);
    // cell.setCellValue(summaryAmount);
    // cell.setCellStyle(style);
    //
    // cell = row.createCell(10);
    // cell.setCellValue(summaryItems);
    // cell.setCellStyle(style);
    // cell = row.createCell(11);
    // cell.setCellValue(summaryAmount);
    // cell.setCellStyle(style);
    // excelData(workbook, sheet, row, cell, objectList, response);
    // }

    // /**
    // *
    // * 功能描述: 导出数据<br>
    // * 〈功能详细描述〉
    // *
    // * @param workbook excel表格
    // * @param sheet 工作簿
    // * @param row 行对象
    // * @param cell 列对象
    // * @param objectList 数据对象
    // * @param response 响应
    // * @see [相关类/方法](可选)
    // * @since [产品/模块版本](可选)
    // */
    // private void excelData(HSSFWorkbook workbook, HSSFSheet sheet, HSSFRow row, HSSFCell cell, List<?> objectList,
    // HttpServletResponse response) {
    // HSSFCellStyle style = workbook.createCellStyle();
    // style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    // style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    // int rowNumber = row.getRowNum() + 1;// 行数
    // ServletOutputStream out = null;
    // try {
    // for (int i = 0; i < objectList.size(); i++) {
    // int rowCell = 0; // 列数
    // row = sheet.createRow(rowNumber);
    //
    // Object obj = objectList.get(i);
    // Class<? extends Object> targetClass = obj.getClass();
    // Field[] fields = targetClass.getDeclaredFields();
    // for (Field field : fields) {
    // PropertyDescriptor pd = new PropertyDescriptor(field.getName(), targetClass);
    // Method method = pd.getReadMethod();
    // Object value = method.invoke(obj);
    // String valusCell = "";
    // cell = row.createCell(rowCell);
    // if (value instanceof Date) {
    // valusCell = DateUtil.formateDateTimeForDay((Date) value);
    // cell.setCellValue(valusCell);
    // } else if (value instanceof Code) {
    // // valusCell = ((Code) value).getName();
    // cell.setCellValue(valusCell);
    // } else {
    // valusCell = String.valueOf(value);
    // cell.setCellValue(valusCell);
    // }
    // cell.setCellStyle(style);
    // rowCell++;
    // }
    // rowNumber++;
    // }
    //
    // Timestamp ts = new Timestamp(System.currentTimeMillis());
    // response.setContentType("application/vnd.ms-excel");
    // response.setHeader("Content-Disposition", "attachment;filename=\"data" + ts + ".xls\"");
    // out = response.getOutputStream();
    // workbook.write(out);
    // } catch (Exception e) {
    // logger.error("exception---" + e);
    // } finally {
    // if (out != null) {
    // try {
    // out.close();
    // } catch (IOException e) {
    // logger.error("io---" + e);
    // }
    // }
    // }
    // }
    /**
     * 
     * 功能描述: 理财人事入职管理下载模板
     * 〈功能详细描述〉
     *
     * @param requirements
     * @param headTitle
     * @param subTitle
     * @param objectList
     * @param sexList
     * @param idCardList
     * @param path
     * @param pathName
     * @param response
     * @param dateFormat
     * @param positionList
     * @param fileName
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void excelEmployeeExoprt(List<String> requirements, String[] headTitle, String[] subTitle,
            List<?> objectList,String[] sexList, String[] idCardList,String[] jobList,String path, String pathName, HttpServletResponse response, String dateFormat,
            String[] levelList,String[] orgList, String fileName) {

        HSSFWorkbook workbook = null;
        workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(pathName);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setLocked(false);
        HSSFDataFormat format = workbook.createDataFormat();
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
                as = headTitle[i].split(WebConstants.HYPHEN);
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
                as = subTitle[i].split(WebConstants.HYPHEN);
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
                            firstLetter = fieldName.substring(0, 1).toUpperCase();
                            getMethodName = "get" + firstLetter + fieldName.substring(1);
                            getMethod = classType.getMethod(getMethodName, new Class[] {});
                            Object value = getMethod.invoke(obj);
                            cell = row.createCell(x++);
                            if ("certNo".equals(fieldName)) {// 若为身份证号则设置CELL格式为文本格式
                                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                style.setDataFormat(format.getFormat("@"));
                                cell.setCellStyle(style);
                                cell.setCellValue(String.valueOf(value));
                                continue;
                            }
                            if ("sexList".equals(fieldName)) {
                                cell.setCellValue("请选择");
                                int naturalRowIndex = 2;
                                int naturalColumnIndex = 2;
                                int firstRow = naturalRowIndex - 1;
                                int lastRow = naturalRowIndex - 1;
                                int firstCol = naturalColumnIndex - 1;
                                int lastCol = naturalColumnIndex - 1;
                                CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol,
                                        lastCol);
//                                    String[] sexList = { "男", "女" };
                                DVConstraint constraint = DVConstraint.createExplicitListConstraint(sexList);
                                // 绑定下拉框和作用区域
                                HSSFDataValidation data_validation = new HSSFDataValidation(regions, constraint);
                                sheet.addValidationData(data_validation);
                                continue;
                            }
                            if ("certTypeList".equals(fieldName)) {
                                cell.setCellValue("请选择");
                                int naturalRowIndex = 2;
                                int naturalColumnIndex = 3;
                                int firstRow = naturalRowIndex - 1;
                                int lastRow = naturalRowIndex - 1;
                                int firstCol = naturalColumnIndex - 1;
                                int lastCol = naturalColumnIndex - 1;
                                CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol,
                                        lastCol);
                                DVConstraint constraint = DVConstraint.createExplicitListConstraint(idCardList);
                                // 绑定下拉框和作用区域
                                HSSFDataValidation data_validation = new HSSFDataValidation(regions, constraint);
                                sheet.addValidationData(data_validation);
                                continue;
                            }
                            if ("levelList".equals(fieldName)) {
                                  cell.setCellValue("请选择");
                                  int naturalRowIndex = 2;
                                  int naturalColumnIndex = 6;
                                  int firstRow = naturalRowIndex - 1;
                                  int lastRow = naturalRowIndex - 1;
                                  int firstCol = naturalColumnIndex - 1;
                                  int lastCol = naturalColumnIndex - 1;
                                  CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol,
                                          lastCol);
                                  DVConstraint constraint = DVConstraint.createExplicitListConstraint(levelList);
                                  // 绑定下拉框和作用区域
                                  HSSFDataValidation data_validation = new HSSFDataValidation(regions, constraint);
                                  sheet.addValidationData(data_validation);
                                  continue;
                              }
                                if ("orgList".equals(fieldName)) {
                                  cell.setCellValue("请选择");
                                  int naturalRowIndex = 2;
                                  int naturalColumnIndex = 7;
                                  int firstRow = naturalRowIndex - 1;
                                  int lastRow = naturalRowIndex - 1;
                                  int firstCol = naturalColumnIndex - 1;
                                  int lastCol = naturalColumnIndex - 1;
                                  CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol,
                                          lastCol);
                                  DVConstraint constraint = DVConstraint.createExplicitListConstraint(orgList);
                                  // 绑定下拉框和作用区域
                                  HSSFDataValidation data_validation = new HSSFDataValidation(regions, constraint);
                                  sheet.addValidationData(data_validation);
                                  continue;
                              }
                            if ("jobCategory".equals(fieldName)) {
                                cell.setCellValue("请选择");
                                int naturalRowIndex = 2;
                                int naturalColumnIndex = 8;
                                int firstRow = naturalRowIndex - 1;
                                int lastRow = naturalRowIndex - 1;
                                int firstCol = naturalColumnIndex - 1;
                                int lastCol = naturalColumnIndex - 1;
                                CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol,
                                        lastCol);
                                DVConstraint constraint = DVConstraint.createExplicitListConstraint(jobList);
                                // 绑定下拉框和作用区域
                                HSSFDataValidation data_validation = new HSSFDataValidation(regions, constraint);
                                sheet.addValidationData(data_validation);
                                continue;
                            }
                            if ("name".equals(fieldName)|| "proBasicSalary".equals(fieldName)
                                    || "proPerformanceSalary".equals(fieldName) || "regularBasicSalary".equals(fieldName)
                                    || "regularPerformanceSalary".equals(fieldName)) {// 设置日期为文本格式
                                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                style.setDataFormat(format.getFormat("@"));
                                cell.setCellStyle(style);
                                cell.setCellValue(String.valueOf(value));
                                continue;
                            }
                            if (value instanceof Date) {
                                String dateStr = DateUtils.format((Date) value, dateFormat);
                                cell.setCellValue(dateStr);
                                cell.setCellType(Cell.CELL_TYPE_STRING);
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
                    LOG.error("no this method---" + e);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    LOG.error(" method is error---" + e);
                }
            }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + ".xls\"");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            workbook.write(out);
        } catch (IOException e) {
            LOG.error("io---" + e);
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
}
