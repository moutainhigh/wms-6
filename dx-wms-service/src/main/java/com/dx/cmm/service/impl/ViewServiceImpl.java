package com.dx.cmm.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.dto.MatchExcelDto;
import com.dx.cmm.service.dto.MatchViewQueryDto;
import com.dx.cmm.service.dto.MatchViewResultDto;
import com.dx.cmm.service.intf.IMatchViewService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

@Service
public class ViewServiceImpl implements IMatchViewService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(ViewServiceImpl.class);

    /**
     * dalClient
     */
    @Autowired
    private PaginationDalClient dalClient;

    @Override
    public PaginationResult<List<MatchViewResultDto>> queryByPage(MatchViewQueryDto query, Pagination page) {
        return dalClient.queryForList("matchView.queryByPage", getParam(query), MatchViewResultDto.class, page);
    }

    private Map<String, Object> getParam(MatchViewQueryDto query) {
        Map<String, Object> param = MapUtils.obj2Map(query);
        if (Assert.checkParam(query.getMatchDateBegin())) {
            param.put("matchDateBegin", DateUtils.formatForBegin(query.getMatchDateBegin()));
        }
        if (Assert.checkParam(query.getMatchDateEnd())) {
            param.put("matchDateEnd", DateUtils.formatForEnd(query.getMatchDateEnd()));
        }
        if (Assert.checkParam(query.getInitMatchDateBegin())) {
            param.put("initMatchDateBegin", DateUtils.formatForBegin(query.getInitMatchDateBegin()));
        }
        if (Assert.checkParam(query.getInitMatchDateEnd())) {
            param.put("initMatchDateEnd", DateUtils.formatForEnd(query.getInitMatchDateEnd()));
        }
        if (Assert.checkParam(query.getTransDateBegin())) {
            param.put("transDateBegin", DateUtils.formatForBegin(query.getTransDateBegin()));
        }
        if (Assert.checkParam(query.getTransDateEnd())) {
            param.put("transDateEnd", DateUtils.formatForEnd(query.getTransDateEnd()));
        }
        LOG.info("getParam() param:{}", param);
        return param;
    }

    @Override
    public List<MatchExcelDto> export(MatchViewQueryDto query) {
        return dalClient.queryForList("matchView.export", getParam(query), MatchExcelDto.class);
    }
}
