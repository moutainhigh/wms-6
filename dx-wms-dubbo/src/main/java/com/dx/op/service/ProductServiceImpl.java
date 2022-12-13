package com.dx.op.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.redis.client.IRedisClient;
import com.dx.op.service.dao.IProductDao;
import com.dx.op.service.dao.IProductDetailDao;
import com.dx.op.service.entity.Product;
import com.dx.wms.constant.ProductConstant;
import com.dx.wms.dto.ProductDetailDto;
import com.dx.wms.dto.ProductDto;
import com.dx.wms.dto.ProductQueryDto;
import com.dx.wms.service.IProductService;
import com.dx.wms.service.exception.ProductIPisErrorException;

public class ProductServiceImpl implements IProductService {

	/**
	 * 日志组件
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

	/** 产品Dao层 */
	@Autowired
	private IProductDao productDao;

	/** 产品明细Dao层 */
	@Autowired
	private IProductDetailDao productDetailDao;

	/**
	 * 缓存服务
	 */
	@Autowired
	private IRedisClient wmsRedisClient;

	/**
	 * 一天的时间，单位是秒 1day:86400s,4hs:14400s
	 */
	private static final int ONE_DAY_SEC = 14400;

	private static final String APP_ID_KEY = "getProductByAppAndProductId:";

	private static final String APP_KEY = "queryByApp:";

	private static final String APP_KEY_OPERANT = "queryByAppAndOperant:";

	private static final String ID_KEY = "queryByProductId:";

	private static final String USUAL = "usual";

	private static final String TRANS = "trans";

	private String getCache(String key) {
		try {
			return wmsRedisClient.get(key);
		} catch (Exception e) {
			LOG.error("error:{}", e.getMessage());
			return "";
		}
	}

