package com.dx.wms.service.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.dto.TemplateProcessDto;
import com.dx.wms.report.fillData.FillRouters;
import com.dx.wms.utils.TemplateFileUtils;
import com.dx.wms.utils.exection.ConvertException;

@Service("fillDataBuilder")
public class FillDataBuilder<P, R> extends ReportEntityBuilder<R, P> {
	
	
    @Autowired
    private FillRouters router;
	
	@SuppressWarnings("unchecked")
	@Override
	public void build(ReportBaseEntitys<P, R> t) throws ConvertException{
		List<TemplateProcessDto<P, R>> pdfContents = new ArrayList<>();
		for (R r : t.getResult()) {
			TemplateProcessDto<P, R> dto = new TemplateProcessDto<P, R>();
			dto.setReportType(t.getReportType());
			List<P> params = new ArrayList<>();
			params.add((P) r);
			dto.setParam(params);
			dto.setPdfPath(t.getPath());
			dto.setTemplate(t.getTemplate());
			router.execute(dto);
			dto.setHtmlContent(TemplateFileUtils.fill(dto.getResult().get(0),dto.getTemplate()));
			pdfContents.add(dto);
		}
		t.setTemplateDtos(pdfContents);
	}

}
