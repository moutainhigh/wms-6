package com.dx.cmm.service.calc;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.result.CreditResults;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.results.Result;

@Service("resultNextCalc")
public class ResultNextCalc extends CalcAbs<MatchResult, Boolean> {

    @Autowired
    private Result<CreditResults> creditResult;

    @Override
    public Boolean calc(MatchResult last) throws SaveException {
        MatchResult next = new MatchResult();
        BeanUtils.copyProperties(last, next);
        next.next();
        creditResult.save(next);
        return true;
    }

}
