package com.dx.math.service.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.framework.exception.BaseException;

@Service
public class MathRouter<P, R> implements MathObserver<Math<P, R>, P, R> {

    private List<Math<P, R>> maths = new ArrayList<Math<P, R>>();

    @Override
    public void regist(Math<P, R> math) {
        maths.add(math);
    }

    @Override
    public R parse(P param) {
        for (Math<P, R> math : maths) {
            if (math.supports(param)) {
                return math.parse(param);
            }
        }
        throw new BaseException();
    }
}
