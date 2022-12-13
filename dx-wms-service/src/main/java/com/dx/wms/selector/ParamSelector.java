package com.dx.wms.selector;

import com.dx.wms.common.BaseAttrDto;

/**
 * 
 * 参数选择器
 *
 * @author tony
 */
public class ParamSelector extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = -435113763143515440L;

    /**
     * 类型
     */
    private SelectorType type;

    /**
     * 当前操作人
     */
    private Long userId;

    public ParamSelector() {

    }

    public ParamSelector(String biz) {
        setType(biz);
    }

    public ParamSelector(String biz, Long userId) {
        setType(biz).setUserId(userId);
    }

    public SelectorType getType() {
        return type;
    }

    public ParamSelector setType(String biz) {
        setType(SelectorType.get(biz));
        return this;
    }

    public void setType(SelectorType type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public ParamSelector setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

}
