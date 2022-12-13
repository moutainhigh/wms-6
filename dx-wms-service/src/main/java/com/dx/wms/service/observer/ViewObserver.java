package com.dx.wms.service.observer;

import com.dx.wms.service.manager.Initializer;
import com.dx.wms.service.manager.Register;

public interface ViewObserver<S, P> extends Initializer<P>, Register<S> {

}
