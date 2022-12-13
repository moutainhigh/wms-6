/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: BaseTest.java
 * Author:   v_gangchsh
 * Date:     2013年11月14日 下午3:02:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.common.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 基于Spring的服务层测试超类<br>
 * 
 * @author v_gangchsh
 * @since v1.0
 */
@ContextConfiguration(locations = { "classpath:spring/wms-core.xml"})
@TransactionConfiguration(defaultRollback = false)
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    /**
     * 日志组件
     */
    protected static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
}
