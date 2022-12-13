/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AjaxObj.java
 * Author:   段昆昆
 * Date:     2015年2月5日 下午20:27:29
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.page;

import java.util.HashMap;
import java.util.Map;

import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 前台Ajax请求返回json公共类 <br>
 * 〈功能详细描述〉
 * 
 * @author 段昆昆
 */
public class AjaxObj {
    /**
     * 请求成功常量
     */
    public static final int SUCCESS = 1;
    /**
     * 请求失败常量
     */
    public static final int FAILD = 0;
    /**
     * 返回结果 0表示失败 1表示成功
     */
    private int result;
    /**
     * 返回提示信息
     */
    private String msg;
    /**
     * 附加对象，用来存储一些特定的返回信息
     */
    private Object obj;

    /**
     * 构造函数
     */
    public AjaxObj() {
        result = AjaxObj.SUCCESS;
    }

    /**
     * 
     * 功能描述: <br>
     * 返回前台列表数据
     * 
     * @param sEcho dataTable标识
     * @param paginationResult 查询结果
     * @return 返回前台map
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Map<String, Object> replayDataTableInfo(Integer sEcho, PaginationResult<?> paginationResult) {
        Map<String, Object> dataTableInfo = new HashMap<String, Object>();
        dataTableInfo.put("sEcho", sEcho);
        dataTableInfo.put("iTotalRecords", paginationResult.getPagination().getTotalRows());
        dataTableInfo.put("iTotalDisplayRecords", paginationResult.getPagination().getTotalRows());
        dataTableInfo.put("aaData", paginationResult.getR());
        return dataTableInfo;
    }

    /**
     * @return result 调用结果
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result 调用结果
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * @return msg 提示信息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg 提示信息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return obj 附加对象
     */
    public Object getObj() {
        return obj;
    }

    /**
     * @param obj 附加对象
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }
}
