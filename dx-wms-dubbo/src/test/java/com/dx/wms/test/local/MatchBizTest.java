package com.dx.wms.test.local;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.wms.dao.ILenderQueryDao;
import com.dx.wms.dto.LenderQueryDto;
import com.google.gson.Gson;

public class MatchBizTest extends BaseTest {

    @Autowired
    private ILenderQueryDao dao;

    @Test
    public void testService() {
        LenderQueryDto queryDto = new LenderQueryDto();
        queryDto.setDueDateBegin(new Date());
        queryDto.setDueDateEnd(new Date());
        queryDto.setPagination(new Pagination(-1, 0));
        System.out.println("_____________________"+new Gson().toJson(dao.queryResultByDueDate(queryDto).getR()));

    }
}
