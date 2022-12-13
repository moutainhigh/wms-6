package com.dx.cmm.web.controller.task;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dx.cmm.service.sync.Sync;

@RequestMapping("/task/sync/trans")
@Controller("transSyncTaskController")
public class TransSyncController<T> extends SyncTaskController<T> {

    @Autowired
    private Sync transTimeSync;

    @RequestMapping("/execute.html")
    public void execute(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "transTimeSync");
        ServletOutputStream output = null;
        try {
            output = init(response);
            transTimeSync.sync();
            send(output);
        } catch (Exception e) {
            LOG.error("transTimeSync error[{}]", e.getMessage());
        } finally {
            destory(output, "transTimeSync");
        }
    }
}
