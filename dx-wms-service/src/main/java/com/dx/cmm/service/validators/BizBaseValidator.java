package com.dx.cmm.service.validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.dto.BizBase;
import com.dx.cmm.exception.ParamException;
import com.dx.cmm.service.intf.IMatchBizBaseService;
import com.dx.common.service.utils.Assert;
import com.dx.op.service.intf.IProductService;

public abstract class BizBaseValidator extends ValidatorRegister {

    @Autowired
    public IMatchBizBaseService matchBizBaseService;

    @Autowired
    public IProductService productService;

    public ParamException error(String msg, String code) {
        return super.error("Biz code[{0}] ".concat(msg), code);
    }

    public void validate(BizBase base) {
        Assert.notNull(error("Biz id must not be null"), base.getBizId());
        String code = base.getBizCode();
        Assert.notNull(error("Biz code must not be null"), code);
        if (matchBizBaseService.exists(code)) {
            throw error("has exists", code);
        }
        Assert.notNull(error("contract code must not be null", code), base.getBizContractCode());
        Assert.notNull(error("name must not be null", code), base.getCustName());
        Assert.notNull(error("id card must not be null", code), base.getIdCard());
        Assert.notNull(error("address must not be null", code), base.getCustAddress());
        Assert.notNull(error("zip code must not be null", code), base.getZipCode());
        Assert.notNull(error("email must not be null", code), base.getEmail());
        Assert.notNull(error("product id must not be null", code), base.getBizProductId());
        Assert.notNull(error("total amount must not be null", code), base.getBizTotalAmount());
        Assert.notNull(error("begin date must not be null", code), base.getBizDateBegin());
        Assert.notNull(error("end date must not be null", code), base.getBizDateEnd());
        Assert.notNull(error("cust category must not be null", code), base.getCustCategory());
        Assert.notNull(error("org id must not be null", code), base.getOrgId());
        Assert.notNull(error("sign date must not be null", code), base.getSignDate());
        Assert.notNull(error("apply date must not be null", code), base.getApplyDate());
        Assert.notNull(error("action user must not be null", code), base.getActionUser());

    }
}
