/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: InvestChangeParam.java
 * Author:   朱道灵
 * Date:     2016年5月8日 上午11:47:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.invest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 朱道灵
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InvestUpdateParam extends InvestBaseParam{

    /**
     * 
     */
    private static final long serialVersionUID = 9221463914175174706L;
    
    /**
     * 客户姓名
     */
    private String custName;

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

}
