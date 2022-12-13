/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: BizBillDay.java
 * Author:   朱道灵
 * Date:     2015年10月22日 上午9:50:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

/**
 * 账单日 枚举
 *
 * @author 朱道灵
 */
    public enum BizBillDay {
        
        /**
         * 1号
         */
        ONE(1, "1"),
        
        /**
         * 16号
         */
        SIXTEEN(2, "16");
        
        /**
         * 常量值
         */
        private int code;
    
        /**
         * 内容
         */
        private String info;
    
        /**
         * 
         * @param code 常量值
         * @param value 内容
         */
        BizBillDay(int code, String info) {
            this.code = code;
            this.info = info;
        }
    
        public int getCode() {
            return code;
        }
    
        public void setCode(int code) {
            this.code = code;
        }
    
        public String getInfo() {
            return info;
        }
    
        public void setInfo(String info) {
            this.info = info;
        }
    
        /**
         * 
         * 功能描述: <br>
         * 根据常量值获取枚举
         *
         * @param code 常量值
         * @return
         */
        public static BizBillDay getEunm(Integer code) {
            if (code == null) {
                return null;
            }
            for (BizBillDay bizBillDay : BizBillDay.values()) {
                if (bizBillDay.getCode() == (code)) {
                    return bizBillDay;
                }
            }
            return null;
        }
    
        /**
         * 
         * 功能描述: <br>
         * 根据常量值获取内容
         *
         * @param code 常量值
         * @return
         */
        public static String getInfo(Integer code) {
            BizBillDay bizBillDay = getEunm(code);
            return bizBillDay == null ? "-" : bizBillDay.getInfo();
        }
    
        public static Map<String, String> getMap() {
            Map<String, String> result = new TreeMap<String, String>();
            for (BizBillDay bizBillDay : BizBillDay.values()) {
                result.put(String.valueOf(bizBillDay.getCode()), bizBillDay.getInfo());
            }
            return result;
        }
    
}
