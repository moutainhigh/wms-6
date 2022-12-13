/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: InterestPrincipalDto.java
 * Author:   蔡登勇
 * Date:     2015年8月3日 下午3:39:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dx.common.service.utils.MathUtils;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RepaymentDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -3582416562405772891L;

    private BigDecimal interest;

    private BigDecimal principal;

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public RepaymentDto(BigDecimal interest, BigDecimal arg) {
        this.interest = interest;
        this.principal = MathUtils.sub(arg, interest).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}
