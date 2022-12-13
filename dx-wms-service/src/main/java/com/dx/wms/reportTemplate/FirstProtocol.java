/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: pdfTempalte.java
 * Author:   LIUQIONG
 * Date:     2016年8月23日 上午11:41:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.reportTemplate;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.dx.wms.enums.BizType;
import com.dx.wms.enums.ReportType;

import freemarker.template.Template;

/**
 * 首期协议模板<br> 
 * 〈功能详细描述〉
 *
 * @author LIUQIONG
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class FirstProtocol extends TempalteObserver{

    @Override
    public Boolean supports(TempalteJudge param) {

        return (param.getBizType().equals(BizType.REPORT.getCode())&&(param.getReportType().equals(ReportType.FIRST.getCode())  ||param.getReportType().equals(ReportType.EFFECTFIRST.getCode())));
    }

   @Override
    public Template getTemplate(TempalteJudge template){
        
        Template tempalte=null;
        try {
            tempalte=freeMarkerConfigurer.getConfiguration().getTemplate("/view/first/reportTemplate.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
//         Assert.notNull("**getTemplate() tempalte获取失败**", tempalte);
         return tempalte;
    }
        
}
