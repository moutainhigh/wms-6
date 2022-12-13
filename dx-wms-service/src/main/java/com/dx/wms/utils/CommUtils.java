package com.dx.wms.utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.dx.common.service.utils.Assert;
import com.dx.wms.utils.exection.ConvertException;


public class CommUtils {

	/*
	 * 多个流关闭
	 */
	public static void close(String code,Closeable... streams) throws ConvertException{
		try {
			for (Closeable s : streams) {
				if (s != null)
					s.close();
			}
		} catch (IOException ioe) {
			if(Assert.checkParam(code)){
				throw new ConvertException(code,"流关闭异常");
			}
			throw new ConvertException("流关闭异常");
		}
	}
	
	public static void close(Closeable... streams) throws ConvertException{
		close(null,streams);
	}
	
	/**
	 * 
	 * 功能描述: <br>
	 * 			删除文件,并抛出指定异常
	 *
	 * @param path 预删除文件路径
	 * @param code 异常code
	 * @param msg 异常信息
	 * @throws ConvertException
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public static void exection(String path,String code, String msg,Throwable cause) throws ConvertException{
		if(Assert.checkParam(path)){
			File file = new File(path);
			if(file.exists()){
				FileUtils.deleteQuietly(file);
			}
		}
		throw new ConvertException(code,msg,cause);
	}
	
	public static void exection(String code, String msg,Throwable cause) throws ConvertException{
		exection(null,code,msg,cause);
	}
}
