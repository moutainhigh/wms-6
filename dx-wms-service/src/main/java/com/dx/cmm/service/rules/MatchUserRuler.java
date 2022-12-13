package com.dx.cmm.service.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.Rule;
import com.dx.cmm.service.users.IMatchUserRelationDao;
import com.dx.cmm.service.users.MatchUserRelation;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 匹配用户-匹配规则服务<br>
 * 匹配用户-匹配规则服务
 *
 * @author tony
 */
@Service
public class MatchUserRuler extends RulerRegister {

    @Autowired
    private IMatchUserRelationDao matchUserRelationDao;

    private static final String MATCH_USERS = "MATCH_USERS";

    @Override
    public Boolean supports(ParamRuler param) {
        return Assert.equals(param.getRule(), Rule.MATCH_USER_RULE);
    }

    @Override
    public ResultRuler parse(ParamRuler param) {
        List<Long> matchUsers = new ArrayList<Long>();
        DetailParamRuler detail = new DetailParamRuler();
        matchUsers.add((Long) param.getParamVal());
        detail.setAppCode(param.getAppCode());
        detail.setUserId((Long) param.getParamVal());
        Map<String, Object> results = new HashMap<String, Object>();
        List<MatchUserRelation> relations = null;
        for (MatchUserRelation relation : relations) {
            matchUsers.add(relation.getCreditorUserId());
        }
        results.put(MATCH_USERS, matchUsers);
        return new ResultRuler(results);
    }

}
