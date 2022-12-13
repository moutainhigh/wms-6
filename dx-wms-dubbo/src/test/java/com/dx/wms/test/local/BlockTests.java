package com.dx.wms.test.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.block.IBlockService;
import com.google.gson.Gson;

public class BlockTests extends BaseTest {

    @Autowired
    private IBlockService blockService;

    @Test
    public void block() {
        System.out.println(new Gson().toJson(blockService.queryInterest()));
    }
}
