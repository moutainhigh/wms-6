/**
 * 
 */
package com.dx.wms.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.pdf.PDFCreationListener;

import com.dx.cmm.util.PathUtil;
import com.dx.wms.utils.exection.ConvertException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author zhangwei
 *
 */
public class PageListener implements PDFCreationListener {

    /**
     * 日志组件
     */
    private static final Logger logger = LoggerFactory.getLogger(PageListener.class);

    @Override
    public void preOpen(ITextRenderer iTextRenderer) throws ConvertException{
    }

    @Override
    public void preWrite(ITextRenderer iTextRenderer, int pageCount) throws ConvertException{
        logger.info("preWrite..." + pageCount);
        PdfWriter writer = iTextRenderer.getWriter();
        PdfContentByte cb = writer.getDirectContent();
        PdfDocument pdfDocument = cb.getPdfDocument();
        Image image = null;
        try {
            image = Image.getInstance(PathUtil.getResourcePath()+"logo-mini.png");
            image.setAlignment(Image.ALIGN_CENTER);
            image.scalePercent(20f);
            image.setAbsolutePosition(pdfDocument.right() - 170, pdfDocument.top() - 41);
            cb.addImage(image);
            PageHeaderFooter.showLine(cb, 0.8f, pdfDocument.left() + 20, pdfDocument.top() - 43,
                    pdfDocument.right() - 20, pdfDocument.top() - 43);
        } catch (IOException| DocumentException e) {
        	throw new ConvertException("1", "pdf logo 处理异常");
        } 
        PageHeaderFooter event = new PageHeaderFooter(pageCount);
        writer.setPageEvent(event);
    }

    @Override
    public void onClose(ITextRenderer renderer) throws ConvertException{

    }

}
