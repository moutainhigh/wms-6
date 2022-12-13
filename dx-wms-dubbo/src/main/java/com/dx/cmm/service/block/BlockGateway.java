package com.dx.cmm.service.block;

import java.util.List;

import com.dx.cmm.service.ViewAbs;

/**
 * 异常服务
 *
 * @author EDison
 * 
 */
public class BlockGateway extends ViewAbs implements IBlockService {

    @Override
    public List<BlockInterestResult> queryInterest() {
        return dalClient.queryForList("blockMatch.queryInterest", null, BlockInterestResult.class);

    }

}
