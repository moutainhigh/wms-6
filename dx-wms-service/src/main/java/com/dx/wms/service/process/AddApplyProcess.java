package com.dx.wms.service.process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.dx.bpm.constants.ProcessWealthConstans;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.enums.ApplyBiz;
import com.dx.wms.service.IWorkFlowService;
import com.dx.wms.service.model.Model_;

@Service
public class AddApplyProcess extends ManagerRoleProcess {

    /**
     * 工作流服务
     */
    @Autowired
    private IWorkFlowService workFlowService;

    @Override
    public String init(ParamProcess param) {
        return "custApply/list";
    }

    @Override
    public Boolean supports(ParamProcess param) {
        return Assert.equals(param.getBiz(), ApplyBiz.ADD);
    }

    @Override
    public PaginationResult<List<ResultProcess>> query(ParamProcess param, Pagination page) {
        //客户经理只能看到自己创建的申请单    流程ID获取录单状态的list
        Long userId = param.getUserId();
        Assert.checkParam("userId must not be null", userId);
        List<String> proIns = workFlowService.getProIns(userId, ProcessWealthConstans.TASK_CUSTMANERECORD);
        if (Assert.checkParam(proIns)) {
            param.setProIns(proIns);
        }
        return dalClient.queryForList("custApply.queryForPage", MapUtils.obj2Map(param), ResultProcess.class, page);
    }

    @Override
    public void put(ParamProcess param, ModelMap view) {
        model.put(view, Model_.PRODUCT, Model_.AMOUNT_AREA);
    }

    @Override
    public String applyInit(ParamProcess param) {
        return "custApply/select";
    }

    @Override
    public PaginationResult<List<ResultProcess>> selectQuery(ParamProcess param, Pagination page) {
        return dalClient.queryForList("custAccountApply.queryAccountForPage", MapUtils.obj2Map(param),
                ResultProcess.class, page);
    }

    @Override
    public String createInit(ParamProcess param) {
        return "custApply/create";
    }

}
