package com.dx.cmm.service.report.pdf;


public interface PdfFile<T> {

    /**
     * 
     * 功能描述: <br>
     * 生成pdf文件
     *
     * @param t
     * @param path
     * @throws PdfException
     */
    T create(T t) throws PdfException;
}
