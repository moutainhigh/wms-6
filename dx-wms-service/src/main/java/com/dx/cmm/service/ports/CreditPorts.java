package com.dx.cmm.service.ports;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.conditions.Condition;
import com.dx.cmm.service.credit.CreditAbs;
import com.dx.cmm.service.rules.Rulers;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.service.exception.ParamException;

@Service("creditPorts")
public class CreditPorts extends CreditAbs<CreditPort> implements Ports<CreditPort>, Condition<Integer> {

    private static final String SQL = "creditPort.current";

    @Autowired
    private Rulers<Date, Integer> backPortRuler;

    @Override
    public Date current(Integer port) {
        if (!judge(port)) {
            LOG.error("Port illegal");
            throw new ParamException("Port[{0}] must in 1 or 16", port);
        }
        String key = cacheService.initKey(CreditPort.KEY, port);
        CreditPort result = cacheService.getObject(key, CreditPort.class);
        if (Assert.checkParam(result) && Assert.checkParam(result.getReportDate())) {
            return result.getReportDate();
        }
        result = dalClient.queryForObject(SQL, MapUtils.getParamMap("port", port), CreditPort.class);
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
            throw new ParamException("Port[{0}] must be 1 or 16", port);
        }
        Calendar result = Calendar.getInstance();
        result.add(Calendar.MONTH,
                port.equals(Port.SIXTEEN) || (Port.SIXTEEN > result.get(Calendar.DAY_OF_MONTH)) ? 0 : 1);
        result.set(Calendar.DAY_OF_MONTH, port);
        return result.getTime();
    }
    
   public static void main(String[] args) {
       Integer port = 16;
       
       Calendar result = Calendar.getInstance();
       result.add(Calendar.MONTH,
               port.equals(Port.SIXTEEN) || (Port.SIXTEEN > result.get(Calendar.DAY_OF_MONTH)) ? 0 : 1);
       result.set(Calendar.DAY_OF_MONTH, port);
      System.out.println(result.getTime());
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

    @Override
    public Integer query(Date param) {
        return backPortRuler.parse(param);
    }

    @Override
    public void update(Integer port) {
        String key = cacheService.initKey(CreditPort.KEY, port);
        cacheService.set(key, new CreditPort(next(port)));
    }
}
