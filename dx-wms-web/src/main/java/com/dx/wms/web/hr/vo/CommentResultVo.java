package com.dx.wms.web.hr.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.DateUtils;
import com.dx.hr.service.dto.CommentResultDto;

/**
 * 日志结果dto
 * 
 * @author zsj
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CommentResultVo implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // 评论人
    private String userName;

    // 评论内容
    private String content;

    // 评论时间
    private Date ctime;

    // 任务环节
    private String taskName;

    // 意见主键
    private String id;

    // 类型
    private String type;

    // 注释时间
    private String time;

    private String userId;

    private String taskId;

    private String procInstId;

    private String action;

    private String message;
    
    private String ctimeView;
    
    public CommentResultVo(CommentResultDto commentResultDto){
    	BeanUtils.copyProperties(commentResultDto, this);
    	setCtimeView(DateUtils.formatForDay(getCtime()));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getCtimeView() {
		return ctimeView;
	}

	public void setCtimeView(String ctimeView) {
		this.ctimeView = ctimeView;
	}
    
    

}
