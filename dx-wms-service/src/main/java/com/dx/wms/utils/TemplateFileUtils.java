package com.dx.wms.utils;

import java.io.IOException;
import java.util.Map;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.dx.common.service.utils.MapUtils;
import com.dx.wms.utils.exection.ConvertException;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TemplateFileUtils{
	
	static final String REPORT = "report";
	
	/**
	 * 
	 * 功能描述: <br>
	 *  传入(数据源,模版) 把填充后的内容以 String 返回
	 *
	 * @param param
	 * @param template
	 * @return
	 * @throws ConvertException
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public static String fill(Object param,Template template) throws ConvertException{
            Map<String, Object> model = MapUtils.getParamMap(REPORT, param);
            try {
				String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
				return htmlContent;
			} catch (IOException | TemplateException e) {
				throw new ConvertException("3","模版填充错误");
			}
    }
    
   	
//   	/**
//   	 * 根据html内容生成word
//   	 * @param htmlContent
//   	 * @param wordFile
//   	 */
//   	private  void writeWordFile(String htmlContent,String wordFile) {  
//   		Assert.notNull("***writeWordFile() htmlContent can be not null***",htmlContent);
//    	Assert.notNull("***writeWordFile() oldFile can be not null***",wordFile);
//        try {  
//            // 检查目录是否存在  
//            File file = new File(wordFile); 
//      	  	if(!file.exists()){
//      	  		file.createNewFile();
//			 } 
//            // 生成临时文件名称  
//            byte b[] = htmlContent.getBytes();  
//            ByteArrayInputStream bais = new ByteArrayInputStream(b);  
//            POIFSFileSystem poifs = new POIFSFileSystem();  
//            DirectoryEntry directory = poifs.getRoot();  
//            DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);  
//            FileOutputStream ostream = new FileOutputStream(wordFile);  
//            poifs.writeFilesystem(ostream);  
//            bais.close();  
//            ostream.flush();
//            ostream.close();  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//      }  
//    }   


}
