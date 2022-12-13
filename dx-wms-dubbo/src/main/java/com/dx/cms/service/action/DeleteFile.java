package com.dx.cms.service.action;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.exception.FileException;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.google.gson.Gson;

@Service("deleteFile")
public class DeleteFile extends ActionRouter<Condition, Boolean> {

    private static final String DEL_DIR = "contentManagement.deleteFileDir";

    private static final String DEL_FILE = "contentManagement.deleteFile";

    private void validate(Condition param) {
        Assert.notNull(new FileException("文件编号不能为空"), param.getFileId());
        Assert.notNull(new FileException("文件目录编号不能为空"), param.getFileDirId());
        Assert.notNull(new FileException("系统编码不能为空"), param.getAppCode());
        Assert.notNull(new FileException("删除操作人不能为空"), param.getUser());
    }

    @Override
    @Transactional
    public Boolean execute(Condition param) throws FileException {
        LOG.info("Condition[{}]", param);
        validate(param);
        LOG.info("Condition[{}]", new Gson().toJson(param));
        Map<String, Object> paramMap = MapUtils.obj2Map(param);
        Integer result = dalClient.execute(DEL_DIR, paramMap);
        if (result <= 0) {
            LOG.error("Delete dir error");
            throw new FileException("删除文件目录异常");
        }
        result = dalClient.execute(DEL_FILE, paramMap);
        if (result <= 0) {
            LOG.error("Delete file error");
            throw new FileException("删除文件异常");
        }
        return true;
    }

}
