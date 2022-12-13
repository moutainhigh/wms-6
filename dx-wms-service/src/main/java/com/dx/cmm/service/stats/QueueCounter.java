package com.dx.cmm.service.stats;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.MatchModule;
import com.dx.common.service.utils.Assert;

@Service
public class QueueCounter {

    public Boolean supports(ParamCounter param) {
        return Assert.equals(param.getModule(), MatchModule.QUEUE);
    }

    // public ResultCounter stat(ParamCounter param) {
    // return new ResultCounter(query(param));
    //
    // }
    //
    // private List<ItemCounter> query(ParamCounter param) {
    // return dalClient.queryForList("matchCount.queryQueue", MapUtils.obj2Map(param), ItemCounter.class);
    // }
}
