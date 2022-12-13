/*
 * Copyright (C), 2014-2015, 达信财富投资管理（上海）有限公司
 * FileName: CCSConstants.java
 * Author:   chenggang
 * Date:     2015年02月11日 上午11:20:05
 * Description: 流程信息维护   
 * History: 修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.constant;

/**
 * 
 * WMS常量
 * 
 * @author chenggang
 */
public final class CMSConstants {
    /** 点 */
    public static final String POINT = ".";

    /** 逗号 */
    public static final String COMMA = ",";

    /** 空字符串 */
    public static final String EMPTY_STRING = "";

    /** 文件类型 */
    public static final String JPG = "jpg";
    public static final String POINT_JPG = ".jpg";

    public static final String PDF = "pdf";
    public static final String POINT_PDF = ".pdf";

    public static final String PNG = "png";
    public static final String POINT_PNG = ".png";

    public static final String SWF = "swf";
    public static final String SWF_TYPE = ".swf";

    public static final String RAR = "rar";
    
    // APP_CODE
    public static final String CMS_APP_CODE = "appCode";
    /**
     * 理财端-系统标示
     */
    public static final String APP_CODE_WMS = "wms";
    public static final String APP_CODE_HR = "hr";
    
    
    // RES_KEY
    public static final String RES_KEY = "resKey";
    
    // CM_ACTION
    public static final String CM_ACTION = "cmAction";
    /**
     *  理财端-客户开户申请
     */
    public static final String WMS_CUST_OPEN_APPLY = "wmsCustOpenApply";

    /**
     *  理财端-客户理财申请
     */
    public static final String WMS_CUST_LENDER_APPLY = "wmsCustLenderApply";

    /**
     *  理财端-理财申请单质检、审核
     */
    public static final String WMS_LENDER_CHECK = "wmsLenderCheck";

    /**
     *  理财端-支付凭证
     */
    public static final String WMS_PAYMENT_VOUCHERS = "wmsPaymentVouchers";
    
    /**
     * 删除文件 标示
     */
    public static final String DELETE_FILE = "deleteFile";
    
    /**
     * 文件生效 标示
     */
    public static final String CMS_CMACTION_EFFECTIVE_FILES = "createAccount";
    
    /**
     * 根据目录(文件夹)查询文件 标示
     */
    public static final String CMS_CMACTION_QUERY_FILES = "getFileStoreFile";
    
    /**
     * 查询文件夹 标示
     */
    public static final String CMS_CMACTION_QUERY_FOLDERS = "getFileStoreDirectory";
    
    /**
     * 根据文件id来查询文件信息 标示
     */
    public static final String CMS_CMACTION_QUERY_FILE_INFO_BY_ID = "getFileURLById";
    
    /**
     * 根据文件ids来查询文件信息 标示
     */
    public static final String CMS_CMACTION_QUERY_FILES_INFO_BY_IDS = "getFileURLsByIds";
    
    /**
     * 查询支付凭证 标示
     */
    public static final String CMS_CMACTION_QUERY_VOUCHER_PAYMENT = "getVoucherPaymentFiles";
    
    /**
     * 上传文件 标示
     */
    public static final String UPLOAD_FILES = "uploadFile";
    
    // ACTION
    public static final String CMS_ACTION = "action";
    /**
     * 生效用户文件
     */
    public static final String CMS_WMS_ACTION_USER_ACCOUNT = "createUserAccount";
    
    /**
     * 生效业务文件
     */
    public static final String CMS_WMS_ACTION_BIZ_ACCOUNT = "submitToSalesService";
    
    public static final String ACTION_CODE = "actioncode";
    
    public static final String ACTION_MESSAGE = "actionmessage";
    
    public static final String RAR_FILE_TYPES = "RAR_FILE_TYPES";
    
    public static final String OTHER_FILE_TYPES = "OTHER_FILE_TYPES";
    
    public static final String ALL_FILE_TYPES = "ALL_FILE_TYPES";
    
    /**
     * 人事影像文件存储基本路径
     */
    public static final String HR_FILE_PATH = "/var/www/hrvideo/";
    
    /**
     * 理财影像文件存储基本路径
     */
    public static final String WMS_FILE_PATH = "/var/www/wmsres/";

    /**
     * 构造器
     */
    private CMSConstants() {

    }
}
