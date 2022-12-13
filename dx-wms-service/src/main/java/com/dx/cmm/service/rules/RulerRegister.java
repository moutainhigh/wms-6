package com.dx.cmm.service.rules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.enums.RuleCategory;
import com.dx.math.service.enums.MathConstants;
import com.dx.math.service.enums.MathSignType;
import com.dx.math.service.enums.MathType;
import com.dx.math.service.manager.Math;
import com.dx.math.service.manager.MathObserver;
import com.dx.math.service.manager.ParamMath;
import com.dx.math.service.manager.ResultMath;

public abstract class RulerRegister implements Ruler {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(RulerRegister.class);

    private static final String NAME = "INPUT_NAME";

    @Autowired
    private IMatchRuleGroupDao matchRuleGroupDao;

    @Autowired
    private MathObserver<Math<ParamMath, ResultMath>, ParamMath, ResultMath> mathObserver;

    @Autowired
    private RulerObserver ruler;

    @Autowired
    private IMatchRuleGroupDetailDao matchRuleGroupDetailDao;

    @Autowired
    private IMatchRuleDetailDao matchRuleDetailDao;

    @Override
    @PostConstruct
    public void join() {
        ruler.regist(this);
    }

    @Override
    public ResultRuler parse(ParamRuler param) throws RulerException {
        return analysis(param, input(param));
    }

    private ResultRuler input(ParamRuler param) throws RulerException {
        param.setInput();
        Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> results = new HashMap<String, Object>();
        List<MatchRuleGroup> groups = matchRuleGroupDao.queryListByParam(param);
        for (MatchRuleGroup group : groups) {
            Long groupId = group.getMatchRuleGroupId();
            List<MatchRuleGroupDetail> groupDetails = matchRuleGroupDetailDao.queryByGroupId(groupId);
            Boolean flag = Boolean.TRUE;
            for (MatchRuleGroupDetail groupDetail : groupDetails) {
                ParamMath paramMath = new ParamMath();
                MatchRuleDetail detail = matchRuleDetailDao.queryById(groupDetail.getMatchRuleDetailId());
                paramMath.setReturnKey(getReturnKey(RuleCategory.INPUT, groupDetail));
                paramMath.setSignKey(groupDetail.getMathSignKey());
                paramMath.setMathSignType(MathSignType.getByCode(groupDetail.getMathSignKey()));
                params.put(MathConstants.PARAM.toString(), param.getParamVal());
                params.put(getReturnKey(RuleCategory.INPUT, groupDetail),
                        MathType.getClassType(detail.getMathTypeKey(), detail.getMatchRuleDetailVal()));
                paramMath.setParams(params);
                paramMath.setParamType(MathType.getEunm(detail.getMathTypeKey()));
                ResultMath mathResultDto = mathObserver.parse(paramMath);
                params.putAll(mathResultDto.getReturnValue());
                if (mathResultDto.getReturnValue().get(getReturnKey(RuleCategory.INPUT, groupDetail))
                        .equals(Boolean.FALSE)) {
                    flag = Boolean.FALSE;
                    break;
                }
            }
            if (flag) {
                results.put(NAME, group.getMatchRuleGroupName());
                LOG.info("analysisInput() input({})", group.getMatchRuleGroupName());
                return new ResultRuler(group.getMatchRuleGroupId(), results);
            }

        }
        throw error("analysisInput exception");
    }

    private ResultRuler analysis(ParamRuler param, ResultRuler result) {
        param.setOutput();
        param.setGroupId(result.getLevel());
        Map<String, Object> results = result.getResults();
        Map<String, Object> params = new HashMap<String, Object>();
        List<MatchRuleGroup> groups = matchRuleGroupDao.queryListByParam(param);
        for (MatchRuleGroup group : groups) {
            List<MatchRuleGroupDetail> groupDetails = matchRuleGroupDetailDao
                    .queryByGroupId(group.getMatchRuleGroupId());
            for (MatchRuleGroupDetail groupDetail : groupDetails) {
                ParamMath mathParamDto = new ParamMath();
                mathParamDto.setReturnKey(getReturnKey(RuleCategory.OUTPUT, groupDetail));
                mathParamDto.setSignKey(groupDetail.getMathSignKey());
                mathParamDto.setMathSignType(MathSignType.getByCode(groupDetail.getMathSignKey()));
                if (groupDetail.getMatchRuleDetailId().equals(-1L)) {
                    params.put(MathConstants.PARAM.toString(), param.getParamVal());
                    params.put(getReturnKey(RuleCategory.OUTPUT, groupDetail),
                            results.get(getLastFinalKey(RuleCategory.OUTPUT, groupDetail)));
                    mathParamDto.setParamType(MathType.BIG_DECIMAL);
                } else {
                    MatchRuleDetail detail = matchRuleDetailDao.queryById(MatchRuleDetail.class,
                            groupDetail.getMatchRuleDetailId());
                    params.put(MathConstants.PARAM.toString(), isDependKey(groupDetail) ? param.getParamVal()
                            : results.get(getParamKey(RuleCategory.OUTPUT, groupDetail)));
                    params.put(getReturnKey(RuleCategory.OUTPUT, groupDetail),
                            MathType.getClassType(detail.getMathTypeKey(), detail.getMatchRuleDetailVal()));
                    mathParamDto.setParamType(MathType.getEunm(detail.getMathTypeKey()));
                }
                mathParamDto.setParams(params);

                ResultMath mathResultDto = mathObserver.parse(mathParamDto);
                if (groupDetail.getIsOutput().equals(1)) {
                    results.put(getFinalKey(RuleCategory.OUTPUT, groupDetail),
                            mathResultDto.getReturnValue().get(getReturnKey(RuleCategory.OUTPUT, groupDetail)));
                }
                results.putAll(mathResultDto.getReturnValue());
            }
        }
        result.setResults(results);
        return result;
    }

    private String getReturnKey(RuleCategory ruleCategory, MatchRuleGroupDetail groupDetail) {
        return ruleCategory.toString() + "_" + groupDetail.getReturnKey().toUpperCase() + "_"
                + groupDetail.getDetailIndex();
    }

    private Boolean isDependKey(MatchRuleGroupDetail detail) {
        if (detail.getDependKey().toUpperCase().equals(MathConstants.PARAM.toString())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private String getFinalKey(RuleCategory ruleCategory, MatchRuleGroupDetail groupDetail) {
        return ruleCategory.toString() + "_" + groupDetail.getReturnKey().toUpperCase();
    }

    private String getLastFinalKey(RuleCategory ruleCategory, MatchRuleGroupDetail groupDetail) {
        return ruleCategory.toString() + "_" + groupDetail.getDependKey().toUpperCase();
    }

    private String getParamKey(RuleCategory ruleCategory, MatchRuleGroupDetail groupDetail) {
        return ruleCategory.toString() + "_" + groupDetail.getDependKey().toUpperCase() + "_"
                + groupDetail.getResultIndex();
    }

    private RulerException error(String msg) {
        LOG.error(msg);
        throw new RulerException(msg);
    }

}
