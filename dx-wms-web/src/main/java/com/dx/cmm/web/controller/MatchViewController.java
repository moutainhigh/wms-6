package com.dx.cmm.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.dx.cmm.service.dto.BillViewDto;
import com.dx.cmm.service.dto.MatchExcelDto;
import com.dx.cmm.service.dto.MatchViewQueryDto;
import com.dx.cmm.service.dto.MatchViewResultDto;
import com.dx.cmm.service.intf.IBillViewService;
import com.dx.cmm.service.intf.IMatchViewService;
import com.dx.cmm.web.vo.MatchExcelVo;
import com.dx.cmm.web.vo.MatchViewQueryVo;
import com.dx.cmm.web.vo.MatchViewResultVo;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.IProductService;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.ExportExcelUtil;
import com.dx.wms.web.util.WebCommonUtil;
import com.dx.wms.web.util.WordGenerator;

import freemarker.template.Template;

/**
 * 
 * 匹配视图管理<br>
 * 匹配视图管理
 *
 * @author tony
 */
@Controller
@RequestMapping("/matchView")
public class MatchViewController extends BaseController {

    /**
     * 导出excel表头
     */
    private static final String[] EXCEL_HEAD = { "序号", "客户姓名", "身份证号", "出借方式", "封闭期（月）", "金额", "手机号码", "支付方式", "划扣银行",
            "划扣账号", "付款日期", "付款结果", "起息日（资金到账日）", "备注" };

    @Autowired
    private IMatchViewService matchViewService;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private IBillViewService<Map<String, Object>> billViewService;

    @Autowired
    private IProductService productService;

    @RequestMapping("/list.htm")
    public String initView(Model model, HttpServletRequest request) {
        Map<String, Object> param = initMap(request);
        param.put("products", productService.queryByApp("wms"));
        WebCommonUtil.putModel(model, param);
        return "/match_view/match_view_list";
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<MatchViewResultVo> queryByPage(MatchViewQueryVo vo, DataTableObj dTable) {
        Pagination page = WebCommonUtil.initPage(dTable);
        return new AjaxDataTableObj<MatchViewResultVo>(dTable,
                trans2Page(matchViewService.queryByPage(trans2Query(vo), page)));
    }

    private MatchViewQueryDto trans2Query(MatchViewQueryVo vo) {
        MatchViewQueryDto dto = new MatchViewQueryDto();
        try {
            PropertyUtils.copyProperties(dto, vo);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOG.error("trans2Query() exception:{}", e.getMessage());
        }
        return dto;
    }

    private PaginationResult<List<MatchViewResultVo>> trans2Page(PaginationResult<List<MatchViewResultDto>> result) {
        List<MatchViewResultVo> vos = new ArrayList<MatchViewResultVo>();
        Map<String, String> productMap = productService.getProductByAppAndProductId("wms", -1L);
        for (MatchViewResultDto dto : result.getR()) {
            vos.add(new MatchViewResultVo(dto, productMap));
        }
        return new PaginationResult<List<MatchViewResultVo>>(vos, result.getPagination());
    }

    @RequestMapping("/detail.json")
    public String detail(@RequestParam("bizId") Long bizId, Model model) {
        model.addAttribute("billViewVo", billViewService.doQuery(MapUtils.getParamMap("matchBizBaseId", bizId)));
        return billViewService.init(MapUtils.getParamMap("matchBizBaseId", bizId));
    }

    @RequestMapping("export.htm")
    public void excelExoprt(HttpServletResponse response, HttpServletRequest request) {
        ExportExcelUtil.excelExoprt(EXCEL_HEAD, null, trans2Excel(matchViewService.export(trans2Query(request))), null,
                "理财业务报盘表", response, "yyyy-mm-dd");
    }

    private MatchViewQueryDto trans2Query(HttpServletRequest request) {
        MatchViewQueryDto dto = new MatchViewQueryDto();
        String lenderCode = request.getParameter("lenderCode");
        dto.setLenderCode(Assert.checkParam(lenderCode) ? lenderCode : null);
        String billDay = request.getParameter("billDay");
        dto.setBillDay(Assert.checkParam(billDay) ? Integer.valueOf(billDay) : null);
        String matchDateBegin = request.getParameter("matchDateBegin");
        dto.setMatchDateBegin(Assert.checkParam(matchDateBegin) ? DateUtils.parseForDay(matchDateBegin) : null);
        String matchDateEnd = request.getParameter("matchDateEnd");
        dto.setMatchDateEnd(Assert.checkParam(matchDateEnd) ? DateUtils.parseForDay(matchDateEnd) : null);
        return dto;
    }

    private List<MatchExcelVo> trans2Excel(List<MatchExcelDto> dtos) {
        List<MatchExcelVo> vos = new ArrayList<MatchExcelVo>();
        Map<String, String> productMap = productService.getProductByAppAndProductId("wms", -1L);
        Integer index = 1;
        for (MatchExcelDto dto : dtos) {
            vos.add(new MatchExcelVo(dto, productMap, index));
            index = index + 1;
        }
        return vos;
    }

    @RequestMapping("download.htm")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        Long bizId = Long.valueOf(request.getParameter("bizId"));
        String custName = request.getParameter("custName");
        try {
            custName = new String(custName.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            LOG.error("download() exception:{}", e.getMessage());
        }
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            BillViewDto billViewVo = billViewService.doQuery(MapUtils.getParamMap("matchBizBaseId", bizId));
            param.put("billViewVo", billViewVo);
            // 调用工具类WordGenerator的createDoc方法生成Word文档
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("/match_view/bv001.ftl");
            String fileName = "首期债权转让及受让协议" + DateUtils.format(billViewVo.getMatchDate(), "yyyyMMdd") + " " + custName
                    + ".doc";
            file = WordGenerator.createDoc(param, template, fileName);
            fin = new FileInputStream(file);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            // 设置浏览器以下载的方式处理该文件默认名为resume.doc
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
            out = response.getOutputStream();
            byte[] buffer = new byte[512]; // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
            response.setHeader("Content-Length", String.valueOf(buffer.length));
        } catch (IOException e) {
            LOG.error("download() exception:{}", e);
        } finally {
            try {
                fin.close();
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                LOG.error("download() exception:{}", e);
            }
            if (file != null) {
                file.delete();
            }
        }

    }
}
