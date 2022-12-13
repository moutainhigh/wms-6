package com.dx.wms.service.saver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.observer.ObserverUtils;

@Service
public class SaverRouter implements SaverObserver {

    private List<Saver> savers = new ArrayList<>();

    @Override
    public String init(ParamSaver param) {
        for (Saver saver : savers) {
            return saver.init(param);
        }
        throw ObserverUtils.error();
    }

    @Override
    public void regist(Saver saver) {
        savers.add(saver);
    }

    @Override
    public ResultSaver query(ParamSaver param) {
        ResultSaver result = new ResultSaver();
        for (Saver saver : savers) {
            if (saver.supports(param)) {
                saver.wrapper(param, result);
            }
        }
        return result;
    }

}
