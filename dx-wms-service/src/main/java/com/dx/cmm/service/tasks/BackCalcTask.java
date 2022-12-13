package com.dx.cmm.service.tasks;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.MatchStatus;
import com.dx.cmm.exception.TaskException;
import com.dx.cmm.service.chain.Chain;
import com.dx.cmm.service.conditions.Condition;
import com.dx.cmm.service.rules.Rulers;
import com.dx.common.service.utils.Assert;

@Service("backCalcTask")
public class BackCalcTask extends BatchTask implements Condition<Integer> {

    @Autowired
    private Chain<Integer> creditRemainChain;

    @Autowired
    private Chain<Integer> investNextChain;
    
    @Autowired
    private Chain<Integer> reportDayChain;

    @Autowired
    private Rulers<Date, Integer> backPortRuler;

    @Override
    public synchronized void execute() throws TaskException {
        Integer port = backPortRuler.parse(new Date());
        if (judge(port)) {
            creditRemainChain.setNext(investNextChain);
            investNextChain.setNext(reportDayChain);
            creditRemainChain.next(port);
        }
    }

    @Override
    public Boolean judge(Integer param) {
        return Assert.checkParam(investPool.queryArray(param, MatchStatus.MATCH, MatchStatus.NEW, MatchStatus.PART))
                ? false : true;
    }
}
