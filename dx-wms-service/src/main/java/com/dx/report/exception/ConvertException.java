package com.dx.report.exception;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 〈一句话功能简述〉类型转换异常
 *
 * @author zhuyiwei 
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ConvertException extends BaseException{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	
	 public ConvertException(String logMsg){
	        super(logMsg);
	    }
	 
	 public ConvertException(String code,String logMsg,Throwable cause){
	        super(code,logMsg,cause);
	    }
}
