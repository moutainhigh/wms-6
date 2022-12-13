package com.dx.wms.service.index;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class IndexService implements IIndexService<IndexQueryDto, IndexResultDto> {

    /**
     * 日志组件
     */
    public static final Logger LOG = LoggerFactory.getLogger(IndexService.class);

    @Autowired
    public IIndexDisplayDao indexDisplayDao;

    @Autowired
    private IIndexExecutor<IndexQueryDto, IndexResultDto> executor;

    @Override
    @PostConstruct
    public void join() {
        executor.regist(this);
    }

    public Boolean checkDto(IndexQueryDto q) {
        if (q == null || q.getUser() == null || q.getOrgVo() == null || q.getRoleList() == null
                || q.getRoleList().size() <= 0) {
            return false;
        }
        return true;
    }

}
