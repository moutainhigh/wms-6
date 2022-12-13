package com.dx.cmm.service.calc;

import java.util.Date;

import com.dx.cmm.service.results.MatchResult;


public class ResultIntParamCalc extends IntParamCalc {

    /**
     */
    private static final long serialVersionUID = -3387329088027402617L;

    private MatchResult result;

    public ResultIntParamCalc(MatchResult result, Date refDate, Integer refDay) {
        setRefDate(refDate);
        setRefDay(refDay);
        setResult(result);
    }

    public MatchResult getResult() {
        return result;
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }

}
