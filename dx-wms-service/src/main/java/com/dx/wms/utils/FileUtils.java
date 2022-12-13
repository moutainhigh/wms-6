package com.dx.wms.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.framework.exception.BaseException;
import com.dx.framework.uts.util.StringUtils;


public class FileUtils {
	
	private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);
	
	/**
	 * 
	 * 功能描述: <br>
	 * 文件下载
	 *
	 * @param response
	 * 		请求响应对象
	 * @param sourcePath
	 * 		资源路径
	 * @param fileName
	 * 		下载文件名
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@SuppressWarnings("resource")
	public static void download(HttpServletResponse response,String sourcePath,String fileName ){
		LOG.info("**fileDownload() sourcePath={},fileName={}",sourcePath,fileName); 
		File file = new File(sourcePath);
		if (file.exists()) {
			//设置类型为下载
			response.setContentType("application/x-msdownload");
			String downFileName ;
			if(StringUtils.equalsIgnoreCase("", fileName)||fileName == null){
				downFileName = file.getName();
			}else{
				downFileName = fileName+file.getName().substring(file.getName().indexOf("."));
			}
			//设置文件名
			try {
				//对应浏览器的字符集(页面默认iso8859-1)
				response.setHeader("Content-Disposition", "attachment; filename="+ new String(downFileName.getBytes("utf-8"),"iso8859-1"));
			} catch (UnsupportedEncodingException e1) {
				throw new BaseException("字符编码转换错误");
			}
			InputStream ins = null;
			try {
				ins = new FileInputStream(sourcePath);
			} catch (FileNotFoundException e) {
				throw new BaseException("资源文件读取错误");
			}
			BufferedInputStream bis = new BufferedInputStream(ins);
			OutputStream outs = null;
			try {
				outs = response.getOutputStream();
			} catch (IOException e) {
				throw new BaseException("流初始化异常");
			}
			BufferedOutputStream bos = new BufferedOutputStream(outs);
			int index = 0;
			byte[] buffer = new byte[1024*1024];
			try {
				while ((index = bis.read(buffer, 0, 1024*1024)) != -1) {
					bos.write(buffer, 0, index);
				}
			} catch (IOException e) {
				throw new  BaseException("文件写入进程错误");
			}
			//缓冲数据写出,保证数据完整
			try {
				bos.flush();
			} catch (IOException e) {
				throw new  BaseException("flush() 文件写入进程错误");
			}
			//关闭流
			CommUtils.close(bis,ins,bos,outs);
			org.apache.commons.io.FileUtils.deleteQuietly(new File(sourcePath));
		} else {
			throw new BaseException("资源不存在或已删除");
		}

	}
	
	public static void download(HttpServletResponse response,String sourcePath ){
		download(response,sourcePath,null);
	}

}
