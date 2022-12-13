package com.dx.cmm.service.validators;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.BizBase;
import com.dx.cmm.exception.ParamException;
import com.dx.common.service.utils.Assert;

@Service
public class InvestValidator extends BizBaseValidator {

    @Override
    public Boolean supports(Object param) {
        return BizBase.class.equals(param.getClass());
    }

    @Override
    public void validate(Object param) throws ParamException {
        BizBase base = (BizBase) param;
        validate(base);
        if (!base.getBizCode().startsWith("L0")) {
            throw error("is illegal", base.getBizCode());
        }
        Assert.notNull(error("Cust code must not be null"), base.getCustCode());
        Assert.notNull(error("Biz cust code must not be null"), base.getBizCustCode());
        Map<String, String> products = productService.getProductByApp("wms");
        Assert.notNull(error("product must be lender's productss"), products.get(base.getBizProductId().toString()));
        Assert.notNull(error("attr must be not null", base.getBizCode()), base.getInvestAttr());
    }

}
