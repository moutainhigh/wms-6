package com.dx.wms.service.saver;

import com.dx.wms.service.observer.ViewObserver;

/**
 * 
 * 保存器观察者
 *
 * @author tony
 */
public interface SaverObserver extends ViewObserver<Saver, ParamSaver> {

    /**
     * 
     * 查询
     *
     * @param param
     * @return
     */
    ResultSaver query(ParamSaver param);

}
