package com.dx.cmm.service.report.pdf;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.electronicSignature.IElectronicLendService;
import com.dx.cmm.service.view.FirstViewResult;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.dto.TemplateProcessDto;

import freemarker.template.TemplateException;

@Service("firstPdfFile")
public class FirstPdfFile extends PdfFileAbs<TemplateProcessDto> {
	
    @Autowired
    protected IElectronicLendService electronicLendService;
    
    @Override
    public TemplateProcessDto create(TemplateProcessDto templateDto) throws PdfException {
    	LOG.info("***create() view={} path=***",JSON.toJSONString(templateDto));
    	File path = new File(templateDto.getPdfPath());
        if(!path.exists()){
        	path.mkdirs();
        }
        String pdfOutFile = String.format("%s%s%s.pdf", path,File.separator, templateDto.getPdfName());
        //String pdfOutFile = MessageFormat.format("{0}\\{1}.PDF", path, templateDto.getPdfName());
        LOG.debug("pdf path: "+pdfOutFile);
        templateDto.setPdfFilePath(pdfOutFile);
        	dealZipCode(templateDto.getParam().get(0));
            Map<String, Object> model = MapUtils.getParamMap(REPORT, templateDto.getParam().get(0));
            try {
				String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(templateDto.getTemplate(), model);
				templateDto.setHtmlContent(htmlContent);
				return templateDto;
			} catch (IOException | TemplateException e) {
				
			}finally {
	            LOG.info("Create[{}] first report finished");
	        }
        return null;
    }
    
    /**
     * 将zipCode按照每隔一个字符加一个空格重新拼接
     * @param firstViewResult
     */
	private void dealZipCode(Object object){
		FirstViewResult firstViewResult = (FirstViewResult) object;
		String zipCode = "";
		String zipCodes = firstViewResult.getZipCode();
		for(int i=0;i<zipCodes.length();i++){
			char code = zipCodes.charAt(i);
			zipCode+=String.valueOf(code)+" ";
		}
		firstViewResult.setZipCode(zipCode);
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
