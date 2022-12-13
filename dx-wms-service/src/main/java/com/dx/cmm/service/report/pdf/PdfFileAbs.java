package com.dx.cmm.service.report.pdf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.dx.cmm.service.electronicSignature.IElectronicLendService;

abstract class PdfFileAbs<T> implements PdfFile<T> {

    /**
     * freeMarkerConfigurer
     */
    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;
    
    @Autowired
    protected IElectronicLendService electronicLendService;

    /**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger("pdf.log");

    static final String REPORT = "report";

    PdfException error(String msg) {
        return new PdfException(msg);
    }

    PdfException error(String msg, Object... args) {
        return new PdfException(msg, args);
    }
}
