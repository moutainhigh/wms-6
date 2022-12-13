package com.dx.wms.service.log;

import java.io.Serializable;

/**
 * 
 * 日志json<br>
 *
 * @author 柳励
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LogJsonDto implements Serializable {

    /** Serial UID */
    private static final long serialVersionUID = 989072238748464386L;

    private String columnNameEng;

    private String columnNameChs;

    private String sourceValueEng;

    private String sourceValueChs;

    private String updateValueEng;

    private String updateValueChs;

    private String checkStep;

    private String tableNameEng;

    private String tableNameChs;

    private String tablePkId;

    private String modifyDate;

    public String getColumnNameEng() {
        return columnNameEng;
    }

    public void setColumnNameEng(String columnNameEng) {
        this.columnNameEng = columnNameEng;
    }

    public String getColumnNameChs() {
        return columnNameChs;
    }

    public void setColumnNameChs(String columnNameChs) {
        this.columnNameChs = columnNameChs;
    }

    public String getSourceValueEng() {
        return sourceValueEng;
    }

    public void setSourceValueEng(String sourceValueEng) {
        this.sourceValueEng = sourceValueEng;
    }

    public String getSourceValueChs() {
        return sourceValueChs;
    }

    public void setSourceValueChs(String sourceValueChs) {
        this.sourceValueChs = sourceValueChs;
    }

    public String getUpdateValueEng() {
        return updateValueEng;
    }

    public void setUpdateValueEng(String updateValueEng) {
        this.updateValueEng = updateValueEng;
    }

    public String getUpdateValueChs() {
        return updateValueChs;
    }

    public void setUpdateValueChs(String updateValueChs) {
        this.updateValueChs = updateValueChs;
    }

    public String getCheckStep() {
        return checkStep;
    }

    public void setCheckStep(String checkStep) {
        this.checkStep = checkStep;
    }

    public String getTableNameEng() {
        return tableNameEng;
    }

    public void setTableNameEng(String tableNameEng) {
        this.tableNameEng = tableNameEng;
    }

    public String getTableNameChs() {
        return tableNameChs;
    }

    public void setTableNameChs(String tableNameChs) {
        this.tableNameChs = tableNameChs;
    }

    public String getTablePkId() {
        return tablePkId;
    }

    public void setTablePkId(String tablePkId) {
        this.tablePkId = tablePkId;
    }

    /**
     * @return the modifyDate
     */
    public String getModifyDate() {
        return modifyDate;
    }

    /**
     * @param modifyDate the modifyDate to set
     */
    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
}
