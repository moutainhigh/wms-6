package com.dx.cmm.service.calc;

import java.util.List;

import com.dx.cmm.service.funds.CreditorFund;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.results.MatchResult;

public class CreditIntParamCalc extends IntParamCalc {

    /**
     */
    private static final long serialVersionUID = -4183712442758640226L;

    private MatchResult result;

    private CreditorPool pool;

    private List<MatchResult> results;

    private CreditorFund fund;

    public CreditIntParamCalc() {

    }

    public CreditIntParamCalc(MatchResult result, List<MatchResult> results, CreditorPool pool, CreditorFund fund) {
        setResult(result);
        setResults(results);
        setPool(pool);
        setFund(fund);
    }

    public MatchResult getResult() {
        return result;
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }

    public CreditorPool getPool() {
        return pool;
    }

    public void setPool(CreditorPool pool) {
        this.pool = pool;
    }

    public List<MatchResult> getResults() {
        return results;
    }

    public void setResults(List<MatchResult> results) {
        this.results = results;
    }

    public CreditorFund getFund() {
        return fund;
    }

    public void setFund(CreditorFund fund) {
        this.fund = fund;
    }

}
