package com.dx.wms.service.observer;

import com.dx.wms.service.manager.Querier;

public interface QueryObserver<S, P, R> extends ViewObserver<S, P>, Querier<P, R> {

}
