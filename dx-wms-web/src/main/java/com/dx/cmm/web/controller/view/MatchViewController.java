package com.dx.cmm.web.controller.view;

import java.util.Map;

import com.dx.cmm.service.report.pdf.PdfException;
import com.dx.cmm.web.controller.BaseController;

abstract class MatchViewController extends BaseController {

    void error(Map<String, Object> result, PdfException e) {
        result.put("msg", e.getMessage());
    }
}
