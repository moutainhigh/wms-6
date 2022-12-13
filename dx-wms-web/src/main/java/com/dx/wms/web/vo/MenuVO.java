/*
 * Copyright (C), 2014-2018,达信财富投资管理（上海）有限公司
 * FileName: MenuVO.java
 * Author:   v_gangchsh
 * Date:     2014年1月13日 下午3:44:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author v_gangchsh
 */

public class MenuVO implements Serializable {

    private static final long serialVersionUID = -7950167164533189085L;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 链接路径
     */
    private String url;

    /**
     * 是否有子节点
     */
    private boolean hasChild;

    /**
     * 子节点列表
     */
    private List<MenuVO> childList;

    /**
     * 
     */
    public MenuVO() {
        super();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the hasChild
     */
    public boolean isHasChild() {
        return hasChild;
    }

    /**
     * @param hasChild the hasChild to set
     */
    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    /**
     * @return the childList
     */
    public List<MenuVO> getChildList() {
        return childList;
    }

    /**
     * @param childList the childList to set
     */
    public void setChildList(List<MenuVO> childList) {
        this.childList = childList;
    }

}
