/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AbstractIndexDisplayService.java
 * Author:   黄健
 * Date:     2015年7月27日 下午4:23:09
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.index;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class IndexRegister<F> extends BaseObserverServiceImpl<F, Map<String, Object>>
        implements Index<F, Map<String, Object>> {

    @Autowired
    private IBaseObserverdService<F, IndexRegister, Map<String, Object>> baseObserverdService;

    @Override
    @PostConstruct
    public void join() {
        baseObserverdService.addObserver(this);
    }

    @Override
    public boolean isNeedAction(Map<String, Object> param) {
        if (null == param || null == param.get("indexQuery") || StringUtils.isBlank(param.get("indexQuery") + "")) {
            return false;
        }
        return true;
    }

}
