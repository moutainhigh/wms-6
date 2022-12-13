package com.dx.wms.service.save;

import com.dx.wms.service.saver.ParamSaver;
import com.dx.wms.service.saver.ResultSaver;

public interface ISaveService {
    /**
     * 
     * 功能描述: 信息保存
     * 〈功能详细描述〉
     *
     * @param biz
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void save(String biz,ParamSaver param,HandlerDto dto,ResultSaver saver);
}
