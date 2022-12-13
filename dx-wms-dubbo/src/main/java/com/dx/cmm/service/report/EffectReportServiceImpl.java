package com.dx.cmm.service.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.ccs.service.IAMService;
import com.dx.cmm.service.invest.IInvestService;
import com.dx.cmm.service.invest.InvestPoolParam;
import com.dx.cmm.service.invest.InvestResult;
import com.dx.cmm.service.report.dto.ProtocolParam;
import com.dx.cmm.service.view.FirstViewResult;
import com.dx.cmm.service.view.IMatchViewService;
import com.dx.cmm.service.view.excel.ExcEffectResult;
import com.dx.cmm.service.view.excel.OpenPoolResult;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.wms.service.IProductService;
import com.dx.wms.service.apply.ILenderApplyService;

public class EffectReportServiceImpl implements IEffectReportService {

	private static final String APP = "wms";

	private static final String FUND = "匹配投资生效详情";

	private static final String BLANK = " ";

	@Autowired
	private IMatchViewService<FirstViewResult> firstTransView;

	@Autowired
	private ILenderApplyService lenderApplyService;

	@Autowired
	private IAMService amService;

	@Autowired
	private IProductService productService;

	@Autowired
	private IInvestService investService;

	@Override
	public List<FirstViewResult> queryEffect(ProtocolParam param) {
		List<InvestResult> invests = getInvests(param);
		List<FirstViewResult> results = new ArrayList<>();
		for (InvestResult invest : invests) {
			FirstViewResult viewResult = firstTransView.query(invest.getLenderCode(), Boolean.TRUE);
			set(viewResult);
			results.add(viewResult);
		}
		return results;
	}

	@Override
	public List<ExcEffectResult> queryExc(ProtocolParam param) {
		List<InvestResult> invests = getInvests(param);
		List<ExcEffectResult> results = new ArrayList<>();
		Map<Long, String> product = productService.query(APP);
		for (InvestResult invest : invests) {
			results.add(getExc(invest, product));
		}
		return results;
	}

	private List<InvestResult> getInvests(ProtocolParam param) {
		Pagination page = new Pagination();
		page.setCurrentPage(0);
		page.setPagesize(-1);
		InvestPoolParam paramDto = new InvestPoolParam();
		BeanUtils.copyProperties(param, paramDto);
		List<InvestResult> invests = investService.queryMatching(paramDto, page).getR();
		return invests;
	}

	private ExcEffectResult getExc(InvestResult invest, Map<Long, String> product) {
		ExcEffectResult result = new ExcEffectResult();
		OpenPoolResult pool = new OpenPoolResult(invest, lenderApplyService, amService, product);
		BeanUtils.copyProperties(pool, result);
		return result;
	}

	private void set(FirstViewResult viewResult) {
		StringBuffer fileNameBuffer = new StringBuffer();
		viewResult.setFileName(fileNameBuffer.append(FUND).append(BLANK).append(DateUtils.format(new Date(), "yyyyMMdd"))
				.append(BLANK).append(viewResult.getCustName()).append(BLANK).append(viewResult.getLenderCode()).toString());
		String zipCode = "";
		for (Character zipCodeChar : viewResult.getZipCode().toCharArray()) {
			zipCode += (zipCodeChar + " ");
		}
		viewResult.setZipCode(zipCode.trim());
	}
}
