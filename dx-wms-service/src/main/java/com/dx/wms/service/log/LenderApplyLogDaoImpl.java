
package com.dx.wms.service.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author michelle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class LenderApplyLogDaoImpl extends BaseDaoImpl<LenderApplyLog> implements ILenderApplyLogDao {

    @Override
    public LenderApplyLog queryByParam(Long applyId) {
        Assert.notNull("Apply id must not be null", applyId);
        LOG.info("Apply id is[{}]", applyId);
        return dalClient.queryForObject("lenderApplyLog.queryCurrentByApplyId",
                MapUtils.getParamMap("applyId", applyId), LenderApplyLog.class);

    }

    @Override
    public LenderApplyLog queryByParam(Long applyId, String step) {
        Assert.notNull("Apply id or step must not be null", applyId, step);
        LOG.info("Apply id is[{}],step is [{}]", applyId, step);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("applyId", applyId);
        paramMap.put("step", step);
        return dalClient.queryForObject("lenderApplyLog.queryByStepAndApply", paramMap, LenderApplyLog.class);
    }

    @Override
    public List<LenderApplyLog> queryListByParam(Boolean hasAccount) {
        Assert.notNull("Boolean id must not be null", hasAccount);
        LOG.info("Boolean is[{}]", hasAccount);
        return dalClient.queryForList("lenderApplyLog.queryByHasAccount",
                hasAccount ? MapUtils.getParamMap("hasAccount", true) : null, LenderApplyLog.class);
    }

    @Override
    public List<LenderApplyLog> queryByApply(Long applyId) {
        Assert.notNull("Apply id must not be null", applyId);
        LOG.info("Apply id is[{}]", applyId);
        return dalClient.queryForList("lenderApplyLog.queryByApply", MapUtils.getParamMap("applyId", applyId),
                LenderApplyLog.class);
    }

    @Override
    public List<LenderApplyLog> queryByApply(Long applyId, String step) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderApplyId", applyId);
        paramMap.put("currentStepKey", step);
        LOG.info("Param is[{}]", paramMap);
        return dalClient.queryForList("lenderApplyLog.queryByStepAndApply", paramMap,
                LenderApplyLog.class);
    }
}
