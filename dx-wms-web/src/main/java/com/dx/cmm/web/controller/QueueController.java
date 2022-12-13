package com.dx.cmm.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.enums.MatchModule;
import com.dx.cmm.service.queues.ParamQueue;
import com.dx.cmm.service.queues.QueueObserver;
import com.dx.cmm.service.queues.ResultQueue;
import com.dx.cmm.service.stats.ParamCounter;
import com.dx.cmm.web.vo.QueueExeVo;
import com.dx.cmm.web.vo.QueueParamVo;
import com.dx.cmm.web.vo.QueueResultVo;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.WebCommonUtil;

/**
 * 
 * 队列管理
 *
 * @author tony
 */
@Controller
@RequestMapping("/matchQueue")
public class QueueController extends BaseController {

    /**
     * 队列观察者
     */
    @Autowired
    private QueueObserver queue;

    /**
     * 
     * 初始化
     *
     * @param biz
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/update_{biz}.htm")
    public String init(@PathVariable("biz") String biz, Model model, HttpServletRequest request) {
        return queue.init(new ParamQueue(biz), model);
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param biz
     * @param param
     * @param dTable
     * @param request
     * @return
     */
    @RequestMapping("/{biz}.json")
    @ResponseBody
    public AjaxDataTableObj<QueueResultVo> query(@PathVariable("biz") String biz, QueueParamVo param,
            DataTableObj dTable, HttpServletRequest request) {
        Pagination page = WebCommonUtil.initPage(dTable);
        ParamQueue dto = param(biz, param);
        Map<String, String> product = new HashMap<>();
        return new AjaxDataTableObj<QueueResultVo>(dTable,
                result(queue.query(dto, page), product, WebCommonUtil.getUserId(request)));
    }

    /**
     * 
     * 功能描述: <br>
     * 统计请求
     *
     * @param biz
     * @return
     */
    // @RequestMapping("/{biz}_stat.json")
    // @ResponseBody
    // public CountResultVo count(@PathVariable("biz") String biz, DataTableObj dTable) {
    // Pagination page = WebCommonUtil.initPage(dTable);
    // Map<String, String> product = queue.getProduct(init(biz));
    // return new CountResultVo(queue.stat(param(biz)), product);
    // }

    /**
     * 
     * 功能描述: <br>
     * 加入请求
     *
     * @param biz
     * @param items
     * @return
     */
    @RequestMapping("/{biz}_join.json")
    @ResponseBody
    public QueueExeVo join(@PathVariable("biz") String biz, @RequestBody List<QueueResultVo> items) {
        return new QueueExeVo(queue.join(new ParamQueue(biz), transJoins(items)));
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param items
     * @return
     */
    private List<ResultQueue> transJoins(List<QueueResultVo> items) {
        List<ResultQueue> joins = new ArrayList<ResultQueue>();
        for (QueueResultVo item : items) {
            ResultQueue join = new ResultQueue();
            BeanUtils.copyProperties(item, join);
            joins.add(join);
        }
        return joins;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param page
     * @param product
     * @param userId
     * @return
     */
    private PaginationResult<List<QueueResultVo>> result(PaginationResult<List<ResultQueue>> page,
            Map<String, String> product, Long userId) {
        List<QueueResultVo> results = new ArrayList<>();
        for (ResultQueue dto : page.getR()) {
            results.add(new QueueResultVo(dto, product, userId));
        }
        return new PaginationResult<List<QueueResultVo>>(results, page.getPagination());
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param biz
     * @return
     */
    private ParamCounter param(String biz) {
        return new ParamCounter(biz, MatchModule.QUEUE);
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param biz
     * @param param
     * @return
     */
    private ParamQueue param(String biz, QueueParamVo param) {
        ParamQueue dto = new ParamQueue(biz);
        BeanUtils.copyProperties(param, dto);
        return dto;
    }

}
