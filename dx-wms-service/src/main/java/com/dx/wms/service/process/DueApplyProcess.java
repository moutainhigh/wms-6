package com.dx.wms.service.process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.enums.ApplyBiz;
import com.dx.wms.service.IDueService;
import com.dx.wms.service.model.Model_;

@Service
public class DueApplyProcess extends ManagerRoleProcess {

    @Autowired
    private IDueService dueService;

    @Override
    public String init(ParamProcess param) {
        return "custApply/dueList";
    }

    @Override
    public Boolean supports(ParamProcess param) {
        return Assert.equals(param.getBiz(), ApplyBiz.DUE);
    }

    @Override
    public PaginationResult<List<ResultProcess>> query(ParamProcess param, Pagination page) {
        param.setDueApplyIds(getDueApplyIds());
        return dalClient.queryForList("custApply.queryDueListForPage", MapUtils.obj2Map(param), ResultProcess.class,
                page);
    }

    private List<Long> getDueApplyIds() {
        List<Long> idsList = dueService.getDueIds("RAJ");
        if (Assert.checkParam(idsList)) {
            return idsList;
        }
        idsList.add(-1L);
        return idsList;
    }

    @Override
    public void put(ParamProcess param, ModelMap view) {
        model.put(view, Model_.PRODUCT, Model_.AMOUNT_AREA);
    }

    @Override
    public String applyInit(ParamProcess param) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PaginationResult<List<ResultProcess>> selectQuery(ParamProcess param, Pagination page) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String createInit(ParamProcess param) {
        return "custApply/dueCreate";
    }

}
