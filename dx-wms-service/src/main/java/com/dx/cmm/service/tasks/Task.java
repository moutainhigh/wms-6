package com.dx.cmm.service.tasks;

import com.dx.cmm.exception.TaskException;
import com.dx.cmm.service.manager.Biz;

/**
 * 
 * 任务
 *
 * @author tony
 */
public interface Task<T> extends Biz<T> {

    /**
     * 
     * 执行
     *
     */
    void execute() throws TaskException;
}
