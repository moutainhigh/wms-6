package com.dx.cmm.service.observer;

import com.dx.cmm.service.manager.Querier;

public interface QueryObserver<S, P, R> extends ViewObserver<S, P>, Querier<P, R> {

}
