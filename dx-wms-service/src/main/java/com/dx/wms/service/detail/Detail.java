package com.dx.wms.service.detail;

import com.dx.wms.service.common.ViewService;

/**
 * 
 * 详情
 *
 * @author tony
 */
public interface Detail extends ViewService<ParamDetail> {

    void wrapper(ParamDetail param, ResultDetail result);
}
