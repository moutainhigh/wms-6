package com.dx.wms.service.push;

import com.dx.wms.dto.PushDataDto;
import com.dx.wms.enums.PushCode;

public interface ILenderPushService {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param code
     * @param dto
     * @throws LenderPushException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void push(PushCode code, PushDataDto dto) throws LenderPushException;
}
