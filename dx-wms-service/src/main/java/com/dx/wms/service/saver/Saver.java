package com.dx.wms.service.saver;

import com.dx.wms.service.common.ViewService;

/**
 * 
 * 保存器
 *
 * @author tony
 */
public interface Saver extends ViewService<ParamSaver> {

    void wrapper(ParamSaver param, ResultSaver result);
}
