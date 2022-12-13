package com.dx.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.wms.common.BaseEntity;

/**
 * 环节行为表
 *
 * @author 王蕊
 */
@Entity(name = "t_link_action")
public class LinkAction extends BaseEntity {

    /**
     * Serial UID
     */
    private static final long serialVersionUID = -540786148549263578L;

    /**
     * 环节行为编号
     */
    private Long linkActionId;

    /**
     * 环节编号
     */
    private Long linkId;

    /**
     * 行为编号
     */
    private Long actionId;

    /**
     * 环节+行为所对应的状态描述
     */
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "link_action_id")
    public Long getLinkActionId() {
        return linkActionId;
    }

    public void setLinkActionId(Long linkActionId) {
        this.linkActionId = linkActionId;
    }

    @Column(name = "link_id")
    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    @Column(name = "action_id")
    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
