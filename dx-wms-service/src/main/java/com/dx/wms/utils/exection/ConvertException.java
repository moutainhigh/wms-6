package com.dx.wms.utils.exection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.framework.exception.BaseException;
import com.dx.wms.utils.ZipUtils;

/**
 * 
 * 〈一句话功能简述〉类型转换异常
 *
 * @author zhuyiwei
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ConvertException extends BaseException {

	/**
	 */
	private static final long serialVersionUID = 1L;
	

	public ConvertException(String logMsg) {
		super(logMsg);
	}

	public ConvertException(String code, String logMsg, Throwable cause) {
		super(code, logMsg, cause);
	}
	
	/*
	 * 1.pdf 生成异常 2. zip 压缩异常   3.填充模板异常 ---code 4.解压 zip 异常
	 */
	public ConvertException(String code, String logMsg) {
		super(code, logMsg);
	}
	
	public ConvertException(String code, Throwable cause) {
		super(code, cause);
	}
}
