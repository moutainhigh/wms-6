/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchBizServiceTest.java
 * Author:   蔡登勇
 * Date:     2015年7月26日 下午6:07:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.test.service;

//import org.hibernate.validator.util.Contracts;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.users.IMatchUserDao;
import com.dx.cmm.service.users.MatchUser;
import com.dx.wms.common.test.BaseTest;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BizBaseTests extends BaseTest {

    @Autowired
    private IMatchUserDao matchUserDao;

    @Test
    public void test_() {
        System.out.println(matchUserDao.queryById(MatchUser.class, 1L));
    }
}
