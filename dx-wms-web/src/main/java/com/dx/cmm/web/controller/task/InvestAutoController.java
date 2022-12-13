package com.dx.cmm.web.controller.task;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dx.cmm.service.tasks.Task;

@RequestMapping("/task/auto/invest")
@Controller("investAutoTaskController")
public class InvestAutoController<T> extends AutoController<T> {

    @Autowired
    private Task<T> investJoinTask;

    @Autowired
    private Task<T> matchRepeatTask;

    @Autowired
    private Task<T> investSuccessTask;

    @Autowired
    private Task<T> investFailTask;

    @Autowired
    private Task<T> investContinueTask;

    @Autowired
    private Task<T> transPayTask;

    @RequestMapping("/join.html")
    public void join(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "investJoinTask");
        ServletOutputStream output = null;
        try {
            output = init(response);
            investJoinTask.execute();
            send(output);
        } catch (Exception e) {
            LOG.error("investJoinTask error[{}]", e.getMessage());
        } finally {
            destory(output, "investJoinTask");
        }
    }

    @RequestMapping("/repeat.html")
    public void repeat(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "matchRepeatTask");
        ServletOutputStream output = null;
        try {
            output = init(response);
            matchRepeatTask.execute();
            send(output);
        } catch (Exception e) {
            LOG.error("matchRepeatTask error[{}]", e.getMessage());
        } finally {
            destory(output, "matchRepeatTask");
        }
    }

    @RequestMapping("/success.html")
    public void success(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "investSuccessTask");
        ServletOutputStream output = null;
        try {
            output = init(response);
            investSuccessTask.execute();
            send(output);
        } catch (Exception e) {
            LOG.error("investSuccessTask error[{}]", e.getMessage());
        } finally {
            destory(output, "investSuccessTask");
        }
    }

    @RequestMapping("/fail.html")
    public void fail(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "investFailTask");
        ServletOutputStream output = null;
        try {
            output = init(response);
            investFailTask.execute();
            send(output);
        } catch (Exception e) {
            LOG.error("investFailTask error[{}]", e.getMessage());
        } finally {
            destory(output, "investFailTask");
        }
    }

    @RequestMapping("/continue.html")
    public void executeContinue(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "investContinueTask");
        ServletOutputStream output = null;
        try {
            output = init(response);
            investContinueTask.execute();
            send(output);
        } catch (Exception e) {
            LOG.error("investContinueTask error[{}]", e.getMessage());
        } finally {
            destory(output, "investContinueTask");
        }
    }

    @RequestMapping("/trans.html")
    public void trans(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "transPayTask");
        ServletOutputStream output = null;
        try {
            output = init(response);
            transPayTask.execute();
            send(output);
        } catch (Exception e) {
            LOG.error("transPayTask error[{}]", e.getMessage());
        } finally {
            destory(output, "transPayTask");
        }
    }
}
