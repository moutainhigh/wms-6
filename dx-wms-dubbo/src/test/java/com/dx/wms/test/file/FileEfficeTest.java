package com.dx.wms.test.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cms.dto.Condition;
import com.dx.cms.enums.ResKey;
import com.dx.cms.service.IFileService;
import com.dx.wms.service.ILenderManagermentService;

public class FileEfficeTest extends FileDubboTest {

    @Autowired
    private IFileService fileService;

    @Autowired
    private ILenderManagermentService lenderManagermentService;

    @Test
    public void test_1() {
        Condition condition = new Condition();
        condition.setAppCode("wms");
        condition.setResKey("wmsCustOpenApply");
        condition.setRes(ResKey.WMS_OPEN);
        condition.setCustAccountId(10630L);
        condition.setLenderApplyId(10815L);
        condition.setLenderCustCode("ASDASDASD");
        // condition.setAction("uploadPaymentVouchers");
        condition.setLenderCode("L0022011509150001-0");
        // condition.setCustAccountId(656L);
        // condition.setLenderCustCode("L0533011604180002");
        condition.setAction(null);
        Boolean ss = fileService.effectiveFiles(condition, 392L);
        System.out.println("~~~~~~~~~~~~~~~~~~~~" + ss);
        // fileService.effectiveFiles(condition, 392L);
        // fileService.queryFolders(condition);

    }

}
