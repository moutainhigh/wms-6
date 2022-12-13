package com.dx.cmm.service.calc;

import java.util.List;

import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.results.MatchResult;

public class RepayParamCalc extends BaseCalc {

    /**
     */
    private static final long serialVersionUID = 3262831559906879750L;

    private MatchResult result;

    private CreditorPool pool;

    private List<MatchResult> results;

    public RepayParamCalc() {

    }

    public RepayParamCalc(MatchResult result, List<MatchResult> results, CreditorPool pool) {
        setResult(result);
        setResults(results);
        setPool(pool);

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

}
