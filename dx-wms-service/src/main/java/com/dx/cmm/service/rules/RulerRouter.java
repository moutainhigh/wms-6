package com.dx.cmm.service.rules;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.observer.ObserverUtils;

@Service
public class RulerRouter implements RulerObserver {

    private List<Ruler> rulers = new ArrayList<Ruler>();

    @Override
    public void regist(Ruler ruler) {
        rulers.add(ruler);
    }

    @Override
    public ResultRuler parse(ParamRuler param) {
        for (Ruler ruler : rulers) {
            if (ruler.supports(param)) {
                return ruler.parse(param);
            }
        }
        throw ObserverUtils.error();
    }

}
