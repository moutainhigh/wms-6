package com.dx.math.service.manager;

import com.dx.cmm.service.manager.Parser;
import com.dx.cmm.service.observer.DataObserver;

/**
 * 
 * 数学观察者
 *
 * @author tony
 */
public interface MathObserver<S, P, R> extends DataObserver<S>, Parser<P, R> {

}
