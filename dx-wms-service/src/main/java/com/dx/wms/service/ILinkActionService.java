package com.dx.wms.service;

import java.util.Map;

import com.dx.wms.bean.LinkAction;

/**
 * 
 * 状态服务
 *
 * @author tony
 */
public interface ILinkActionService {
    /**
     * 
     * 功能描述:查询所有状态列表
     *
     * @return
     */
    Map<String, String> queryForMap();

    /**
     * 
     * 功能描述:根据环节行为编号查询状态列表
     *
     * @param LenderApplyId
     * @return
     */
    LinkAction queryById(Long id);
}
