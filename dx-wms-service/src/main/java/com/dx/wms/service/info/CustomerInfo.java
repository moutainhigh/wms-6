package com.dx.wms.service.info;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.service.model.Model_;

/**
 * 
 * 销售客服权限
 * 
 * @author tony
 */
@Service
public class CustomerInfo extends InfoRegister {

    @Override
    public String init(ParamInfo param) {
        return "wealthManagementInfo/customer_list";
    }

    @Override
    public Boolean supports(ParamInfo param) {
        return hasRole(RoleConstant.XSKF, param.getUserId());
    }

    @Override
    public void put(ParamInfo param, ModelMap view) {
        model.put(view, Model_.PRODUCT, Model_.AMOUNT_AREA, Model_.CURRENT_STEP);
        view.addAttribute("custManager", commonService.getUserVos(param.getUserId()));
    }

    @Override
    public PaginationResult<List<ResultInfo>> query(ParamInfo param, Pagination page) {
        Assert.notNull("User Id must be not null", param.getUserId());
        LOG.info("**query() userId:{}**", param.getUserId());
        Long orgId = commonService.getOrgIdByUserId(param.getUserId());
        param.setOrgId(orgId);
        param.setUserId(null);
        return dalClient.queryForList("info.queryForPage", MapUtils.obj2Map(param), ResultInfo.class, page);
    }

}
