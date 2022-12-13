package com.dx.cmm.web.controller.task;

import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.dx.cmm.exception.TaskException;
import com.dx.cmm.web.controller.BaseController;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 匹配任务
 *
 * @author tony
 */
abstract class TaskController<T> extends BaseController {

    /**
     * 调用验证码
     */
    private static final String AUTH_CODE = "e10adc3949ba59abbe56e057f20f883e";

    private static final String ENCODING = "UTF-8";

    void validate(String authCode, String taskName) throws TaskException {
        LOG.info("Task[{}] startup.", taskName);
        if (!Assert.equals(authCode, AUTH_CODE)) {
            LOG.error("Auth code must not exists");
            throw new TaskException("Auth code must not exists");
        }
    }

    ServletOutputStream init(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding(ENCODING);
        return response.getOutputStream();
    }

    void send(ServletOutputStream output) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(output);
        stream.writeObject(null); // 甚至可以发一个null对象，服务端取到后再做判断处理。
        stream.flush();
        stream.close();
    }

    void destory(ServletOutputStream output, String taskName) {
        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        LOG.info("Task[{}] destory.", taskName);
    }
}
