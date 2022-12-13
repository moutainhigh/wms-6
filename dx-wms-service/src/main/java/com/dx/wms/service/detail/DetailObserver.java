package com.dx.wms.service.detail;

import com.dx.wms.service.observer.ViewObserver;

public interface DetailObserver extends ViewObserver<Detail,ParamDetail> {

    /**
     * 
     * 封装
     *
     * @param param
     * @return
     */
    ResultDetail query(ParamDetail param);
}
