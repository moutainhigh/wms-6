/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: ReportTempalteObserver.java
 * Author:   LIUQIONG
 * Date:     2016年8月23日 上午11:50:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.reportTemplate;

import java.util.Observable;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.alibaba.fastjson.JSON;
import com.dx.common.service.utils.Assert;
import com.dx.wms.observer.base.ObserverAstr;

import freemarker.template.Template;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author LIUQIONG
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class TempalteObserver extends ObserverAstr<TempalteJudge>{
    
    /**
     * 日志组件
     */
    public static final Logger LOG = LoggerFactory.getLogger(TempalteObserver.class);
    
    @Autowired
    TemplateRouter reportTemplateRouter;
    
    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;
    
    @PostConstruct
    public void init() {
        reportTemplateRouter.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        execute(arg);
    }

    public void execute(Object arg){
        TempalteJudge param = (TempalteJudge)arg;
        Assert.notNull("**TempalteJudge 获取失败，请检查入参**", param);
        if (!supports(param)) {
            return;
        }
        LOG.info("**TempalteJudge={}** ",JSON.toJSONString(param));
        param.setTemplate(getTemplate(param));
        param.setTemplatePath("/view/first/reportTemplate");
    }
   
    public abstract Template getTemplate(TempalteJudge template);
    
   

}
