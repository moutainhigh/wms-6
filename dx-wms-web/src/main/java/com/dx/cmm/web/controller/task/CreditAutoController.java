package com.dx.cmm.web.controller.task;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dx.cmm.service.tasks.Task;

@RequestMapping("/task/auto/credit")
@Controller("creditAutoTaskController")
public class CreditAutoController<T> extends AutoController<T> {

    @Autowired
    private Task<T> creditJoinTask;

    @RequestMapping("/join.html")
    public void join(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "creditJoinTask");
        ServletOutputStream output = null;
        try {
            output = init(response);
            creditJoinTask.execute();
            send(output);
        } catch (Exception e) {
            LOG.error("creditJoinTask error[{}]", e.getMessage());
        } finally {
            destory(output, "creditJoinTask");
        }
    }
}
