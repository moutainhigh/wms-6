/*
 * Copyright (C), 2014-2015, 达信财富投资管理（上海）有限公司
 * FileName: InfoChangeFindDto.java
 * Author:   yangbao
 * Date:     2015年12月31日 上午10:09:47
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.changer;

import com.dx.wms.service.account.dto.CustAccountApplyDto;

public class ItemChanger {
    /**
     * 客户账户申请DTO
     */
    private CustAccountApplyDto applyDto;

    public ItemChanger() {

    }

    public ItemChanger(CustAccountApplyDto applyDto) {
        setApplyDto(applyDto);
    }

    /**
     * 客户账户申请DTO
     */
    public CustAccountApplyDto getApplyDto() {
        return applyDto;
    }

    /**
     * 客户账户申请DTO
     */
    public void setApplyDto(CustAccountApplyDto applyDto) {
        this.applyDto = applyDto;
    }

}
