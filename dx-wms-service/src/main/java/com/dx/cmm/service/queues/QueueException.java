package com.dx.cmm.service.queues;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 观察者异常<br>
 * 观察者异常
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class QueueException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 6558442037257541709L;

    public QueueException(String msg) {
        super(msg);
    }

    public QueueException(String pattern, Object... arguments) {
        super(MessageFormat.format(pattern, arguments));
    }

}
