package com.dx.cmm.service.stats;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.MatchModule;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;

@Service
public class MatchCounter {

    public Boolean supports(ParamCounter param) {
        return Assert.equals(param.getModule(), MatchModule.MATCH);
    }

//    public ResultCounter stat(ParamCounter param) {
//        return new ResultCounter(query(param));
//    }

//    private List<ItemCounter> query(ParamCounter param) {
//        return dalClient.queryForList("matchCount.queryMatch", MapUtils.obj2Map(param), ItemCounter.class);
//    }
}
