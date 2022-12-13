package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.reportTemplate.TempalteJudge;
import com.dx.wms.reportTemplate.TemplateRouter;
import com.dx.wms.utils.exection.ConvertException;

@Service("templateBuilder")
public class TemplateBuilder<R, P> extends ReportEntityBuilder<R, P> {
	
	@Autowired
	
	private TemplateRouter router;
	
	@Override
	public void build(ReportBaseEntitys<P, R> t) throws ConvertException{
		TempalteJudge jude = new TempalteJudge();
		jude.setBizType(1);
		jude.setReportType(t.getReportType());
		router.execute(jude);
		t.setTemplate(jude.getTemplate());
		t.setTemplatePath(jude.getTemplatePath());
	}

}
