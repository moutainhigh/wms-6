package com.dx.wms.service.apply;

import java.util.Date;

public class CustInfoRecordResultDto {
    
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
    private Date createTime;
    
    /**内容*/
    private String content;
    
    /**出借编号*/
    private String lenderCode;

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    /**内容*/
    public String getContent() {
        return content;
    }

    /**内容*/
    public void setContent(String content) {
        this.content = content;
    }

    /**客户编号*/
    public String getLenderCustCode() {
        return lenderCustCode;
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
    public Date getCreateTime() {
        return createTime;
    }

    /**变更时间*/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    


}
