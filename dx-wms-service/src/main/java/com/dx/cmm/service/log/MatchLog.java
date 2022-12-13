package com.dx.cmm.service.log;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.cmm.service.entitys.BaseEntity;

/**
 * 
 * 日志实体
 *
 * @author wanghuixiang
 */
@Entity(name = "t_match_log")
public class MatchLog extends BaseEntity {


	
	private static final long serialVersionUID = -1958494835269968208L;
	/**
	 * 日志主键
	 * 
	 * @author wanghuixiang
	 */
	private Long matchLogId;
	/**
	 * 关联表
	 * 
	 * @author wanghuixiang
	 */
	private String relationTable;
	/**
	 * 关联编号
	 * 
	 * @author wanghuixiang
	 */
	private Long relationId;
	/**
	 * 日志信息
	 * 
	 * @author wanghuixiang
	 */
	private String logMsg;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "match_log_id")
	public Long getMatchLogId() {
		return matchLogId;
	}
	public void setMatchLogId(Long matchLogId) {
		this.matchLogId = matchLogId;
	}
	@Column(name = "relation_table")
	public String getRelationTable() {
		return relationTable;
	}
	public void setRelationTable(String relationTable) {
		this.relationTable = relationTable;
	}
	@Column(name = "relation_id")
	public Long getRelationId() {
		return relationId;
	}
	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}	
	@Column(name = "log_msg")
	public String getLogMsg() {
		return logMsg;
	}
	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}
	
}
