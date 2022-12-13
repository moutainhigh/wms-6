package com.dx.cmm.service.ports;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.conditions.Condition;
import com.dx.cmm.service.invest.InvestAbs;
import com.dx.cmm.service.rules.Rulers;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.service.exception.ParamException;

@Service("investPorts")
public class InvestPorts extends InvestAbs<InvestPort> implements Ports<InvestPort>, Condition<Integer> {

    private static final String SQL = "investPort.current";

    @Autowired
    private Rulers<Date, Integer> billPortRuler;

    @Override
    public Date current(Integer port) {
        if (!judge(port)) {
            LOG.error("Port[{}] illegal", port);
            throw new ParamException("Port[{0}] must in 1 or 16", port);
        }
        String key = cacheService.initKey(InvestPort.KEY, port);
        InvestPort result = cacheService.getObject(key, InvestPort.class);
        if (Assert.checkParam(result) && Assert.checkParam(result.getReportDate())) {
            return result.getReportDate();
        }
        result = dalClient.queryForObject(SQL, MapUtils.getParamMap("port", port), InvestPort.class);
        if (!Assert.checkParam(result) || !Assert.checkParam(result.getReportDate())) {
            return next(port);
        }
        cacheService.set(key, result);
        return result.getReportDate();
    }

    @Override
    public Date next(Integer port) {
        if (!judge(port)) {
            LOG.error("Port[{}] illegal", port);
            throw new ParamException("Port[{0}] must in 1 or 16", port);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,
                calendar.equals(Port.ONE) || (Port.SIXTEEN <= calendar.get(Calendar.DAY_OF_MONTH)) ? 1 : 0);
        calendar.set(Calendar.DAY_OF_MONTH, port);
        return calendar.getTime();
    }

    @Override
    public Integer query(Date param) {
        return billPortRuler.parse(param);
    }

    @Override
    public void update(Integer port) {
        String key = cacheService.initKey(CreditPort.KEY, port);
        cacheService.set(key, new InvestPort(next(port)));
    }

    @Override
    public Boolean judge(Integer port) {
        if (!Assert.checkParam(port)) {
            return false;
        }
        if (Assert.equals(port, Port.ONE) || Assert.equals(port, Port.SIXTEEN)) {
            return true;
        }
        return false;
    }
}
