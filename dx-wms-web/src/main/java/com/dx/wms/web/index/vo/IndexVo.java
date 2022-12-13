/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IndexDisplayVo.java
 * Author:   黄健
 * Date:     2015年7月26日 下午4:57:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.index.vo;

import java.util.List;

import com.dx.wms.service.index.IndexDisplayResultDto;

/**
 * 首页显示  vo
 *
 * @author huangjian
 */
public class IndexVo {

    /** 客户基数/当前投资申请总数 */
    private String theFirstModel;
    
    /** 被拒绝申请单数 */
    private String theSecondModel;
    
    /** 待完善申请 /质检  / 审核单数 */
    private String theThirdModel;
    
    /** 已开户数  / 审核比例 */
    private String theForthModel;
    
    /** 已投资申请总额 */
    private String theFifthModel;
    
    /** 出借方式投资比例 */
    private String theSixthModel;

    /** 出借方式投资比例 */
    private List<IndexDisplayResultDto> lenderProportion;
    
    /** 审核结果比例 */
    private List<IndexDisplayResultDto> checkResultProportion;
    
    /**
     * @return 出借方式投资比例
     */
    public List<IndexDisplayResultDto> getLenderProportion() {
        return lenderProportion;
    }

    /**
     * @param lenderProportion 出借方式投资比例
     */
    public void setLenderProportion(List<IndexDisplayResultDto> lenderProportion) {
        this.lenderProportion = lenderProportion;
    }

    /**
     * @return 审核结果比例
     */
    public List<IndexDisplayResultDto> getCheckResultProportion() {
        return checkResultProportion;
    }

    /**
     * @param checkResultProportion 审核结果比例
     */
    public void setCheckResultProportion(List<IndexDisplayResultDto> checkResultProportion) {
        this.checkResultProportion = checkResultProportion;
    }

    /**
     * @return 客户基数/当前投资申请总数
     */
    public String getTheFirstModel() {
        return theFirstModel;
    }

    /**
     * @param theFirstModel 客户基数/当前投资申请总数
     */
    public void setTheFirstModel(String theFirstModel) {
        this.theFirstModel = theFirstModel;
    }

    /**
     * @return 被拒绝申请单数
     */
    public String getTheSecondModel() {
        return theSecondModel;
    }

    /**
     * @param theSecondModel 被拒绝申请单数
     */
    public void setTheSecondModel(String theSecondModel) {
        this.theSecondModel = theSecondModel;
    }

    /**
     * @return 待完善申请 /质检  / 审核单数
     */
    public String getTheThirdModel() {
        return theThirdModel;
    }

    /**
     * @param theThirdModel 待完善申请 /质检  / 审核单数
     */
    public void setTheThirdModel(String theThirdModel) {
        this.theThirdModel = theThirdModel;
    }

    /**
     * @return 已开户数  / 审核比例
     */
    public String getTheForthModel() {
        return theForthModel;
    }

    /**
     * @param theForthModel 已开户数  / 审核比例
     */
    public void setTheForthModel(String theForthModel) {
        this.theForthModel = theForthModel;
    }

    /**
     * @return 已投资申请总额
     */
    public String getTheFifthModel() {
        return theFifthModel;
    }

    /**
     * @param theFifthModel 已投资申请总额
     */
    public void setTheFifthModel(String theFifthModel) {
        this.theFifthModel = theFifthModel;
    }

    /**
     * @return 出借方式投资比例
     */
    public String getTheSixthModel() {
        return theSixthModel;
    }

    /**
     * @param theSixthModel 出借方式投资比例
     */
    public void setTheSixthModel(String theSixthModel) {
        this.theSixthModel = theSixthModel;
    }
}
