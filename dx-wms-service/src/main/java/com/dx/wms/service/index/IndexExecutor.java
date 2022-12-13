package com.dx.wms.service.index;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 */
@Service
public class IndexExecutor<Q, R> implements IIndexExecutor<Q, R> {

    private List<IIndexService<Q, R>> services = new ArrayList<IIndexService<Q, R>>();

    @Override
    public String initPage(Q q) {
        for (IIndexService<Q, R> service : services) {
            if (service.isSupport(q)) {
                return service.initPage(q);
            }
        }
        throw new BaseException();
    }

    @Override
    public R initDate(Q q) {
        for (IIndexService<Q, R> service : services) {
            if (service.isSupport(q)) {
                return service.initDate(q);
            }
        }
        throw new BaseException();
    }

    @Override
    public void regist(IIndexService<Q, R> service) {
        services.add(service);
    }

}
