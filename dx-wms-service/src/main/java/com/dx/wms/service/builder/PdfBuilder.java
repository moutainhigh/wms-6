package com.dx.wms.service.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.wms.dto.TemplateProcessDto;
import com.dx.wms.utils.PdfUtils;
import com.dx.wms.utils.exection.ConvertException;

@Service("pdfBuilder")
public class PdfBuilder<R, P> extends ReportEntityBuilder<R, P> {

	@Override
	public void build(ReportBaseEntitys<P, R> t) throws ConvertException{
		List<String> pdfUrls = new ArrayList<>();
		for (TemplateProcessDto<P, R> dto : t.getTemplateDtos()) {
			PdfUtils.pdf(dto.getHtmlContent(), dto.getPdfFilePath(),t.getRealAddress());
			pdfUrls.add(dto.getPdfFilePath());
		}
		t.setPdfUrls(pdfUrls);
	}

}
