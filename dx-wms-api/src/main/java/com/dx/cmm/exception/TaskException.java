package com.dx.cmm.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 任务异常<br>
 * 任务异常
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TaskException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 6390056018366602570L;

    public TaskException(String msg) {
        super(msg);
    }

    public TaskException(String msg, Object... objects) {
        super(MessageFormat.format(msg, objects));
    }
}
