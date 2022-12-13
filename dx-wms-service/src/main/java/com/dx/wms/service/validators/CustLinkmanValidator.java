/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: CustLinkman.java
 * Author:   yangbao
 * Date:     2016年1月5日 下午6:55:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.validators;

import org.springframework.validation.Errors;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.account.entity.CustLinkman;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CustLinkmanValidator extends BaseValidator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CustLinkman.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustLinkman cl = (CustLinkman)target;
        if(!Assert.checkParam(cl.getLinkmanName())){
            throw error("linkmanName must be not null");
        }
        if(!Assert.checkParam(cl.getLinkmanSex())){
            throw error("linkmanSex must be not null");
        }
        if(!Assert.checkParam(cl.getLinkmanRelation())){
            throw error("linkmanRelation must be not null");
        }
        if(!Assert.checkParam(cl.getLinkmanMobile())&&(!Assert.checkParam(cl.getAreaCode())||!Assert.checkParam(cl.getTelNum()))){
            throw error("linkmanMobile and linkmanTel must both be not null");
        }
        if(!Assert.checkParam(cl.getCustAccountId())){
            throw error("linkman custAccountId must be not null");
        }
        if(!Assert.checkParam(cl.getCreateUser())){
            throw error("linkman createUser must be not null");
        }
        if(!Assert.checkParam(cl.getDataStatus())){
            throw error("linkman dataStatus must be not null");
        }

    }

}
