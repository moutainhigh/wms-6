package com.dx.cmm.web.controller.task;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dx.cmm.service.tasks.Task;

@RequestMapping("/task/biz/replace")
@Controller("creditReplaceTaskController")
public class CreditReplaceController<T> extends TimingController<T> {

    @Autowired
    private Task<T> reditReplaceTask;

    @RequestMapping("/execute.html")
    public void execute(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "reditReplaceTask");
        ServletOutputStream output = null;
        try {
            output = init(response);
            reditReplaceTask.execute();
            send(output);
        } catch (Exception e) {
            LOG.error("reditReplaceTask error[{}]", e.getMessage());
        } finally {
            destory(output, "reditReplaceTask");
        }
    }

}
