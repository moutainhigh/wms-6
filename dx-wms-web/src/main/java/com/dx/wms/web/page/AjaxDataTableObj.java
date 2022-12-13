/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AjaxDataTableObj.java
 * Author:   段昆昆
 * Date:     2015年2月5日 下午20:27:29
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.page;

import java.util.List;

import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 前台datatable Ajax请求返回公共类 <br>
 * 〈功能详细描述〉
 * 
 * @param <T> list数据类型
 * @author 段昆昆
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AjaxDataTableObj<T> {
    /** 返回数据 */
    private List<T> aaData;
    /** 请求标识 */
    private int sEcho;
    /** 数据库中总共有多少条 */
    private int iTotalRecords;
    /** 数据库中查询过滤后有多少条记录,和iTotalRecords设置为相同 */
    private int iTotalDisplayRecords;

    /**
     * 无参构造函数
     */
    public AjaxDataTableObj() {
    }

    /**
     * 构造函数
     * 
     * @param sEcho 请求标识
     */
    public AjaxDataTableObj(int sEcho) {
        this.sEcho = sEcho;
    }

    /**
     * 构造函数
     * 
     * @param sEcho 请求标识
     * @param result 分页结果集
     */
    public AjaxDataTableObj(DataTableObj dTable, PaginationResult<List<T>> result) {
        this.sEcho = dTable.getsEcho();
        // 设置列表数据
        this.aaData = result.getR();
        // 设置显示总记录条数
        this.iTotalDisplayRecords = result.getPagination().getTotalRows();
        // 设置总记录条数
        this.iTotalRecords = result.getPagination().getTotalRows();
    }

    /**
     * @return aaData 列表数据
     */
    public List<T> getAaData() {
        return aaData;
    }

    /**
     * @param aaData 列表数据
     */
    public void setAaData(List<T> aaData) {
        this.aaData = aaData;
    }

    /**
     * @return sEcho 请求标识
     */
    public int getsEcho() {
        return sEcho;
    }

    /**
     * @param sEcho 请求标识
     */
    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }

    /**
     * @return iTotalRecords 总记录条数
     */
    public int getiTotalRecords() {
        return iTotalRecords;
    }

    /**
     * @param iTotalRecords 总记录条数
     */
    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    /**
     * @return iTotalDisplayRecords 总显示记录条数
     */
    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    /**
     * @param iTotalDisplayRecords 总显示记录条数
     */
    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }
}
