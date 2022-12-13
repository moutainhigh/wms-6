package com.dx.cmm.web.controller.task;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dx.cmm.service.scanner.Scanner;

@RequestMapping("/task/scanner")
@Controller("matchResultScannerController")
public class MatchResultController<T> extends ScannerTask<T> {

    @Autowired
    private Scanner resultErrorScanner;

    @RequestMapping("/execute.html")
    public void join(@RequestParam("authCode") String authCode, HttpServletResponse response) {
        validate(authCode, "matchResultScannerTask");
        ServletOutputStream output = null;
        try {
            output = init(response);
            resultErrorScanner.scanner();
            send(output);
        } catch (Exception e) {
            LOG.error("matchResultScannerTask error[{}]", e.getMessage());
        } finally {
            destory(output, "matchResultScannerTask");
        }
    }
}
