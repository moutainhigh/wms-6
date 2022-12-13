package com.dx.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.wms.common.BaseEntity;

/**
 * Pos终端号表
 *
 */
@Entity(name = "t_post_code")
public class PostCode extends BaseEntity{
	
	/**
     */
    private static final long serialVersionUID = 644543944445547275L;

    /**
	 * post编号
	 */
	private Long postCodeId;
	
	/**
	 * 营业部CODE
	 */
	private String orgCode;
	
	/**
	 * 营业部名
	 */
	private String orgName;
	
	/**
	 * post类别:{1:"固定",2:"移动"}
	 */
	private Long postCategory;
	
	/**
	 * post机编码
	 */
	private Long postCode;
	
	/**
	 * 备注
	 */
	private String remark;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "t_post_code_id")
	public Long getPostCodeId() {
		return postCodeId;
	}
	public void setPostCodeId(Long postCodeId) {
		this.postCodeId = postCodeId;
	}
	
	@Column(name = "t_org_code")
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgId) {
		this.orgCode = orgCode;
	}
	
	@Column(name = "t_org_name")
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	@Column(name = "t_post_category")
	public Long getPostCategory() {
		return postCategory;
	}
	public void setPostCategory(Long postCategory) {
		this.postCategory = postCategory;
	}
	
	@Column(name = "post_code")
	public Long getPostCode() {
		return postCode;
	}
	public void setPostCode(Long postCode) {
		this.postCode = postCode;
	}
	
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
