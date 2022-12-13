package com.dx.wms.test.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "classpath:META-INF/spring/wms-dubbo-core.xml","classpath:META-INF/spring/wms-dubbo-provider.xml"})
@TransactionConfiguration(defaultRollback = false)
abstract class BaseTest extends AbstractTestNGSpringContextTests {

    
}
