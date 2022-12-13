package com.dx.wms.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * 〈一句话功能简述〉用户登录版本结果集<br> 
 * 〈功能详细描述〉
 *
 * @author FlaTa
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity(name = "t_version_notice")
public class VersionNoticeDto implements Serializable{

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;
    
    /**
     * 版本id
     */
    private Long versionId;
    
    public VersionNoticeDto(){
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "VERSION_ID", nullable = false)
    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    
    
}