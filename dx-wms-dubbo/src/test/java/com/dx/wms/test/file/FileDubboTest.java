package com.dx.wms.test.file;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "classpath:META-INF/spring/wms-dubbo-core.xml",
        "classpath:META-INF/spring/wms-dubbo-provider.xml", "classpath:META-INF/spring/wms-caches.xml" })
@TransactionConfiguration(defaultRollback = false)
abstract class FileDubboTest extends AbstractTestNGSpringContextTests {

}
