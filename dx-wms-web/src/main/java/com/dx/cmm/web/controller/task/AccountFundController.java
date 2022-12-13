package com.dx.cmm.web.controller.task;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dx.cmm.service.tasks.Task;

@RequestMapping("/task/biz/account")
@Controller("accountFundTaskController")
public class AccountFundController<T> extends TimingController<T> {

    @Autowired
    private Task<T> accountFundTask;

    @RequestMapping("/execute.html")
    public void execute(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "accountFundTask");
        ServletOutputStream output = null;
        try {
            output = init(response);
            accountFundTask.execute();
            send(output);
        } catch (Exception e) {
            LOG.error("accountFundTask error[{}]", e.getMessage());
        } finally {
            destory(output, "accountFundTask");
        }
    }
}
