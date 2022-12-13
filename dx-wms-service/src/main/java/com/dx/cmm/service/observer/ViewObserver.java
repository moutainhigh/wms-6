package com.dx.cmm.service.observer;

import com.dx.cmm.service.manager.Initializer;
import com.dx.cmm.service.manager.Register;

public interface ViewObserver<S, P> extends Initializer<P>, Register<S> {

}
