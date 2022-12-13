package com.dx.wms.web.trans.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.dx.ccs.vo.OrgVo;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.service.transfer.ResultTransLog;

public class TransLogVo implements Serializable{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = 4539048283286943173L;
	
	/*
	 *客户编号
	 */
	private String lenderCustCode;
	/*
	 *客户姓名
	 */
	 private String custName;
	/*
	 *原营业部id
	 */
	 private Long fromOrgId;
	 /*
	  * 原营业部名字
	  */
	 private String fromOrgName;
	 /*
	  * 原大团名字
	  */
	 private String fromBigTeamName;
	/*
	 *原小团id
	 */
	 private Long fromTeamId;
	 /*
	  * 原小团名字
	  */
	 private String fromTeamName;
	/*
	 *原客户经理id
	 */
	 private Long fromUser;
	 /*
	  * 原客户经理名字
	  */
	 private String fromUserName;
	/*
	 *转移后营业部id
	 */
	 private Long toOrgId;
	 /*
	  * 转移后营业部名字
	  */
	 private String toOrgName;
	 /*
	  * 转移后大团名字
	  */
	 private String toBigTeamName;
	/*
	 *转移后小团id
	 */
	 private Long toTeamId;
	 /*
	  * 转移后小团名字
	  */
	 private String toTeamName;
	/*
	 *转移后客户经理id
	 */
	 private Long toUser;
	 /*
	  * 转移后客户经理名字
	  */
	 private String toUserName;
	/*
	 *转移时间
	 */
	 private Date createTime;
	 /*
	  * 转移时间View
	  */
	 private String createTimeView;
	 
	 
	 
	public String getLenderCustCode() {
		return lenderCustCode;
	}
	public void setLenderCustCode(String lenderCustCode) {
		this.lenderCustCode = lenderCustCode;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Long getFromOrgId() {
		return fromOrgId;
	}
	public void setFromOrgId(Long fromOrgId) {
		this.fromOrgId = fromOrgId;
	}
	public String getFromOrgName() {
		return fromOrgName;
	}
	public void setFromOrgName(String fromOrgName) {
		this.fromOrgName = fromOrgName;
	}
	public String getFromBigTeamName() {
		return fromBigTeamName;
	}
	public void setFromBigTeamName(String fromBigTeamName) {
		this.fromBigTeamName = fromBigTeamName;
	}
	public Long getFromTeamId() {
		return fromTeamId;
	}
	public void setFromTeamId(Long fromTeamId) {
		this.fromTeamId = fromTeamId;
	}
	public String getFromTeamName() {
		return fromTeamName;
	}
	public void setFromTeamName(String fromTeamName) {
		this.fromTeamName = fromTeamName;
	}
	public Long getFromUser() {
		return fromUser;
	}
	public void setFromUser(Long fromUser) {
		this.fromUser = fromUser;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public Long getToOrgId() {
		return toOrgId;
	}
	public void setToOrgId(Long toOrgId) {
		this.toOrgId = toOrgId;
	}
	public String getToOrgName() {
		return toOrgName;
	}
	public void setToOrgName(String toOrgName) {
		this.toOrgName = toOrgName;
	}
	public String getToBigTeamName() {
		return toBigTeamName;
	}
	public void setToBigTeamName(String toBigTeamName) {
		this.toBigTeamName = toBigTeamName;
	}
	public Long getToTeamId() {
		return toTeamId;
	}
	public void setToTeamId(Long toTeamId) {
		this.toTeamId = toTeamId;
	}
	public String getToTeamName() {
		return toTeamName;
	}
	public void setToTeamName(String toTeamName) {
		this.toTeamName = toTeamName;
	}
	public Long getToUser() {
		return toUser;
	}
	public void setToUser(Long toUser) {
		this.toUser = toUser;
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateTimeView() {
		return createTimeView;
	}
	public void setCreateTimeView(String createTimeView) {
		this.createTimeView = createTimeView;
	}
	 
	public TransLogVo(ResultTransLog dto,
			String fromOrgName, OrgVo fromTeamVo, OrgVo fromBigTeamVo,String fromManagerName,
			String toOrgName, OrgVo toTeamVo, OrgVo toBigTeamVo,String toMangerName){
		
		BeanUtils.copyProperties(dto, this);
		setCreateTimeView(DateUtils.formatForDay(getCreateTime()));
		
		setFromOrgName(fromOrgName);
        setFromTeamName(fromTeamVo.getName());
        setFromBigTeamName(fromBigTeamVo.getName());
        setFromUserName(fromManagerName);
        
        setToOrgName(toOrgName);
        setToTeamName(toTeamVo.getName());
        setToBigTeamName(toBigTeamVo.getName());
        setToUserName(toMangerName);
	}
	 
}
