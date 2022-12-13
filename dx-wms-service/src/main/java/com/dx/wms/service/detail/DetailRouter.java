package com.dx.wms.service.detail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.observer.ObserverUtils;

@Service
public class DetailRouter implements DetailObserver {

    private List<Detail> details = new ArrayList<>();

    @Override
    public String init(ParamDetail param) {
        for (Detail detail : details) {
            if (detail.supports(param)) {
                return detail.init(param);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public void regist(Detail detail) {
        details.add(detail);
    }

    @Override
    public ResultDetail query(ParamDetail param) {
        ResultDetail result = new ResultDetail();
        for (Detail detail : details) {
            if (detail.supports(param)) {
                detail.wrapper(param, result);
            }
        }
        return result;
    }

}
