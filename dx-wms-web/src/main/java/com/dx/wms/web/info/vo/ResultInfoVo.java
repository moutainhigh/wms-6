/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: WealthManagementInfoResultVo.java
 * Author:   朱道灵
 * Date:     2015年7月26日 下午3:59:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.info.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.enums.PayWay;
import com.dx.wms.service.info.ResultInfo;
import com.dx.wms.service.log.InvokeLog;
import com.dx.wms.service.log.LenderApplyLog;
import com.dx.wms.web.vo.ResultVo;

/**
 * 信息结果 Vo
 * 
 *
 * @author 朱道灵
 */
public class ResultInfoVo extends ResultVo {

    /**
     */
    private static final long serialVersionUID = -1810949098743423639L;

    /**
     * 客户账户-编号
     */
    private Long custAccountId;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 出借申请-编号
     */
    private Long lenderApplyId;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 出借方式-编号
     */
    private Long productId;

    /**
     * 出借方式
     */
    private String productView;

    /**
     * 签单日期
     */
    private Date signDate;

    /**
     * 签单日期
     */
    private String signDateView;

    /**
     * 团队-编号
     */
    private Long teamId;

    /**
     * 团队
     */
    private String teamView;

    /**
     * 大团-编号
     */
    private Long clusterId;

    /**
     * 大团
     */
    private String clusterView;

    /**
     * 营业部-编号
     */
    private Long orgId;

    /**
     * 营业部
     */
    private String orgView;

    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;

    /**
     * 出借金额
     */
    private String lenderAmountView;

    /**
     * 客户经理-编号
     */
    private Long managerId;

    /**
     * 客户经理
     */
    private String managerView;

    /**
     * 客户编号
     */
    private String lenderCustCode;

    /**
     * 到账日
     */
    private Date settleDate;

    /**
     * 到账日
     */
    private String settleDateView;
    
    /**
     * 账单日
     */
    private Integer statementDate;
    
    /**
     * 账单日
     */
    private String statementDateView;

    /**
     * 到期日
     */
    private Date dueDate;
    
    /**
     * 到期日
     */
    private String dueDateView;
    
    /**
     * 理财申请单状态
     */
    private Long formStatus;

    /**
     * 理财申请单状态
     */
    private String formStatusView;

    /**
     * 原理财申请编号
     */
    private Long parrentId;
    
    /**
     * 原支付方式
     */
    private String sourPayWay;
    
    /**
     * 审批内容
     */
    private String approveComment;
    
    public ResultInfoVo(ResultInfo result, Map<String, String> productMap, Map<Long, OrgVo> orgMap,
            Map<Long, UserVo> userMap, Long clusterId, Map<String, String> statusMap) {
    	set(result,productMap,orgMap,userMap,clusterId,statusMap,null,null);
    }

    public ResultInfoVo(ResultInfo result, Map<String, String> productMap, Map<Long, OrgVo> orgMap,
            Map<Long, UserVo> userMap, Long clusterId, Map<String, String> statusMap,InvokeLog invokeLog,LenderApplyLog lenderApplyLog) {
    	set(result,productMap,orgMap,userMap,clusterId,statusMap,invokeLog,lenderApplyLog);
    }
    
    private void set(ResultInfo result, Map<String, String> productMap, Map<Long, OrgVo> orgMap,
            Map<Long, UserVo> userMap, Long clusterId, Map<String, String> statusMap,InvokeLog invokeLog,LenderApplyLog lenderApplyLog){
    	BeanUtils.copyProperties(result, this);
        setProductView(productMap.get(getProductId().toString()));
        setSignDateView(DateUtils.formatForDay(getSignDate(), "-"));
        setTeamView(orgMap.get(getTeamId()).getName());
        setClusterId(clusterId);
        setClusterView(orgMap.get(getClusterId()).getName());
        setOrgView(orgMap.get(getOrgId()).getName());
        setLenderAmountView(AmountUtils.format(getLenderAmount(), "-"));
        setManagerView(userMap.get(getManagerId()).getName());
        setSettleDateView(DateUtils.formatForDay(getSettleDate(), "-"));
        setFormStatusView(statusMap.get(getFormStatus().toString()));
        //转换
        setDueDateView(DateUtils.formatForDay(getDueDate(), "-"));
        setStatementDateView(Assert.checkParam(result.getStatementDate())?result.getStatementDate().toString():"-");
        if (Assert.checkParam(invokeLog)) {
            Long payWayId = invokeLog.getPayWayId();
            if (Assert.checkParam(payWayId)) {
                setSourPayWay(PayWay.getInfo(Integer.valueOf(payWayId.toString()), false));
            }
        }
        if(Assert.checkParam(lenderApplyLog)){
        	 setApproveComment(lenderApplyLog.getApproveComment());
        }
    }

    public Long getCustAccountId() {
        return custAccountId;
    }

    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductView() {
        return productView;
    }

    public void setProductView(String productView) {
        this.productView = productView;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSignDateView() {
        return signDateView;
    }

    public void setSignDateView(String signDateView) {
        this.signDateView = signDateView;
    }

    public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDueDateView() {
		return dueDateView;
	}

	public void setDueDateView(String dueDateView) {
		this.dueDateView = dueDateView;
	}

	public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamView() {
        return teamView;
    }

    public void setTeamView(String teamView) {
        this.teamView = teamView;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterView() {
        return clusterView;
    }

    public void setClusterView(String clusterView) {
        this.clusterView = clusterView;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgView() {
        return orgView;
    }

    public void setOrgView(String orgView) {
        this.orgView = orgView;
    }

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public String getLenderAmountView() {
        return lenderAmountView;
    }

    public void setLenderAmountView(String lenderAmountView) {
        this.lenderAmountView = lenderAmountView;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerView() {
        return managerView;
    }

    public void setManagerView(String managerView) {
        this.managerView = managerView;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public String getSettleDateView() {
        return settleDateView;
    }

    public void setSettleDateView(String settleDateView) {
        this.settleDateView = settleDateView;
    }

    public Integer getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(Integer statementDate) {
		this.statementDate = statementDate;
	}

	public String getStatementDateView() {
		return statementDateView;
	}

	public void setStatementDateView(String statementDateView) {
		this.statementDateView = statementDateView;
	}

	public Long getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(Long formStatus) {
        this.formStatus = formStatus;
    }

    public String getFormStatusView() {
        return formStatusView;
    }

    public void setFormStatusView(String formStatusView) {
        this.formStatusView = formStatusView;
    }

    public Long getParrentId() {
        return parrentId;
    }

    public void setParrentId(Long parrentId) {
        this.parrentId = parrentId;
    }

	public String getSourPayWay() {
		return sourPayWay;
	}

	public void setSourPayWay(String sourPayWay) {
		this.sourPayWay = sourPayWay;
	}

	public String getApproveComment() {
		return approveComment;
	}

	public void setApproveComment(String approveComment) {
		this.approveComment = approveComment;
	}
}
