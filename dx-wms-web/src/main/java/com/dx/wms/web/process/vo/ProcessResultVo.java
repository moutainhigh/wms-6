package com.dx.wms.web.process.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.enums.IdType;
import com.dx.wms.enums.PayWay;
import com.dx.wms.enums.Sex;
import com.dx.wms.service.log.InvokeLog;
import com.dx.wms.service.log.LenderApplyLog;
import com.dx.wms.service.process.ResultProcess;
import com.dx.wms.web.vo.ResultVo;

/**
 * 业务明细质检 查询返回结果Vo
 * 
 * @author yangbao
 *
 */
public class ProcessResultVo extends ResultVo {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 7979061826869631245L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 身份证类型
     */
    private Integer idType;

    /**
     * 身份证类型
     */
    private String idTypeView;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 出借方式
     */
    private String product;

    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;

    /**
     * 出借金额
     */
    private String lenderAmountView;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 性别
     */
    private String sexView;

    /**
     * 生效日期
     */
    private Date settlementDate;
    
    /**
     * 生效日期视图
     */
    private String settlementDateView;
    
    /**
     * 到期日
     */
    private Date dueDate;
    
    /**
     * 到期日
     */
    private String dueDateView;

    /**
     * 签单日期
     */
    private Date signDate;

    /**
     * 签单日期
     */
    private String signDateView;

    /**
     * 账单日
     */
    private Integer statementDate;
    
    /**
     * 账单日
     */
    private String statementDateView;

    /**
     * 匹配日
     */
    private Date matchDate;

    /**
     * 匹配日
     */
    private String matchDateView;

    /**
     * 支付方式
     */
    private Integer payWayId;

    /**
     * 支付方式
     */
    private String payWay;
    
    /**
     * 审批内容
     */
    private String approveComment;

    /**
     * 理财申请单状态
     */
    private Long formStatus;

    /**
     * 理财申请单状态
     */
    private String formStatusView;

    /**
     * 出借申请编号
     */
    private Long lenderApplyId;

    /**
     * 客户账号编号
     */
    private Long custAccountId;

    /**
     * 原支付方式
     */
    private String sourPayWay;

    /**
     * 营业部编号
     */
    private Long orgId;

    /**
     * 营业部编号
     */
    private String orgName;

    /**
     * 营业部
     */
    private String salesDepartment;

    /**
     * cluster
     */
    private String clusterName;

    /**
     * 团队编号
     */
    private Long teamId;

    /**
     * 团队
     */
    private String teamName;

    /**
     * 客户经理编号
     */
    private Long createUser;

    /**
     * 客户经理
     */
    private String custManager;

    /**
     * 原理财申请单
     */
    private Long parentId;
    
    /**
     * 1已续投;0未续投(或者null)
     */
    private String dueStatus;
    
    /**********/
    private ProcessResultVo[] processResult;
    
    /****协议文件名称******/
    private String protocolFileName;

    public ProcessResultVo() {

    }

    public ProcessResultVo(ResultProcess process, Map<String, String> product, Map<Long, OrgVo> orgMap,
            Map<Long, UserVo> userMap, Long clusterId, Map<String, String> statusMap, InvokeLog invokeLog,LenderApplyLog lenderApplyLog) {
        BeanUtils.copyProperties(process, this);
        setLenderCode(Assert.checkParam(getLenderCode()) ? getLenderCode() : "");
        setSignDateView(DateUtils.formatForDay(process.getSignDate(), "-"));
        setMatchDateView(DateUtils.formatForDay(process.getMatchDate(), "-"));
        setSettlementDateView(DateUtils.formatForDay(process.getSettlementDate(), "-"));
        setDueDateView(DateUtils.formatForDay(process.getDueDate(), "-"));
        setSexView(Sex.getInfo(getSex(), false));
        setIdTypeView(IdType.getInfo(getIdType(), false));
        setCustAccountId(process.getCustAccountId());
        if (Assert.checkParam(getLenderApplyId())) {
            setLenderAmountView(AmountUtils.format(process.getLenderAmount(), "-"));
            setPayWay(PayWay.getInfo(process.getPayWayId(), false));
            if (Assert.checkParam(process.getParentId())) {
                setPayWay("续投");
            }
            setProduct(product.get(process.getProductId().toString()));
            setSignDateView(DateUtils.formatForDay(getSignDate(), "-"));
            setSettlementDateView(DateUtils.formatForDay(getSettlementDate(), "-"));
            setDueDateView(DateUtils.formatForDay(getDueDate(), "-"));
            setTeamName(Assert.checkParam(getTeamId()) ? orgMap.get(getTeamId()).getName() : "-");
            setClusterName(Assert.checkParam(clusterId) ? orgMap.get(clusterId).getName() : "-");
            setOrgName(Assert.checkParam(getOrgId()) ? orgMap.get(getOrgId()).getName() : "-");
            setLenderAmountView(AmountUtils.format(getLenderAmount(), "-"));
            setCustManager(Assert.checkParam(getCreateUser()) ? userMap.get(getCreateUser()).getName() : "-");
            setFormStatusView(Assert.checkParam(getFormStatus()) ? statusMap.get(getFormStatus().toString()) : "草稿");
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
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdTypeView() {
        return idTypeView;
    }

    public void setIdTypeView(String idTypeView) {
        this.idTypeView = idTypeView;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexView() {
        return sexView;
    }

    public void setSexView(String sexView) {
        this.sexView = sexView;
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

	public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchDateView() {
        return matchDateView;
    }

    public void setMatchDateView(String matchDateView) {
        this.matchDateView = matchDateView;
    }

    public Integer getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(Integer payWayId) {
        this.payWayId = payWayId;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }
    
    public String getApproveComment() {
		return approveComment;
	}

	public void setApproveComment(String approveComment) {
		this.approveComment = approveComment;
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

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    public Long getCustAccountId() {
        return custAccountId;
    }

    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    public String getSourPayWay() {
        return sourPayWay;
    }

    public void setSourPayWay(String sourPayWay) {
        this.sourPayWay = sourPayWay;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSalesDepartment() {
        return salesDepartment;
    }

    public void setSalesDepartment(String salesDepartment) {
        this.salesDepartment = salesDepartment;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getCustManager() {
        return custManager;
    }

    public void setCustManager(String custManager) {
        this.custManager = custManager;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getSettlementDateView() {
        return settlementDateView;
    }

    public void setSettlementDateView(String settlementDateView) {
        this.settlementDateView = settlementDateView;
    }

    /**
     * @return the dueStatus
     */
    public String getDueStatus() {
        return dueStatus;
    }

    /**
     * @param dueStatus the dueStatus to set
     */
    public void setDueStatus(String dueStatus) {
        this.dueStatus = dueStatus;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

   
    /**
     * @return the processResult
     */
    public ProcessResultVo[] getProcessResult() {
        return processResult;
    }

    /**
     * @param processResult the processResult to set
     */
    public void setProcessResult(ProcessResultVo[] processResult) {
        this.processResult = processResult;
    }


	public String getProtocolFileName() {
		return protocolFileName;
	}

	public void setProtocolFileName(String protocolFileName) {
		this.protocolFileName = protocolFileName;
	}

}
