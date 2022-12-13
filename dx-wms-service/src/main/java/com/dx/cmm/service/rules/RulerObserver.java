package com.dx.cmm.service.rules;

import com.dx.cmm.service.manager.Parser;
import com.dx.cmm.service.observer.DataObserver;

/**
 * 
 * 规则观察者
 *
 * @author tony
 */
public interface RulerObserver extends DataObserver<Ruler>, Parser<ParamRuler, ResultRuler> {

}
