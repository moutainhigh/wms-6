package com.dx.cmm.service.common;

import com.dx.cmm.service.manager.Querier;

public interface QueryService<P, R> extends ViewService<P>, Querier<P, R> {

}
