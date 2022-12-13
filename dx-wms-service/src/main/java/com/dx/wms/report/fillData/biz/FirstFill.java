package com.dx.wms.report.fillData.biz;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.view.FirstViewResult;
import com.dx.wms.dto.TemplateProcessDto;
import com.dx.wms.enums.ReportType;
import com.dx.wms.report.fillData.FillObserver;

@Service
public class FirstFill<P, R> extends FillObserver<P, R>{

	@Override
	public Boolean supports(TemplateProcessDto<P, R> param) {
		return ReportType.FIRST.getCode().equals(param.getReportType());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void execute(TemplateProcessDto<P, R> param) {
		FirstViewResult firstViewResult = (FirstViewResult) param.getParam().get(0);
		List<FirstViewResult> result = new ArrayList<>();
		result.add(firstViewResult);
		param.setResult((List<R>) result);
		param.setPdfName(firstViewResult.getProtocolFileName());
		getPdfPath(param);
	}
	
	private void getPdfPath(TemplateProcessDto<P, R> dto){
		File path = new File(dto.getPdfPath()+File.separator+"temp");
        if(!path.exists()){
        	path.mkdirs();
        }
        String pdfOutFile = String.format("%s%s%s.pdf", path,File.separator,dto.getPdfName());
        LOG.info("generator file path: "+pdfOutFile);
        dto.setPdfFilePath(pdfOutFile);
	}

}