	private void putCache(String key, Object value) {
		try {
			wmsRedisClient.setex(key, ONE_DAY_SEC, JSON.toJSONString(value));
		} catch (Exception e) {
			LOG.error("error:{}", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getProductByAppAndProductId(String appCode, Long productId) {
		Assert.notNull("App code must not be null", appCode);
		Assert.notNull(false, new ProductIPisErrorException("Product id must not be null"), productId);
		LOG.info("App code is [{}],productId is [{}]", appCode, productId);
		String key = APP_ID_KEY + appCode + productId;
		String valStr = getCache(key);
		LOG.debug("Val is [{}]", valStr);
		if (StringUtils.isNotBlank(valStr) && !StringUtils.equals(valStr, "null")) {
			return JSON.parseObject(valStr, Map.class);
		}
		Map<String, String> map = MapUtils.list2Map(productDao.getProductByAppAndProductId(appCode, productId),
				"productId", "productName");
		putCache(key, map);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getAllProductByApp(String appCode, Boolean isOperant) {
		Assert.notNull("App code must not be null", appCode);
		if (!Assert.checkParam(isOperant)) {
			return getProductByAppAndProductId(appCode, -1L);
		} else {
			String key = APP_KEY_OPERANT + appCode;
			String valStr = getCache(key);
			LOG.debug("Val is [{}]", valStr);
			if (StringUtils.isNotBlank(valStr) && !StringUtils.equals(valStr, "null")) {
				return JSON.parseObject(valStr, Map.class);
			}
			Map<String, String> map = MapUtils.list2Map(productDao.getAllProductByApp(appCode), "productId",
					"productName");
			putCache(key, map);
			return map;
		}
	}

	@Override
	public ProductDto queryByProductId(String appCode, Long productId) {
		Assert.notNull("**queryByProductId() 应用Code不能为空**", appCode);
		Assert.notNull("**queryByProductId() 产品Id不能为空**", productId);
		LOG.info("**queryByProductId** appcode:{},productId:{}", appCode, productId);
		String key = ID_KEY + appCode + productId;
		String valStr = getCache(key);
		LOG.debug("**valStr**" + valStr);
		ProductDto productDto = null;
		if (StringUtils.isNotBlank(valStr) && !StringUtils.equals(valStr, "null")) {
			LOG.debug("**ProductDto cache**");
			productDto = JSON.parseObject(valStr, ProductDto.class);
		}
		if (productDto == null) {
			productDto = getProductDto(productId);
			LOG.info("**parent productId is {}**", productDto.getUpProductId());
			productDto.setParentProductDto(Assert.checkParam(productDto.getUpProductId())
					? getProductDto(productDto.getUpProductId()) : new ProductDto());
			putCache(key, productDto);
		}
		if (appCode.equals(ProductConstant.CCS_SYSTEM) && !Assert.checkParam(productDto.getSynthesizeRatios())) {
			LOG.info("**ccs product not find synthesizeRatio**");
			throw new ProductIPisErrorException("信贷产品未配置综合费率");
		}
		if (appCode.equals(ProductConstant.WMS_SYSTEM) && !Assert.checkParam(productDto.getPeriods())) {
			LOG.info("**wms product not find period**");
			throw new ProductIPisErrorException("理财产品未配置封闭期");
		}
		return productDto;
	}

	private ProductDto getProductDto(Long productId) {
		Product product = productDao.queryById(Product.class, productId);
		return getProductDto(product, null);
	}

	private ProductDto getProductDto(Product product, Boolean flag) {
		Assert.notNull("**getProductDto(Product product) product can not be null**", product);
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);

		List<ProductDetailDto> productDetailDtos = productDetailDao
				.queryProductDetailDtosByProductId(product.getProductId(), getPeriodRule(product, flag));
		Assert.notNull("**getProductDto(Long productId) 没有找到明细配置**", productDetailDtos);
		List<BigDecimal> synthesizeRatios = new ArrayList<BigDecimal>();
		List<Integer> periods = new ArrayList<Integer>();
		for (ProductDetailDto pdd : productDetailDtos) {
			if (pdd.getDetailKey().equals("synthesizeRatio")) {
				synthesizeRatios.add(new BigDecimal(pdd.getDetailRelationVal()));
			}
			if (pdd.getDetailKey().equals("period")) {
				periods.add(Integer.valueOf(pdd.getDetailRelationVal()));
			}
		}
		productDto.setSynthesizeRatios(synthesizeRatios);
		productDto.setPeriods(periods);
		return productDto;
	}

	@Override
	public List<ProductDto> queryByApp(String appCode) {
		Assert.notNull("App code must not be null", appCode);
		LOG.info("App code[{}]", appCode);
		String key = APP_KEY + appCode;
		String valStr = getCache(key);
		LOG.debug("**valStr**{}", valStr);
		if (StringUtils.isNotBlank(valStr) && !StringUtils.equals(valStr, "null")) {
			LOG.debug("**ProductDto cache**");
			return JSON.parseArray(valStr, ProductDto.class);
		}
		List<Product> products = productDao.getProductByApp(appCode);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product p : products) {
			productDtos.add(getProductDto(p, null));
		}
		putCache(key, productDtos);
		return productDtos;
	}

	@Override
	public List<ProductDto> queryByDtos(ProductQueryDto productQueryDto) {
		Assert.notNull("**queryByDto() productQueryDto can not be null**", productQueryDto);
		Assert.notNull("**queryByDto() appCode can not be null**", productQueryDto.getAppCode());
		// Assert.notNull("**queryByDto() productId can not be
		// null**",productQueryDto.getProductId());
		if (productQueryDto.getProductId() == null) {
			throw new ProductIPisErrorException("**getProductByAppAndProductId()  productId is null**");
		}
		if (ProductConstant.CCS_SYSTEM.equals(productQueryDto.getAppCode())) {
			Assert.notNull("**queryByDto() amount can not be null**", productQueryDto.getAmount());
		}
		Boolean flag = false;
		if (!Assert.checkParam(productQueryDto.getAmount().compareTo(new BigDecimal("20000")))) {
			flag = true;
		}
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product p : productDao.getProductByAppAndProductId(productQueryDto.getAppCode(),
				productQueryDto.getProductId())) {
			productDtos.add(getProductDto(p, flag));
		}
		Assert.notNull("**queryByDto() product not found**", productDtos);
		return productDtos;
	}

	private String getPeriodRule(Product product, Boolean flag) {
		String status = "";

		if (flag != null && flag) {
			status = "A";
			if ((product.getProductId() == 27 || product.getProductId() == 28) || product.getProductId() == 5) {
				status = "S";
			}
		}
		return status;
	}

	@Override
	public Map<Long, String> query(String app) {
		Assert.notNull("App must not be null", app);
		Map<Long, String> result = new HashMap<>();
		List<ProductDto> produtcts = queryByApp(app);
		for (ProductDto product : produtcts) {
			result.put(product.getProductId(), product.getProductName());
		}
		return result;
	}

	@Override
	public Map<Long, String> queryAll() {
		Map<Long, String> result = new HashMap<Long, String>();
		result.putAll(query("ccs"));
		result.putAll(query("wms"));
		return result;
	}

	@Override
	public Map<String, String> getUsualProductByApp(String appCode) {
		Assert.notNull("App code must not be null", appCode);
		if(!Assert.equals(appCode.toUpperCase(),"WMS")){
			return new TreeMap<>();
		}
		return getProductMap(appCode, USUAL, productDao.getUsualProduct(appCode));
	}

	@Override
	public Map<String, String> getTransProductByApp(String appCode) {
		Assert.notNull("App code must not be null", appCode);
		if(!Assert.equals(appCode.toUpperCase(),"WMS")){
			return new TreeMap<>();
		}
		return getProductMap(appCode, TRANS, productDao.getTransProduct(appCode));
	}

	@SuppressWarnings("unchecked")
	private Map<String, String> getProductMap(String appCode, String biz, List<Product> products) {
		Assert.notNull("products must not be null", products);
		LOG.info("App code is [{}],productId is [{}]", appCode);
		String key = appCode +":" + biz;
		String valStr = getCache(key);
		LOG.debug("Val is [{}]", valStr);
		if (StringUtils.isNotBlank(valStr) && !StringUtils.equals(valStr, "null")) {
			return JSON.parseObject(valStr, Map.class);
		}
		Map<String, String> map = MapUtils.list2Map(products, "productId", "productName");
		putCache(key, map);
		return map;
	}

}
