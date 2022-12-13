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

@Service("reditReplaceTask")
public class CreditReplaceTask extends BatchTask implements Condition<Integer> {

    @Autowired
    private Chain<Integer> bizBaseExceptionChain;

    @Autowired
    private Rulers<Date, Integer> replacePortRuler;

    @Override
    public synchronized void execute() throws TaskException {
        Integer port = replacePortRuler.parse(new Date());
        LOG.info("Startup [{}] replace task", port);
        if (judge(port)) {
            bizBaseExceptionChain.next(port);
        }

    }

    @Override
    public Boolean judge(Integer param) {
        return Assert.checkParam(investPool.queryArray(param, MatchStatus.PART)) ? false : true;
    }
}
