package com.dx.wms.web.vo;

public class CustInfoRecordResultVo {
    
    /**客户编号*/
    private String lenderCustCode;
    
    /**客户姓名*/
    private String custName;
    
    /**变更项*/
    private String changeProject;
    
    /**变更内容*/
    private String changeContent;
    
    /**原始内容*/
    private String originalContent;
    
    /**变更时间*/
    private String createTime;
    
    /**出借编号*/
    private String lenderCode;

    /**出借编号*/
    public String getLenderCode() {
        return lenderCode;
    }

    /**出借编号*/
    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    /**客户编号*/
    public String getLenderCustCode() {
        return lenderCustCode;
    }

    /**原始内容*/
    public String getOriginalContent() {
        return originalContent;
    }

    /**原始内容*/
    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }

    /**客户编号*/
    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    /**客户姓名*/
    public String getCustName() {
        return custName;
    }

    /**客户姓名*/
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**变更项*/
    public String getChangeProject() {
        return changeProject;
    }

    /**变更项*/
    public void setChangeProject(String changeProject) {
        this.changeProject = changeProject;
    }

    /**变更内容*/
    public String getChangeContent() {
        return changeContent;
    }

    /**变更内容*/
    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    /**变更时间*/
    public String getCreateTime() {
        return createTime;
    }

    /**变更时间*/
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    

}
