package com.dx.wms.service.model;

import org.springframework.ui.ModelMap;

import com.dx.wms.service.common.DataService;

/**
 * 
 * 模型
 *
 * @author tony
 */
public interface Model extends DataService<ParamModel> {

    /**
     * 性别
     */
    public static final String SEX = "sex";

    /**
     * 学历
     */
    public static final String EDUCATION = "education";

    /**
     * 证件类型
     */
    public static final String ID_TYPE = "idType";

    /**
     * 婚姻状况
     */
    public static final String MARITAL_STATUS = "maritalStatus";

    /**
     * 职业
     */
    public static final String PROFESSION = "profession";

    /**
     * 接受文件方式
     */
    public static final String MSG_WAY = "msgWay";

    /**
     * 客户来源
     */
    public static final String CUST_SOURCE = "custSource";

    /**
     * 客户分类
     */
    public static final String CUST_CATEGORY = "custCategory";

    /**
     * 省份
     */
    public static final String AREAS = "areas";

    /**
     * 回收方式
     */
    public static final String RECOVERY_MODE = "recoveryMode";

    /**
     * 支付方式
     */
    public static final String PAY_WAY = "payWay";
    
    
    /**
     *  出借方式
     */
    public static final String PRODUCT = "product";
    
    /**
     * 包含生效未生效出借方式
     */
    public static final String PRODUCTALL = "productAll";

    /**
     *  银行
     */
    public static final String BANK_CATEGORY = "bankCategory";

    /**
     *  出借金额
     */
    public static final String AMOUNT_AREA = "amountArea";

    /**
     *  营业部
     */
    public static final String ORG = "org";

    /**
     *  账单日
     */
    public static final String BILL_DAY = "billDay";

    /**
     *  当前环节
     */
    public static final String CURRENT_STEP = "currentStep";

    /**
     *  账户状态
     */
    public static final String ACCOUNT_STATUS = "accountStatus";
    
    /**
     *  资源-标示 
     */
    public static final String RESKEY = "resKey";

    /**
     * 
     * 初始化
     *
     * @param param
     * @param map
     * @return
     */
    ModelMap init(ParamModel param, ModelMap map);
}
