///*
// * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
// * FileName: CustApplyModel.java
// * Author:   taocheng
// * Date:     2016年3月30日 下午4:47:05
// * Description: //模块目的、功能描述      
// * History: //修改记录
// * <author>      <time>      <version>    <desc>
// * 修改人姓名             修改时间            版本号                  描述
// */
//package com.dx.wms.service.model;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.ModelMap;
//
//import com.dx.common.service.utils.Assert;
//import com.dx.wms.constant.WMSConstants;
//import com.dx.wms.enums.BankCategery;
//import com.dx.wms.enums.RecoveryMode;
//import com.dx.wms.service.ICommonService;
//
///**
// * 〈一句话功能简述〉<br> 
// * 〈功能详细描述〉
// *
// * @author taocheng
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//@Service
//public class CustApplyModel extends ModelRegister {
//    
//    /**
//     * 通用服务
//     */
//    @Autowired
//    ICommonService commonService;
//    /* (non-Javadoc)
//     * @see com.dx.wms.service.manager.Supporter#supports(java.lang.Object)
//     */
//    @Override
//    public Boolean supports(ParamModel param) {
//        // TODO Auto-generated method stub
//        return Assert.equals(param.getType(), ModelType.CUSTAPPLY);
//    }
//
//    @Override
//    public ModelMap init(ParamModel param, ModelMap map) {
//        super.init(param, map);
//        map.addAttribute(PRODUCT, commonService.getProductByProductId())
//        .addAttribute(RECOVERY_MODE, RecoveryMode.getMap())
//        .addAttribute(AREAS, regionService.getMapByParentCode(WMSConstants.ROOT)).addAttribute(BANK_CATEGORY, BankCategery.getMap());
//        return map;
//    }
//}
