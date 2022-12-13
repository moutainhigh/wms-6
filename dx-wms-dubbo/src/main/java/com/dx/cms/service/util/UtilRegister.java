package com.dx.cms.service.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.dx.cms.dto.FileResultDto;
import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;

public abstract class UtilRegister implements FileUtil {

    /**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger(UtilRegister.class);

    @Autowired
    FileUtilGateway fileUtilGateway;

    @Override
    @PostConstruct
    public void join() {
        fileUtilGateway.regist(this);
    }

    protected List<FileResultDto> getFileList(List<FileResultDto> list, String appCode, String openCode,
            Long fileDirId) {
        List<FileResultDto> listResults = new ArrayList<FileResultDto>();
        for (int i = 0; i < list.size(); i++) {
            if (Assert.equals(appCode, list.get(i).getAppCode()) && Assert.equals(openCode, list.get(i).getOpenCode())
                    && Assert.equals(fileDirId, list.get(i).getFileDirId())) {
                listResults.add(list.get(i));
            }
        }
        return listResults;
    }

    protected void spliceList(List<FileResultDto> pList, List<FileResultDto> sList) {
        if (null == pList) {
            throw new BaseException("** spliceList() 父集合不能为null");
        }
        if (!CollectionUtils.isEmpty(sList)) {
            pList.addAll(sList);
        }
    }

}
