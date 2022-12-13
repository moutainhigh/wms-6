package com.dx.wms.service.model;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.dx.ccs.vo.RoleVo;
import com.dx.hr.service.dto.EmployeeEntryDto;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.saver.ResultSaver;

public interface Model_ {

    // 性别
    public static final String SEX = "sex";

    // 学历
    public static final String EDUCATION = "education";
    // 证件类型
    public static final String ID_TYPE = "idType";

    // 婚姻状况
    public static final String MARITAL_STATUS = "maritalStatus";

    // 职业
    public static final String PROFESSION = "profession";

    // 接受文件方式
    public static final String MSG_WAY = "msgWay";

    // 客户来源
    public static final String CUST_SOURCE = "custSource";

    // 客户分类
    public static final String CUST_CATEGORY = "custCategory";

    // 省份
    public static final String AREAS = "areas";

    // 回收方式
    public static final String RECOVERY_MODE = "recoveryMode";

    // 支付方式
    public static final String PAY_WAY = "payWay";

    // 出借方式
    public static final String PRODUCT = "product";

    // 银行
    public static final String BANK_CATEGORY = "bankCategory";

    // 出借金额
    public static final String AMOUNT_AREA = "amountArea";

    // 营业部
    public static final String ORG = "department";

    // 账单日
    public static final String BILL_DAY = "billDay";

    // 当前环节
    public static final String CURRENT_STEP = "currentStep";

    // 账户状态
    public static final String ACCOUNT_STATUS = "accountStatus";

    // 人事预入职员工任职部门
    public static final String DEPARTMENT = "department";

    // 人事入职员工证件类型
    public static final String CERT_TYPE = "certType";

    // 人事入职员工性别
    public static final String SEX_TYPE = "sexType";

    // 人事入职员工婚姻
    public static final String MARRIAGE = "marriage";

    // 人事入职员工国籍
    public static final String COUNTRY = "country";

    // 人事入职员工民族
    public static final String NATION = "nation";

    // 人事入职员工工作单位
    public static final String WORKUNIT = "workUnit";

    // 人事入职员工政治面貌
    public static final String POLITICAL_STATUS = "politicalStatus";

    // 人事入职员工文化程度
    public static final String HR_EDUCTION = "hrEducation";

    // 人事入职员工工作性质
    public static final String JOB_CATEGORY = "jobCategory";

    // 人事入职员工户籍性质
    public static final String CENSUS = "census";

    // 人事入职员工入职来源
    public static final String ENTRY_SOURCE = "entrySource";

    // 人事入职员工状态
    public static final String EMPLOYEE_STATUS = "employeeStatus";

    // 人事入职员工称谓
    public static final String RELATION_SHIP = "relationShip";

    // 人事入职员工学校情况
    public static final String GRADUATE_TYPE = "graduateType";

    // 人事入职员工公积金缴纳地
    public static final String INSURED_CITY = "insuredCity";

    /**
     * 
     * 功能描述: 获取客户开户时需要的model
     *
     * @param custAccountApplyDto
     * @return
     */
    void putCustAccount(CustAccountApplyDto custAccountApplyDto, ModelMap model);

    /**
     * 
     * 功能描述: 获取客户理财申请时需要的model 〈功能详细描述〉
     *
     * @param custAccountApplyDto
     * @param model
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void putCustAccountApply(CustAccountApplyDto custAccountApplyDto, ModelMap model);

    /**
     * 
     * 功能描述: 变更的Model 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void putChange(ModelMap model);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param model
     */
    void put(ModelMap model, String... keys);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param model
     * @param result
     */
    void put(ModelMap model, Map<String, Object> result);

    /**
     * 
     * 功能描述: 入职获取省市区 〈功能详细描述〉
     *
     * @param model
     * @param entryDto
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void putEmployee(ModelMap model, EmployeeEntryDto entryDto);

    /**
     * 
     * 功能描述: 人事系统list查询页面的model 〈功能详细描述〉
     *
     * @param biz
     * @param userId
     * @param roleVos
     * @param model
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void putListModel(String biz, Long userId, List<RoleVo> roleVos, ModelMap model);

    /**
     * 
     * 功能描述: 保存界面用的model 〈功能详细描述〉
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void putSaveModel(ResultSaver saveDto, ModelMap model);
}
