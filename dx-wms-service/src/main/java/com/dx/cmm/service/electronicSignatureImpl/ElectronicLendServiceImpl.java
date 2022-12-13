package com.dx.cmm.service.electronicSignatureImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.electronicSignature.IElectronicLendService;
import com.dx.cmm.util.PathUtil;
import com.dx.wms.utils.exection.ConvertException;
import com.kinggrid.pdf.KGPdfHummer;
import com.kinggrid.pdf.executes.PdfSignature4KG;


@Service
public class ElectronicLendServiceImpl implements IElectronicLendService {
	
	 /**
     * 日志组件
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ElectronicLendServiceImpl.class);

	
    private static final String iSignaturePath = PathUtil.getISignaturePath();
	
    @SuppressWarnings("finally")
	public String generateElectronicLend(String protocolFileName,String path) throws ConvertException{
        LOGGER.info("****ElectronicLendSignature start***");
	    String sharePath=path;
        //pdf源路径
        String outputUnSignFile = sharePath+File.separator+"temp"+File.separator+protocolFileName;
        String outPutSignFile = sharePath+File.separator+"signature"+File.separator+protocolFileName;
        File file = new File(outPutSignFile);
        if(file.exists()){
        	org.apache.commons.io.FileUtils.deleteQuietly(new File(outPutSignFile));
        }
        KGPdfHummer hummer = null;
		FileInputStream cert = null;
		FileOutputStream  fileOutputStream = null;	
		File dic = new File(sharePath);
		//FileInputStream fin = (FileInputStream)inputStream;
		File signFile=new File(sharePath+File.separator+"signature");
		
		if(!signFile.exists()){
		    signFile.mkdirs(); 
		}
        try {
            cert = new FileInputStream(iSignaturePath+"iSignature.pfx");
            fileOutputStream = new FileOutputStream(outPutSignFile);
            hummer = KGPdfHummer.createSignature(outputUnSignFile, null, 
                    true, fileOutputStream, dic,true);
           /* hummer = KGPdfHummer.createSignature(inputStream, null, 
                     fileOutputStream, dic,true);*/
            hummer.setCertificate(cert, "123456", "123456");
            PdfSignature4KG pdfSignature4KG = new PdfSignature4KG(
                    iSignaturePath+"iSignature.key",0,"123456");
            //坐标定位
            //pdfSignature4KG.setXY(1000, 1000);q
            //关键字定位
            pdfSignature4KG.setText("盖章：",Boolean.TRUE);
            //盖章位置调整
            pdfSignature4KG.setTextOffset(95, 10);
            hummer.setPdfSignature(pdfSignature4KG);            
            hummer.doSignature();
        } catch (Exception e) {
        	LOGGER.error("**IOException:**" + e);
        	throw new ConvertException("1","pdf 签章异常",e);
        } finally{
        	FileUtils.deleteQuietly(new File(outputUnSignFile));
			if(hummer != null) hummer.close();
			try {
				if(fileOutputStream != null){
					fileOutputStream.close();
				}
				
			} catch (IOException e) {
				 LOGGER.error("**TemplateException:**" + e);
				 throw new ConvertException("1","pdf 签章异常",e);
			}finally{
			    LOGGER.info("****ElectronicLendSignature end***");
			}
			return outPutSignFile;
        }
       
	}
}
