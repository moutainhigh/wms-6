package com.dx.wms.service.process;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public class InsertProcess extends ManagerRoleProcess{

    @Override
    public String init(ParamProcess param) {
        return null;
    }

    @Override
    public PaginationResult<List<ResultProcess>> query(ParamProcess param, Pagination page) {
        return null;
    }

    @Override
    public void put(ParamProcess param, ModelMap view) {
        
    }

    @Override
    public String applyInit(ParamProcess param) {
        return null;
    }

    @Override
    public PaginationResult<List<ResultProcess>> selectQuery(ParamProcess param, Pagination page) {
        return null;
    }

    @Override
    public String createInit(ParamProcess param) {
        return null;
    }

}
