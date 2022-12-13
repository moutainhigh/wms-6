package com.dx.wms.report;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.dto.ReportParamDto;
import com.dx.wms.utils.ZipUtils;
import com.dx.wms.utils.exection.ConvertException;

@Service
public class ReportManager {
	
	/**
	 * 日志组件
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ReportManager.class);
	
	@Autowired
	private ReportRouters routers;

	@SuppressWarnings("unchecked")
	public  <P, R> List<String> pdf( ReportParamDto<P, R> param) throws ConvertException{
		Assert.notNull("**pdf() param is can not be null",param);
		LOG.info("**pdf() param={},reportType={},path={},realAddress{}",param.getParam(),param.getReportType(),param.getPath(),param.getRealAddress());
		param.setView(false);
		routers.execute(param);
		Assert.notNull("**pdf result is can not be null",param.getResult());
		return (List<String>) param.getResult();
	}
	
	public <P, R> Map<String, Object> view(ReportParamDto<P, R> param) throws ConvertException{
		Assert.notNull("**view() param is can not be null",param);
		LOG.info("**view() param={},reportType={}",param.getParam(),param.getReportType());
		param.setView(true);
		routers.execute(param);
//		Assert.notNull("**view() result is can not be null",param.getTemplatePath(),param.getResult());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("url", param.getTemplatePath());
		result.put("result", param.getResult().get(0));
		return result;
	}
	
	public  <P> String zip(List<String> urls, String compressPath, String fileName) throws ConvertException{
		Assert.notNull("**zip() urls,compressPath,fileName is can not be null",urls,compressPath,fileName);
		LOG.info("**zip() urls={},compressPath={},fileName={}",urls,compressPath,fileName);
			   String zipPath = ZipUtils.zip(urls, compressPath, fileName);
			   delete(urls);
		return zipPath;
	}
	
	private void delete(List<String> urls){
		for (String url : urls) {
			FileUtils.deleteQuietly(new File(url));
		}
	}
	
}
