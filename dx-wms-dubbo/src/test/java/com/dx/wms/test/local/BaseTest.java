package com.dx.wms.test.local;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "classpath:META-INF/spring/wms-dubbo-core.xml","classpath:spring/wms-consumer.xml" })
@TransactionConfiguration(defaultRollback = false)
abstract class BaseTest extends AbstractTestNGSpringContextTests {

}
