/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: SigurateBuilder.java
 * Author:   LIUQIONG
 * Date:     2016年8月24日 下午2:11:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.electronicSignature.IElectronicLendService;
import com.dx.cmm.util.PathUtil;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author LIUQIONG
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("signatureBuilder")
public class SignatureBuilder<R, P> extends ReportEntityBuilder<R, P> {

    @Autowired
    IElectronicLendService electronicLendService;

    @Override
    public void build(ReportBaseEntitys<P, R> t) {
        String tempPath = t.getPath();
        List<String> pdfPathList = t.getPdfUrls();
        List<String> outPdfPath=new ArrayList<String>(); 
        for (String pdfPath : pdfPathList) {
            String outPdf=electronicLendService.generateElectronicLend(PathUtil.getFileName(pdfPath), tempPath);
            outPdfPath.add(outPdf);
        }
        t.setPdfUrls(outPdfPath);
    }

}
