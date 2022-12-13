package com.dx.wms.service.common;

import com.dx.wms.service.manager.Querier;

public interface QueryService<P, R> extends ViewService<P>, Querier<P, R> {

}
