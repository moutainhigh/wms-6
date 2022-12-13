package com.dx.cmm.service.manager;

import org.springframework.ui.Model;

/**
 * 
 * 初始器
 *
 * @author tony
 */
public interface Initializer<P> {
    /**
     * 
     * 初始化
     *
     * @param param
     * @return
     */
    String init(P param, Model model);
}
