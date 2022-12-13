/**
 * 
 */
package com.dx.wms.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.cmm.util.PathUtil;
import com.dx.wms.utils.exection.ConvertException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author zhangwei
 *
 */
public class PageHeaderFooter extends PdfPageEventHelper {
    private static Logger logger = LoggerFactory.getLogger(PageHeaderFooter.class);
    private int pageCount;

    /**
	 * 
	 */
    public PageHeaderFooter(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return the pageCount
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public void onStartPage(PdfWriter writer, Document document) throws ConvertException{
        PdfContentByte cb = writer.getDirectContent();
        PdfDocument pdfDocument = cb.getPdfDocument();
        logger.info("onStartPage..." + writer.getCurrentPageNumber());

        Image image = null;
        try {
            image = Image.getInstance(PathUtil.getResourcePath()+"logo-mini.png");
            image.setAlignment(Image.ALIGN_CENTER);
            image.scalePercent(20f);
            image.setAbsolutePosition(pdfDocument.right() - 170, pdfDocument.top() - 41);
            cb.addImage(image);
            showLine(cb, 0.8f, pdfDocument.left() + 20, pdfDocument.top() - 43, pdfDocument.right() - 20,
                    pdfDocument.top() - 43);

        } catch (IOException |DocumentException e) {
        	throw new ConvertException("1", "pdf 页眉处理异常");
        } 
    }

    public static void showLine(PdfContentByte cb, float lineWidth, float fromX, float fromY, float toX, float toY) throws ConvertException{
        cb.setLineWidth(lineWidth);
        cb.setLineDash(3, 0, 0);
        cb.moveTo(fromX, fromY);
        cb.lineTo(toX, toY);
        cb.closePathFillStroke();
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) throws ConvertException{
        System.out.println("page...");
        PdfContentByte cb = writer.getDirectContent();
        PdfDocument pdfDocument = cb.getPdfDocument();
        String text = "上海市花旗集团大厦8F";
        String pageInfo = writer.getPageNumber() + "/" + pageCount;
        BaseFont helv = null;
        try {
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            helv = bfChinese;// BaseFont.createFont();//"NSimSun","UTF-8",false
        } catch (DocumentException | IOException e) {
        	throw new ConvertException("1", "pdf 页尾处理异常");
        } 
        float textBase = 12;
        cb.beginText();
        cb.setFontAndSize(helv, 9);
        cb.setTextMatrix(pdfDocument.right() - 160, textBase + 14);
        cb.showText(text);
        cb.endText();
        cb.beginText();
        cb.setFontAndSize(helv, 9);
        cb.setTextMatrix(pdfDocument.right() - 160 + 76, textBase);
        cb.showText(pageInfo);
        cb.endText();
    }
}
