/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: BankVo.java
 * Author:   yangbao
 * Date:     2016年3月9日 下午3:16:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.vo;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉根据银行code,开户省、市code查询所在地支行 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BankVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 银行code
     */
    private String bankCode;
    
    /**
     * 开户省code
     */
    private String provinceCode;
    
    /**
     * 开户市code
     */
    private String cityCode;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

}
