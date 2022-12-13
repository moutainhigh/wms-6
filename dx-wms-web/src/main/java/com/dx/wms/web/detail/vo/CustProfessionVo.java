package com.dx.wms.web.detail.vo;

import java.io.Serializable;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.Profession;
import com.dx.wms.service.account.entity.CustProfession;

public class CustProfessionVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 7853043395280653119L;

    /**
     * '职业:{1:"自营业主",2:"公司职员",3:"公务员",4:"离/退休人士",5:"自由职业者"}',
     */
    private String profession;

    /**
     * '行业'
     */
    private String industry;

    /**
     * '行业单位名称'
     */
    private String companyName;

    /**
     * '职位'
     */
    private String post;

    public CustProfessionVo() {

    }

    public CustProfessionVo(CustProfession base) {
        setProfession(Profession.getInfo(base.getProfession(), true));
        setIndustry(Assert.checkParam(base.getIndustry()) ? base.getIndustry() : WMSConstants.NULL);
        setCompanyName(Assert.checkParam(base.getCompanyName()) ? base.getCompanyName() : WMSConstants.NULL);
        setPost(Assert.checkParam(base.getPost()) ? base.getPost() : WMSConstants.NULL);
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

}
