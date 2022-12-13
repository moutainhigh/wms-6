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
import com.dx.wms.enums.StatusStep;
import com.dx.wms.service.IWorkFlowService;
import com.dx.wms.service.model.Model_;

@Service
public class InvestProcess extends MainRoleProcess {
    /**
     * 工作流服务
     */
    @Autowired
    private IWorkFlowService workFlowService;

    @Override
    public String init(ParamProcess param) {
        return "checkProcess/investmentCheck";
    }

    @Override
    public Boolean supports(ParamProcess param) {
        return Assert.equals(param.getBiz(), ApplyBiz.INVEST);
    }

    @Override
    public PaginationResult<List<ResultProcess>> query(ParamProcess param, Pagination page) {
        Long userId = param.getUserId();
        Assert.checkParam("userId must not be null", userId);
        List<String> proIns = workFlowService.getProIns(userId, ProcessWealthConstans.TASK_EXECUTIVECHECK);
        if (Assert.checkParam(proIns)) {
            param.setProIns(proIns);
        }
        return dalClient.queryForList("salesCustomer.queryCommitteeForPage", MapUtils.obj2Map(param),
                ResultProcess.class, page);
    }

    @Override
    public void put(ParamProcess param, ModelMap view) {
        model.put(view, Model_.AMOUNT_AREA, Model_.PRODUCT, Model_.BILL_DAY);
        view.addAttribute(Model_.CURRENT_STEP, StatusStep.getMap(StatusStep.CREDIT_WAIT, StatusStep.FINANCE_REJECTED));
    }

    @Override
    public String applyInit(ParamProcess param) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PaginationResult<List<ResultProcess>> selectQuery(ParamProcess param, Pagination page) {

        return null;
    }

    @Override
    public String createInit(ParamProcess param) {
        return "checkProcess/investmentCheckDetail";
    }

}
