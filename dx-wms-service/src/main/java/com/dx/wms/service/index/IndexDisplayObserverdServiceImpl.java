/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IndexDisplayObserverdServiceImpl.java
 * Author:   黄健
 * Date:     2015年7月27日 下午4:28:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.index;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
@Transactional
public class IndexDisplayObserverdServiceImpl<F, T>
        extends
        BaseObserverdServiceImpl<Object, Index<Object, Map<String, Object>>, Map<String, Object>>
        implements IndexObserver<Object, Map<String, Object>> {

    private List<Index<Object, Map<String, Object>>> indexDisplayObserverServices = new ArrayList<Index<Object, Map<String, Object>>>();

    @Override
    public void addObserver(Index<Object, Map<String, Object>> observer) {
        indexDisplayObserverServices.add(observer);
    }

    @Override
    public Object informObservers(Map<String, Object> param) {
        if (indexDisplayObserverServices.size() > 0) {
            for (Index<Object, Map<String, Object>> indexDisplayObserverService : indexDisplayObserverServices) {
                if (indexDisplayObserverService.isNeedAction(param)) {
                    return indexDisplayObserverService.execute(param);
                }
            }
        }
        return null;
    }

}
