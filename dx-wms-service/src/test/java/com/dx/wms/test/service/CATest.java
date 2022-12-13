/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: CATest.java
 * Author:   LIUQIONG
 * Date:     2016年8月22日 下午3:39:28
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.test.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.kinggrid.pdf.KGPdfHummer;
import com.kinggrid.pdf.executes.PdfSignature4KG;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author LIUQIONG
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CATest {
     
     public static void main(String[] args) throws IOException, Exception {
         String sharePath="E:\\temp\\pdfTemp\\";
         //pdf源路径
         String outputUnSignFile = sharePath+"\\"+"首期债权转让及受让协议 20160810 笑笑.pdf";
         String outPutSignFile = sharePath+"\\out\\"+"首期债权转让及受让协议 20160810 笑笑.pdf";
         KGPdfHummer hummer = null;
         FileInputStream cert = null;
         FileOutputStream  fileOutputStream = null;  
         File dic = new File(sharePath);
         File signFile=new File(outPutSignFile);
         try {
             cert = new FileInputStream("E:/iSignature/iSignature.pfx");
             fileOutputStream = new FileOutputStream(outPutSignFile);
             hummer = KGPdfHummer.createSignature(outputUnSignFile, null, 
                     true, fileOutputStream, dic,true);
             hummer.setCertificate(cert, "123456", "123456");
             PdfSignature4KG pdfSignature4KG = new PdfSignature4KG(
                     "E:/iSignature/iSignature.key",2,"123456");
             //坐标定位
             pdfSignature4KG.setText("盖章：");
             //关键字定位
             //pdfSignature4KG.setXY(450,450);
             pdfSignature4KG.setTextOffset(80, 10);
             hummer.setPdfSignature(pdfSignature4KG);            
             hummer.doSignature();
         } finally{
             if(hummer != null) hummer.close();
             try {
                 if(fileOutputStream != null){
                     fileOutputStream.close();
                 }
             } catch (IOException e) {
                
             }
           
         }
    }

}
