package com.dx.op.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.calc.L007IncomeCalc;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.op.service.dao.IProductDao;
import com.dx.op.service.dao.IProductDetailRelationDao;
import com.dx.op.service.entity.ProductDetailRelation;
import com.dx.op.service.intf.IProductService;

/**
 * 
 * 产品服务
 *
 * @author tony
 */
@Service
public class ProductServiceImpl implements IProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    private static final String TRUE = "true";

    private static final String IS_FIX = "isFix";

    private static final String RATE_YEAR = "rateYear";

    private static final String RATE_MONTH = "rateMonth";
    
    private static final Long L007 = 34L;

    @Autowired
    private IProductDao productDao;

    @Autowired
    private IProductDetailRelationDao productDetailRelationDao;

    @Override
    public Map<String, String> getProductByApp(String appCode) {
        return MapUtils.list2Map(productDao.getProductByApp(appCode), "productId", "productName");
    }

    @Override
    public Boolean isFix(Long id) {
        Assert.checkParam("Product id must not be null", id);
        ProductDetailRelation detail = productDetailRelationDao.query(id, IS_FIX);
        Assert.notNull("Detail must not be null", detail);
        LOG.debug("Product Id[{}],fix attr[{}],fix result[{}]", id, detail.getProductDetailRelationVal(),
                detail.getProductDetailRelationVal());
        return Assert.equals(TRUE, detail.getProductDetailRelationVal());
    }

    @Override
    public BigDecimal getRateYear(Long productId, Date refDate,BigDecimal money) {
    	if (Assert.equals(L007,productId)) {
			return money.compareTo(new BigDecimal("500000")) >= 0 ? new BigDecimal("0.114")
	                : new BigDecimal("0.108");
		}
        BigDecimal rate = BigDecimal.ZERO;
        if (!isFix(productId)) {
            return rate;
        }
        return getRate(productId, RATE_YEAR, refDate);
    }

    @Override
    public BigDecimal getRateMonth(Long productId, Date refDate,BigDecimal money) {
    	if (Assert.equals(L007,productId)) {
			return money.compareTo(new BigDecimal("500000")) >= 0 ? new BigDecimal("0.0095")
	                : new BigDecimal("0.0090");
		}
        BigDecimal rate = BigDecimal.ZERO;
        if (!isFix(productId)) {
            return rate;
        }
        return getRate(productId, RATE_MONTH, refDate);
    }

    private BigDecimal getRate(Long productId, String key, Date refDate) {
        BigDecimal rate = BigDecimal.ZERO;
        if (!isFix(productId)) {
            return rate;
        }
        List<ProductDetailRelation> details = productDetailRelationDao.queryArray(productId, key);
        for (ProductDetailRelation detail : details) {
            if (!Assert.checkParam(detail.getValidDateEnd()) && !Assert.checkParam(detail.getValidDateBegin())) {
                return new BigDecimal(detail.getProductDetailRelationVal());
            }
            if (Assert.checkParam(detail.getValidDateEnd()) && refDate.compareTo(detail.getValidDateEnd()) < 0) {
                return new BigDecimal(detail.getProductDetailRelationVal());
            }
            if (Assert.checkParam(detail.getValidDateBegin()) && refDate.compareTo(detail.getValidDateBegin()) >= 0) {
                return new BigDecimal(detail.getProductDetailRelationVal());
            }

        }
        return rate;
    }
}
