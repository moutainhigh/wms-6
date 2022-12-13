package com.dx.op.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.common.service.utils.DateUtils;
import com.dx.wms.service.IRefundTimeService;


public class RefundTimeServiceImpl implements IRefundTimeService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(RefundTimeServiceImpl.class);

    @Override
    public Map<String, Object> getRefundTimeAndRepaymentDay() {
        LOG.info("**getRefundTimeAndRepaymentDay() start**");
        Map<String, Object> map = new HashMap<String, Object>();
        int days = getDays(DateUtils.parseForDay(DateUtils.getNow()), DateUtils.parseForDay("2016-03-15"));
        LOG.info("**getDays:{}**", days);
        String refundTime = "";
        String repaymentDay = "";
        if (days <= 3 && days >= 0) {
            refundTime = "2016-04-16";
            repaymentDay = "16";
        } else {
            refundTime = getStartDay(1);
            String[] gbd = refundTime.split("-");
            repaymentDay = gbd[2];
        }
        map.put("refundTime", refundTime);
        map.put("repaymentDay", repaymentDay);
        LOG.info("**getRefundTimeAndRepaymentDay**refundTime:{}**repaymentDay:{}**", refundTime, repaymentDay);
        return map;

    }

    private String getStartDay(int monthCount) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());// 这里set合同生效日期
        // 当前月的第几天：即当前日
        int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
        if (day_of_month < 16) {
            cal.set(Calendar.DAY_OF_MONTH, 1);
        } else {
            cal.set(Calendar.DAY_OF_MONTH, 16);
        }
        cal.add(Calendar.MONTH, monthCount);
        return sdf.format(cal.getTime());
    }

    /** 日期间隔计算 */
    private Integer getDays(Date arg0, Date arg1) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(arg1);
        int day1 = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(arg0);
        int day2 = calendar.get(Calendar.DAY_OF_YEAR);
        return (day1 - day2);
    }
}
