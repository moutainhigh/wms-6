package com.dx.wms.service.transfer;

import java.io.Serializable;
import java.util.Date;

public class ResultTransLog implements Serializable{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = 1580975498215314698L;
	
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
	 *原小团id
	 */
	 private Long fromTeamId;
	/*
	 *原客户经理id
	 */
	 private Long fromUser;
	/*
	 *转移后营业部id
	 */
	 private Long toOrgId;
	/*
	 *转移后小团id
	 */
	 private Long toTeamId;
	/*
	 *转移后客户经理id
	 */
	 private Long toUser;
	/*
	 *转移时间
	 */
	 private Date createTime;
	 
	 
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
	public Long getFromTeamId() {
		return fromTeamId;
	}
	public void setFromTeamId(Long fromTeamId) {
		this.fromTeamId = fromTeamId;
	}
	public Long getFromUser() {
		return fromUser;
	}
	public void setFromUser(Long fromUser) {
		this.fromUser = fromUser;
	}
	public Long getToOrgId() {
		return toOrgId;
	}
	public void setToOrgId(Long toOrgId) {
		this.toOrgId = toOrgId;
	}
	public Long getToTeamId() {
		return toTeamId;
	}
	public void setToTeamId(Long toTeamId) {
		this.toTeamId = toTeamId;
	}
	public Long getToUser() {
		return toUser;
	}
	public void setToUser(Long toUser) {
		this.toUser = toUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	 
	 

}
