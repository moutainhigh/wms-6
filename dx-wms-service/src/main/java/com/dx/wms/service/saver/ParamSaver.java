package com.dx.wms.service.saver;

import com.dx.wms.common.BaseEntitys;

/**
 * 
 * 参数保存器
 *
 * @author tony
 */
public class ParamSaver extends BaseEntitys {

    /**
     */
    private static final long serialVersionUID = 3031992381962447731L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 业务类型
     */
    private SaverType type;

    /**
     * 业务行为
     */
    private SaverAction action;

    /**
     * 当前操作人 
     */
    private Long userId;
    
    private Integer indexId;
    
    public ParamSaver() {

    }

    public ParamSaver(String type, String action, Long id) {
        setId(id).setType(type).setAction(action);
    }
    
    public Long getId() {
        return id;
    }

    public ParamSaver setId(Long id) {
        this.id = id;
        return this;
    }

    public SaverType getType() {
        return type;
    }

    public void setType(SaverType type) {
        this.type = type;
    }

    public ParamSaver setType(String type) {
        setType(SaverType.get(type));
        return this;
    }

    public SaverAction getAction() {
        return action;
    }

    public void setAction(SaverAction action) {
        this.action = action;
    }

    public ParamSaver setAction(String action) {
        setAction(SaverAction.get(action));
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

}
