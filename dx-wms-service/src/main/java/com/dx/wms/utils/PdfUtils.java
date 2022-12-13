package com.dx.wms.utils;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.pool.impl.GenericObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.dx.cmm.service.pools.Pool;
import com.dx.cmm.util.PathUtil;
import com.dx.common.factory.ITextRendererObjectFactory;
import com.dx.wms.utils.exection.ConvertException;
import com.itextpdf.text.pdf.BaseFont;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class PdfUtils {

	/**
	 * 日志组件
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(PdfUtils.class);

	/**
	 * 生成pdf文件(先生成html)
	 */
	public static void htmlToPdf(String htmlInFile, String pdfOutFile,String realAddress) throws ConvertException{
		//对应预输出文件存在,则直接返回
		if(isExist(pdfOutFile)){
			return;
		}
		String htmlFilePath = htmlName(pdfOutFile);
		html(htmlInFile,htmlName(pdfOutFile));
		FileInputStream in = null;
		try {
			/*
			 * 获得输入流
			 */
			in = new FileInputStream(new File(htmlFilePath));
		} catch (FileNotFoundException e) {
			throw new ConvertException("1", "流文件不存在",e);
		}
		pdf(in, pdfOutFile,realAddress);
	}

	/**
	 * 生成pdf文件(直接根据html内容)
	 */
	public static void pdf(String htmlContent, String pdfOutFile, String realAddress) throws ConvertException{
		if(isExist(pdfOutFile)){
			org.apache.commons.io.FileUtils.deleteQuietly(new File(pdfOutFile));
		}
		InputStream in = null;
		try {
			in = new ByteArrayInputStream(htmlContent.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new ConvertException("1", "流创建异常",e);
		}
		pdf(in, pdfOutFile,realAddress);
	}

	@SuppressWarnings("unchecked")
	private static void pdf(InputStream in, String pdfOutFile, String realAddress) throws ConvertException{
		ITextRenderer iTextRenderer = null;
		FileOutputStream out = null;
		Document doc = null;
		GenericObjectPool<ITextRenderer> pool =ITextRendererObjectFactory.getObjectPool();
		pool.setTestOnBorrow(true);
		try {
			logger.info("create pdf begin");
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
			.parse(in);
			iTextRenderer = pool.borrowObject();// 获取对象池中对象
			iTextRenderer.setDocument(doc, null);
			//iTextRenderer.getSharedContext().setBaseURL("http://127.0.0.1:8080/");
			iTextRenderer.getSharedContext().setBaseURL(realAddress);
			ITextFontResolver fontResolver = iTextRenderer.getFontResolver();
			fontResolver.addFont(PathUtil.getResourcePath() + "simsun.ttc",
					BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			fontResolver.addFont(PathUtil.getResourcePath() + "msyh.ttf",
					BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			fontResolver.addFont(PathUtil.getResourcePath() + "msyhbd.ttf",
					BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			iTextRenderer.layout();
			iTextRenderer.setListener(new PageListener());
			out = new FileOutputStream(pdfOutFile);
			iTextRenderer.createPDF(out);
			iTextRenderer.finishPDF();
			logger.info("create pdf success");
		} catch (Exception e) {
			logger.error("create pdf error",e);
			try {
				ITextRendererObjectFactory.getObjectPool().invalidateObject(
						iTextRenderer);
			} catch (Exception e1) {
				logger.error("create pdf error",e1);
				throw new ConvertException("1", e1);
			} 
			iTextRenderer = null;	
			throw new ConvertException("1",e);
		}finally{
			try {
				//对象回收(使用完必须回收)
				pool.returnObject(iTextRenderer);
			} catch (Exception e) {
				logger.error("pool return object error: ",e);
			}
			CommUtils.close("1",out,in);
		}
	}
	
	private static void html(String htmlContent,String htmlInFile)throws ConvertException{
    	BufferedWriter bw = null;
    	try { 
        	  File file=new File(htmlInFile);
        	  if(!file.exists()){
        	    file.createNewFile();
			  } 
        	  FileWriter fw = new FileWriter(file.getAbsoluteFile());
        	  bw = new BufferedWriter(fw);
        	  bw.write(htmlContent);
        	  bw.flush();
        	  CommUtils.close(bw);
	     }catch (IOException e) {
			 throw new ConvertException("1", "HTML文件生成异常",e);
		}
	}
	
	/*
	 * 判断文件是否存在
	 */
	private static boolean isExist(String filePath){
		File file = new File(filePath);
		return file.exists();
	}
	
	/*
	 * 获得临时目录文件
	 */
	private static String htmlName(String outPath){
		File file = new File(outPath);
		String htmlPath = file.getParent()+File.separator+"html";
		String fileName = file.getName().substring(0,file.getName().indexOf("."));
		return htmlPath+File.separator+fileName+".HTML";
	}

}
