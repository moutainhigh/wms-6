/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ReportManagermentController.java
 * Author:   张祥韵
 * Date:     2015年11月10日 上午11:56:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.report.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.ccs.service.IAMService;
import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.RoleVo;
import com.dx.ccs.vo.UserVo;
import com.dx.cmm.service.view.FirstViewResult;
import com.dx.cmm.service.view.IMatchViewService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.exception.BaseException;
import com.dx.report.web.vo.ReportResultVo;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.dto.ParamConvertDto;
import com.dx.wms.dto.ReportParamDto;
import com.dx.wms.enums.BankCategery;
import com.dx.wms.enums.CustCategery;
import com.dx.wms.enums.LenderAmountArea;
import com.dx.wms.enums.MsgWay;
import com.dx.wms.enums.PayWay;
import com.dx.wms.enums.ReportType;
import com.dx.wms.enums.Sex;
import com.dx.wms.report.ReportManager;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.form.Form;
import com.dx.wms.service.form.FormDto;
import com.dx.wms.service.form.FormExcel;
import com.dx.wms.service.form.FormObserver;
import com.dx.wms.service.form.FormParamDto;
import com.dx.wms.service.form.FormParamVo;
import com.dx.wms.utils.FileUtils;
import com.dx.wms.utils.exection.ConvertException;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.process.vo.ProcessResultVo;
import com.google.gson.Gson;

/**
 * 报表信息管理
 * 
 * @author zhangxiangyun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/reportManagement")
public class ReportController {
	/**
	 * 日志组件
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(ReportController.class);

	/**
	 * 下载文件临时目录
	 */
	@Value("${wms.web.temppath}")
	private String tempPath = "";

	/*** 压缩文件名称 ***/
	private static final String ZIPFILENAME = "首期协议";
	
    /***model 数据***/
    private static final String REPORT = "report";

	@Autowired
	private IAMService amService;

	@Autowired
	private FormObserver<Form<Map<String, Object>, FormDto>, Map<String, Object>, FormDto> reportExecutorService;

	@Autowired
	private IMatchViewService<FirstViewResult> firstTransView;

	/**
	 * 区域服务
	 */
	@Autowired
	private IRegionNewService regionService;
	/**
	 * 客户通讯服务
	 */
	@Autowired
	private ICommonService commonService;

	@Autowired
	private ReportManager reportManager;

	/**
	 * 报表信息查询
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list.htm")
	public String initPage(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVo user = (UserVo) session.getAttribute("user");
		Long userId = user.getUserId();
		OrgVo zhiweihuiorgVo = amService.queryOrgByOrgCode("CFTZGL");
		OrgVo orgVo = amService.queryOrgByUserId(userId);
		List<OrgVo> orgVos = null;

		String oneurl = "";
		List<RoleVo> myRoList = amService.findRolesByUserId(userId);
		for (RoleVo roleVo : myRoList) {
			if (roleVo.getCode().indexOf("WMS-ZWH") >= 0) {
				orgVos = amService.queryOrgsByParentId(zhiweihuiorgVo
						.getOrgId());
			} else if (roleVo.getCode().indexOf("WMS-XSKF") >= 0) {
				Map<Long, OrgVo> orgMap = new HashMap<Long, OrgVo>();
				OrgVo preantOrgVo = commonService.queryOrgCache(
						orgVo.getParentId(), orgMap);
				orgVos = amService.queryOrgsByParentId(preantOrgVo.getOrgId());
				model.addAttribute("orgVoId", orgVo.getParentId());
			} else {
				orgVos = amService.queryOrgsByParentId(orgVo.getOrgId());

			}
		}
		model.addAttribute("createUser", userId);
		model.addAttribute("lenderAmountArea", LenderAmountArea.getMap());
		model.addAttribute("loanWay", commonService.getProductByProductId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgVos", orgVos);
		if (!CollectionUtils.isEmpty(myRoList)) {
			map.put("roleVos", myRoList);
			model.addAttribute("reportOrgIds",
					reportExecutorService.getAttributeMap(map));
			oneurl = reportExecutorService.init(map);
		}
		return oneurl;

	}

	/**
	 * 
	 * 报表信息管理查询数据
	 * 
	 * @param FormParamVo
	 * @param request
	 * @param dTable
	 * @return
	 */
	@RequestMapping("list_do.json")
	@ResponseBody
	public AjaxDataTableObj<ReportResultVo> listByPage(
			FormParamVo reportManagementQueryVo, HttpServletRequest request,
			DataTableObj dTable, String chooselistvalue, ModelMap model) {
		LOG.info("** listByPage() ** reportManagementQueryVo={}**",
				new Gson().toJson(reportManagementQueryVo));
		Pagination pagination = new Pagination();
		if (dTable.getCurrentPage() > 0) {
			pagination.setCurrentPage(dTable.getCurrentPage());
		}
		pagination.setPagesize(dTable.getiDisplayLength());
		model.addAttribute("chooselistvalue", chooselistvalue);
		HttpSession session = request.getSession();
		UserVo user = (UserVo) session.getAttribute("user");
		Long userId = user.getUserId();
		List<RoleVo> myRoList = amService.findRolesByUserId(userId);
		OrgVo orgVo = amService.queryOrgByUserId(userId);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgVo", orgVo);
		map.put("reportManagementQueryVo", reportManagementQueryVo);
		map.put("roleVos", myRoList);
		FormParamDto reportManagementQueryDto = convertQuery(reportExecutorService
				.getManagementQueryVo(map));
		map.put("reportManagementQueryDto", reportManagementQueryDto);
		map.put("pagination", pagination);
		PaginationResult<List<ReportResultVo>> paginationResult = convertResults(
				reportExecutorService.query(map, pagination),
				reportManagementQueryDto, map);
		return new AjaxDataTableObj<ReportResultVo>(dTable, paginationResult);
	}

	/**
	 * 
	 * 报表信息管理导出excel
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "export.json")
	public void excel(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserVo user = (UserVo) session.getAttribute("user");
		Long userId = user.getUserId();
		OrgVo orgVo = amService.queryOrgByUserId(userId);
		List<RoleVo> myRoList = amService.findRolesByUserId(userId);
		String chooselistvalue = request.getParameter("chooselistvalue");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleVos", myRoList);
		map.put("request", request);
		map.put("orgVo", orgVo);
		map.put("reportManagementQueryDto",
				convert(reportExecutorService.getRequestMap(map)));
		List<com.dx.wms.service.form.FormExcelVo> excellist = convert(reportExecutorService
				.getExcel(map));
		map.put("excellist", excellist);
		map.put("response", response);
		map.put("chooselistvalue", chooselistvalue);
		map.put("reportManagermentExcelDto", givExcelQuery(request));
		reportExecutorService.queryExcel(map);
	}

	private FormExcel givExcelQuery(HttpServletRequest request) {
		FormExcel reportManagermentExcelQuery = new FormExcel();
		String createUser = request.getParameter("createUser");
		if (Assert.checkParam(createUser)) {
			Long userId = Long.parseLong(createUser);
			if (userId >= 0) {
				reportManagermentExcelQuery.setCreateUser(amService
						.queryUserById(userId).getName());
			}
		}
		String productId = request.getParameter("productId");
		if (Long.parseLong(productId) >= 0) {
			reportManagermentExcelQuery.setProductQueryName(commonService
					.queryByProductId(Long.parseLong(productId))
					.getProductName());
		}
		String lenderAmountArea = request.getParameter("lenderAmountArea");
		if (Integer.parseInt(lenderAmountArea) >= 0) {
			reportManagermentExcelQuery
					.setLenderAmountAreaQueryName(LenderAmountArea
							.getInfo(Integer.parseInt(lenderAmountArea)));
		}
		String branchOfficeId = request.getParameter("branchOfficeIds");
		if (Assert.checkParam(branchOfficeId)) {
			if (Long.parseLong(branchOfficeId) >= 0) {
				reportManagermentExcelQuery
						.setBranchOfficeIdsQueryName(amService.queryOrgById(
								Long.parseLong(branchOfficeId)).getName());
			}
		}

		String orgId = request.getParameter("orgId");
		if (Assert.checkParam(orgId)) {
			if (Long.parseLong(orgId) >= 0) {
				reportManagermentExcelQuery.setOrgIdQueryName(amService
						.queryOrgById(Long.parseLong(orgId)).getName());
			}
		}
		String areaOrgIds = request.getParameter("areaOrgIds");
		if (Assert.checkParam(areaOrgIds)) {
			if (Long.parseLong(areaOrgIds) >= 0) {
				reportManagermentExcelQuery.setAreaOrgIdsQueryName(amService
						.queryOrgById(Long.parseLong(areaOrgIds)).getName());
			}
		}
		String teamIdss = request.getParameter("cluster");
		if (Assert.checkParam(teamIdss)) {
			if (Long.parseLong(teamIdss) >= 0) {
				reportManagermentExcelQuery.setClusterQueryName(amService
						.queryOrgById(Long.parseLong(teamIdss)).getName());
			}
		}
		String teamId = request.getParameter("teamId");
		if (Assert.checkParam(teamId)) {
			if (Long.parseLong(teamId) >= 0) {
				reportManagermentExcelQuery.setTeamIdQueryName(amService
						.queryOrgById(Long.parseLong(teamId)).getName());
			}
		}
		String statementDate = request.getParameter("statementDate");
		if (Assert.checkParam(statementDate)) {
			if (Integer.parseInt(statementDate) >= 0) {
				reportManagermentExcelQuery
						.setStatementDateQueryName(statementDate);
			}
		}
		String custName = request.getParameter("custName");
		if (Assert.checkParam(custName)) {
			try {
				custName = new String(custName.getBytes("iso-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		reportManagermentExcelQuery.setCustName(custName);
		String begtime = request.getParameter("settlementDateBeg");
		if (Assert.checkParam(begtime)) {
			reportManagermentExcelQuery.setSettlementDateBegQueryName(begtime
					.replaceAll("-", "/"));
		}
		String endtime = request.getParameter("settlementDateEnd");
		if (Assert.checkParam(endtime)) {
			reportManagermentExcelQuery.setSettlementDateEndQueryName(endtime
					.replaceAll("-", "/"));
		}
		return reportManagermentExcelQuery;

	}

	private List<com.dx.wms.service.form.FormExcelVo> convert(
			List<FormDto> reportManagementDtos) {

		List<com.dx.wms.service.form.FormExcelVo> results = new ArrayList<com.dx.wms.service.form.FormExcelVo>();
		Map<Long, OrgVo> orgMap = new HashMap<Long, OrgVo>();
		OrgVo teamVo = null;
		OrgVo clusterVo = null;
		Integer index = 1;
		BigDecimal allLenderAmount = new BigDecimal(0);
		if (reportManagementDtos != null) {
			for (FormDto report : reportManagementDtos) {
				com.dx.wms.service.form.FormExcelVo reportVo = new com.dx.wms.service.form.FormExcelVo();
				BeanUtils.copyProperties(report, reportVo);
				reportVo.setIndex(index);
				allLenderAmount = allLenderAmount.add(report.getLenderAmount());
				++index;
				String giveProvinceRegionCode = "";
				String giveCityRegionCode = "";
				String giveSubBankString = "";
				String giveBank = "";
				String getProvinceRegionCode = "";
				String getCityRegionCode = "";
				String getSubBankString = "";
				String getBank = "";
				if (Assert.checkParam(report.getGiveProvinceRegionCode())) {
					giveProvinceRegionCode = regionService
							.getRegionNameByCode(report
									.getGiveProvinceRegionCode());
				}
				if (Assert.checkParam(report.getGiveCityRegionCode())) {
					giveCityRegionCode = regionService
							.getRegionNameByCode(report.getGiveCityRegionCode());
				}
				if (Assert.checkParam(report.getGiveSubBank())) {
					giveSubBankString = report.getGiveSubBank();
				}
				if (Assert.checkParam(report.getGiveBankCategory())) {
					giveBank = BankCategery.getInfo(report
							.getGiveBankCategory());
				}
				reportVo.setGiveBankCategory(giveProvinceRegionCode
						+ giveCityRegionCode + giveBank + giveSubBankString);

				if (Assert.checkParam(report.getGetProvinceRegionCode())) {
					getProvinceRegionCode = regionService
							.getRegionNameByCode(report
									.getGetProvinceRegionCode());
				}
				if (Assert.checkParam(report.getGetCityRegionCode())) {
					getCityRegionCode = regionService
							.getRegionNameByCode(report.getGetCityRegionCode());
				}
				if (Assert.checkParam(report.getGetSubBank())) {
					getSubBankString = report.getGetSubBank();
				}
				if (Assert.checkParam(report.getGetBankCategory())) {
					getBank = BankCategery.getInfo(report.getGetBankCategory());
				}
				reportVo.setGetBankCategory(getProvinceRegionCode
						+ getCityRegionCode + getBank + getSubBankString);
				if (Assert.checkParam(report.getMatchDate())) {
					reportVo.setMatchDate(DateUtils.formatForDay(report
							.getMatchDate()));
				}
				if (Assert.checkParam(report.getSex())) {
					reportVo.setSex(Sex.getInfo(report.getSex(), false));
				}
				if (Assert.checkParam(report.getSignDate())) {
					reportVo.setSignDate(DateUtils.formatForDay(report
							.getSignDate()));
				}
				if (Assert.checkParam(report.getSettlementDate())) {
					reportVo.setSettlementDate(DateUtils.formatForDay(report
							.getSettlementDate()));
				}
				if (Assert.checkParam(report.getExpectLenderDateBegin())
						&& Assert.checkParam(report.getExpectLenderDateEnd())) {
					reportVo.setExpectLenderDate(format(
							report.getExpectLenderDateBegin(), "yyyy/MM/dd")
							+ "-"
							+ format(report.getExpectLenderDateEnd(),
									"yyyy/MM/dd"));
				}
				if (Assert.checkParam(report.getTeamId())) {
					teamVo = commonService.queryOrgCache(report.getTeamId(),
							orgMap);
					Assert.notNull("teamVo cannot be null", teamVo);
					clusterVo = commonService.queryOrgCache(
							teamVo.getParentId(), orgMap);
					Assert.notNull("clusterVo cannot be null", clusterVo);
					reportVo.setClusterName((!Assert.checkParam(clusterVo
							.getName()) || !clusterVo.getName().startsWith(
							"Cluster")) ? "" : clusterVo.getName());
					reportVo.setTeamName(teamVo.getName());
					List<UserVo> teamUserVos = amService.queryUserByOrgAndRole(
							teamVo.getOrgId(), "WMS-TDJL");
					if (teamUserVos.size() != 0) {
						reportVo.setTeamUserName(teamUserVos.get(0).getName());
					}
				}

				if (Assert.checkParam(report.getOrgId())) {
					OrgVo orgVo = commonService.queryOrgCache(
							report.getOrgId(), orgMap);
					reportVo.setOrgName(orgVo.getName());
					if (Assert.checkParam(orgVo.getParentId())) {
						OrgVo branchOffice = commonService.queryOrgCache(
								orgVo.getParentId(), orgMap);
						reportVo.setBranchOfficeName(branchOffice.getName());
						if (Assert.checkParam(branchOffice.getParentId())) {
							OrgVo area = commonService.queryOrgCache(
									branchOffice.getParentId(), orgMap);
							reportVo.setAreaName(area.getName());
						}
					}
				}
				if (Assert.checkParam(report.getCreateUser())) {
					reportVo.setCreateUser(amService.queryUserById(
							report.getCreateUser()).getName());
				}
				if (Assert.checkParam(report.getMsgWay())) {
					reportVo.setMsgWay(MsgWay.getInfo(report.getMsgWay(), false));
				}
				if (Assert.checkParam(report.getProductId())) {
					reportVo.setProductName(commonService.queryByProductId(
							report.getProductId()).getProductName());
				}
				if (Assert.checkParam(report.getCustCategory())) {
					reportVo.setCustCategory(CustCategery.getInfo(
							report.getCustCategory(), false));
				}
				if (Assert.checkParam(report.getPayWayId())) {
					reportVo.setPayWayName(PayWay.getInfo(report.getPayWayId(),
							false));
				}
				reportVo.setAddress(regionService.getRcdAddress(
						report.getProvinceRegionCode(),
						report.getCityRegionCode(),
						report.getDistrictRegionCode())
						+ report.getStreetInfo());
				results.add(reportVo);
			}
		}
		if (results != null) {
			if (results.size() > 0) {
				results.get(0).setAllLenderAmount(allLenderAmount);
				results.get(0).setInvestment(index - 1);
			}
		}

		return results;
	}

	private FormParamDto convert(Map<String, Object> map) {
		FormParamDto reportManagementQueryDto = new FormParamDto();
		String createUser = (String) map.get("createUser");
		String productId = (String) map.get("productId");
		String lenderAmountArea = (String) map.get("lenderAmountArea");
		String branchOfficeId = (String) map.get("branchOfficeId");
		String orgId = (String) map.get("orgId");
		String areaOrgIds = (String) map.get("areaOrgIds");
		String teamIdss = (String) map.get("cluster");
		String teamId = (String) map.get("teamId");
		String statementDate = (String) map.get("statementDate");
		String settlementDateBeg = (String) map.get("settlementDateBeg");
		String settlementDateEnd = (String) map.get("settlementDateEnd");
		String custName = (String) map.get("custName");
		reportManagementQueryDto.setCustName(custName);
		if (Assert.checkParam(productId)) {
			if (Long.parseLong(productId) >= 0) {
				reportManagementQueryDto
						.setProductId(Long.parseLong(productId));
			}
		}

		if (Assert.checkParam(lenderAmountArea)) {
			if (Integer.parseInt(lenderAmountArea) >= 0) {
				reportManagementQueryDto.setLenderAmountArea(Integer
						.parseInt(lenderAmountArea));
			}
		}
		if (Assert.checkParam(teamId) && Long.parseLong(teamId) >= 0) {
			reportManagementQueryDto.setTeamId(Long.parseLong(teamId));
		}
		if (Assert.checkParam(teamIdss) && Long.parseLong(teamIdss) >= 0) {
			List<OrgVo> list = amService.queryOrgsByParentId(Long
					.parseLong(teamIdss));
			if (Assert.checkParam(list)) {
				List<Long> teamIds = new ArrayList<Long>();
				for (OrgVo vo : list) {
					teamIds.add(vo.getOrgId());
				}
				if (Assert.checkParam(teamIds)) {
					reportManagementQueryDto.setTeamIds(teamIds);
				}
			}

		}
		if (Assert.checkParam(orgId) && Long.parseLong(orgId) >= 0) {
			reportManagementQueryDto.setOrgId(Long.parseLong(orgId));
		}
		if (Assert.checkParam(branchOfficeId)
				&& Long.parseLong(branchOfficeId) >= 0) {
			List<OrgVo> listBranchOffice = amService.queryOrgsByParentId(Long
					.parseLong(branchOfficeId));
			if (Assert.checkParam(listBranchOffice)) {
				List<Long> branchOfficeIds = new ArrayList<Long>();
				for (OrgVo vo : listBranchOffice) {
					branchOfficeIds.add(vo.getOrgId());
				}
				if (Assert.checkParam(branchOfficeIds)) {
					reportManagementQueryDto
							.setBranchOfficeIds(branchOfficeIds);
				}
			}
		}
		if (Assert.checkParam(areaOrgIds) && Long.parseLong(areaOrgIds) >= 0) {
			List<OrgVo> listArea = amService.queryOrgsByParentId(Long
					.parseLong(areaOrgIds));
			if (Assert.checkParam(listArea)) {
				List<Long> areaIds = new ArrayList<Long>();
				for (OrgVo vo : listArea) {
					if (vo.getCode().indexOf("L") >= 0) {
						if (vo.getCode().indexOf("LFGS") >= 0) {
							List<OrgVo> listbranchOffice = amService
									.queryOrgsByParentId(vo.getOrgId());
							if (Assert.checkParam(listbranchOffice)) {
								for (OrgVo orgVo : listbranchOffice) {
									if (orgVo.getCode().indexOf("L") >= 0) {
										areaIds.add(orgVo.getOrgId());
									}
								}
							}
						} else {
							areaIds.add(vo.getOrgId());
						}
					}

				}
				if (Assert.checkParam(areaIds)) {
					reportManagementQueryDto.setAreaOrgIds(areaIds);
				}
			}
		}

		if (Assert.checkParam(createUser)) {
			Long userIdLong = Long.parseLong(createUser);
			if (userIdLong >= 0) {
				reportManagementQueryDto.setCreateUser(userIdLong);
			}
		}

		if (Assert.checkParam(statementDate)) {
			if (Integer.parseInt(statementDate) >= 0) {
				reportManagementQueryDto.setStatementDate(Integer
						.parseInt(statementDate));
			}
		}

		if (Assert.checkParam(settlementDateBeg)) {
			reportManagementQueryDto.setSettlementDateBeg(DateUtils
					.parseForDay(settlementDateBeg));
		}

		if (Assert.checkParam(settlementDateEnd)) {
			reportManagementQueryDto.setSettlementDateEnd(DateUtils
					.parseForDay(settlementDateEnd));
		}
		return reportManagementQueryDto;
	}

	private FormParamDto convertQuery(FormParamVo reportManagementQueryVo) {
		FormParamDto reportManagementQueryDto = new FormParamDto();
		if (Assert.checkParam(reportManagementQueryVo.getLenderAmountArea())
				&& reportManagementQueryVo.getLenderAmountArea() >= 0) {
			reportManagementQueryDto
					.setLenderAmountArea(reportManagementQueryVo
							.getLenderAmountArea());
		}
		if (Assert.checkParam(reportManagementQueryVo.getTeamId())
				&& reportManagementQueryVo.getTeamId() >= 0) {
			reportManagementQueryDto.setTeamId(reportManagementQueryVo
					.getTeamId());
		}
		if (Assert.checkParam(reportManagementQueryVo.getCluster())
				&& reportManagementQueryVo.getCluster() >= 0) {
			List<OrgVo> list = amService
					.queryOrgsByParentId(reportManagementQueryVo.getCluster());
			if (Assert.checkParam(list)) {
				List<Long> teamIds = new ArrayList<Long>();
				for (OrgVo vo : list) {
					teamIds.add(vo.getOrgId());
				}
				if (Assert.checkParam(teamIds)) {
					reportManagementQueryDto.setTeamIds(teamIds);
				}
			}

		}
		if (Assert.checkParam(reportManagementQueryVo.getOrgId())
				&& reportManagementQueryVo.getOrgId() >= 0) {
			reportManagementQueryDto.setOrgId(reportManagementQueryVo
					.getOrgId());
		}
		if (Assert.checkParam(reportManagementQueryVo.getBranchOfficeIds())
				&& reportManagementQueryVo.getBranchOfficeIds() >= 0) {
			List<OrgVo> listBranchOffice = amService
					.queryOrgsByParentId(reportManagementQueryVo
							.getBranchOfficeIds());
			if (Assert.checkParam(listBranchOffice)) {
				List<Long> branchOfficeIds = new ArrayList<Long>();
				for (OrgVo vo : listBranchOffice) {
					branchOfficeIds.add(vo.getOrgId());
				}
				if (Assert.checkParam(branchOfficeIds)) {
					reportManagementQueryDto
							.setBranchOfficeIds(branchOfficeIds);
				}
			}
		}
		if (Assert.checkParam(reportManagementQueryVo.getAreaOrgIds())
				&& reportManagementQueryVo.getAreaOrgIds() >= 0) {
			List<OrgVo> listArea = amService
					.queryOrgsByParentId(reportManagementQueryVo
							.getAreaOrgIds());
			if (Assert.checkParam(listArea)) {
				List<Long> areaIds = new ArrayList<Long>();
				for (OrgVo vo : listArea) {
					if (vo.getCode().indexOf("L") >= 0) {
						if (vo.getCode().indexOf("LFGS") >= 0) {
							List<OrgVo> listbranchOffice = amService
									.queryOrgsByParentId(vo.getOrgId());
							if (Assert.checkParam(listbranchOffice)) {
								for (OrgVo orgVo : listbranchOffice) {
									if (orgVo.getCode().indexOf("L") >= 0) {
										areaIds.add(orgVo.getOrgId());
									}
								}
							}
						} else {
							areaIds.add(vo.getOrgId());
						}
					}

				}
				if (Assert.checkParam(areaIds)) {
					reportManagementQueryDto.setAreaOrgIds(areaIds);
				}
			}
		}

		if (Assert.checkParam(reportManagementQueryVo.getProductId())
				&& reportManagementQueryVo.getProductId() >= 0) {
			reportManagementQueryDto.setProductId(reportManagementQueryVo
					.getProductId());
		}
		if (Assert.checkParam(reportManagementQueryVo.getStatementDate())
				&& reportManagementQueryVo.getStatementDate() >= 0) {
			reportManagementQueryDto.setStatementDate(reportManagementQueryVo
					.getStatementDate());
		}

		if (Assert.checkParam(reportManagementQueryVo.getCreateUser())
				&& reportManagementQueryVo.getCreateUser() >= 0) {
			reportManagementQueryDto.setCreateUser(reportManagementQueryVo
					.getCreateUser());
		}

		if (Assert.checkParam(reportManagementQueryVo.getSettlementDateBeg())) {
			reportManagementQueryDto
					.setSettlementDateBeg(DateUtils
							.parseForDay(reportManagementQueryVo
									.getSettlementDateBeg()));
		}
		if (Assert.checkParam(reportManagementQueryVo.getSettlementDateEnd())) {
			reportManagementQueryDto
					.setSettlementDateEnd(DateUtils
							.parseForDay(reportManagementQueryVo
									.getSettlementDateEnd()));
		}
		reportManagementQueryDto.setCustName(reportManagementQueryVo
				.getCustName());
		return reportManagementQueryDto;
	}

	private PaginationResult<List<ReportResultVo>> convertResults(
			PaginationResult<List<FormDto>> reportManagementDtos,
			FormParamDto reportManagermentQueryDto, Map<String, Object> map) {
		List<ReportResultVo> results = new ArrayList<ReportResultVo>();
		Map<Long, OrgVo> orgMap = new HashMap<Long, OrgVo>();
		OrgVo teamVo = null;
		OrgVo clusterVo = null;
		Integer index = 1;

		if (Assert.checkParam(reportManagementDtos.getR())) {
			for (FormDto report : reportManagementDtos.getR()) {
				String giveProvinceRegionCode = "";
				String giveCityRegionCode = "";
				String giveSubBankString = "";
				String giveBank = "";
				String getProvinceRegionCode = "";
				String getCityRegionCode = "";
				String getSubBankString = "";
				String getBank = "";

				ReportResultVo reportManagementResultVo = new ReportResultVo();
				BeanUtils.copyProperties(report, reportManagementResultVo);
				reportManagementResultVo.setIndex(index);
				if (Assert.checkParam(report.getGiveProvinceRegionCode())) {
					giveProvinceRegionCode = regionService
							.getRegionNameByCode(report
									.getGiveProvinceRegionCode());
				}
				if (Assert.checkParam(report.getGiveCityRegionCode())) {
					giveCityRegionCode = regionService
							.getRegionNameByCode(report.getGiveCityRegionCode());
				}
				if (Assert.checkParam(report.getGiveSubBank())) {
					giveSubBankString = report.getGiveSubBank();
				}
				if (Assert.checkParam(report.getGiveBankCategory())) {
					giveBank = BankCategery.getInfo(report
							.getGiveBankCategory());
				}
				reportManagementResultVo
						.setGiveBankCategory(giveProvinceRegionCode
								+ giveCityRegionCode + giveBank
								+ giveSubBankString);

				if (Assert.checkParam(report.getGetProvinceRegionCode())) {
					getProvinceRegionCode = regionService
							.getRegionNameByCode(report
									.getGetProvinceRegionCode());
				}
				if (Assert.checkParam(report.getGetCityRegionCode())) {
					getCityRegionCode = regionService
							.getRegionNameByCode(report.getGetCityRegionCode());
				}
				if (Assert.checkParam(report.getGetSubBank())) {
					getSubBankString = report.getGetSubBank();
				}
				if (Assert.checkParam(report.getGetBankCategory())) {
					getBank = BankCategery.getInfo(report.getGetBankCategory());
				}
				reportManagementResultVo
						.setGetBankCategory(getProvinceRegionCode
								+ getCityRegionCode + getBank
								+ getSubBankString);
				++index;
				if (Assert.checkParam(report.getSignDate())) {
					reportManagementResultVo.setSignDate(DateUtils
							.formatForDay(report.getSignDate()));
				}
				if (Assert.checkParam(report.getMatchDate())) {
					reportManagementResultVo.setMatchDate(DateUtils
							.formatForDay(report.getMatchDate()));
				}
				if (Assert.checkParam(report.getSettlementDate())) {
					reportManagementResultVo.setSettlementDate(DateUtils
							.formatForDay(report.getSettlementDate()));
				}
				if (Assert.checkParam(report.getExpectLenderDateBegin())
						&& Assert.checkParam(report.getExpectLenderDateEnd())) {
					reportManagementResultVo.setExpectLenderDate(format(
							report.getExpectLenderDateBegin(), "yyyy/MM/dd")
							+ "-"
							+ format(report.getExpectLenderDateEnd(),
									"yyyy/MM/dd"));
				}
				if (Assert.checkParam(report.getTeamId())) {
					teamVo = commonService.queryOrgCache(report.getTeamId(),
							orgMap);
					Assert.notNull("teamVo cannot be null", teamVo);
					clusterVo = commonService.queryOrgCache(
							teamVo.getParentId(), orgMap);
					Assert.notNull("clusterVo cannot be null", clusterVo);
					reportManagementResultVo.setClusterName((!Assert
							.checkParam(clusterVo.getName()) || !clusterVo
							.getName().startsWith("Cluster")) ? "" : clusterVo
							.getName());
					reportManagementResultVo.setTeamName(teamVo.getName());
					List<UserVo> teamUserVos = amService.queryUserByOrgAndRole(
							teamVo.getOrgId(), "WMS-TDJL");
					if (teamUserVos.size() != 0) {
						reportManagementResultVo.setTeamUserName(teamUserVos
								.get(0).getName());
					}
				}

				if (Assert.checkParam(report.getOrgId())) {
					OrgVo orgVo = commonService.queryOrgCache(
							report.getOrgId(), orgMap);
					reportManagementResultVo.setOrgName(orgVo.getName());
					if (Assert.checkParam(orgVo.getParentId())) {
						OrgVo branchOffice = commonService.queryOrgCache(
								orgVo.getParentId(), orgMap);
						reportManagementResultVo
								.setBranchOfficeName(branchOffice.getName());
						if (Assert.checkParam(branchOffice.getParentId())) {
							OrgVo area = commonService.queryOrgCache(
									branchOffice.getParentId(), orgMap);
							reportManagementResultVo
									.setAreaName(area.getName());
						}
					}
				}
				if (Assert.checkParam(report.getCreateUser())) {
					reportManagementResultVo.setCreateUser(amService
							.queryUserById(report.getCreateUser()).getName());
				}
				if (Assert.checkParam(report.getMsgWay())) {
					reportManagementResultVo.setMsgWay(MsgWay.getInfo(
							report.getMsgWay(), false));
				}
				if (Assert.checkParam(report.getProductId())) {
					reportManagementResultVo.setProductName(commonService
							.queryByProductId(report.getProductId())
							.getProductName());
				}
				if (Assert.checkParam(report.getCustCategory())) {
					reportManagementResultVo.setCustCategory(CustCategery
							.getInfo(report.getCustCategory(), false));
				}
				if (Assert.checkParam(report.getPayWayId())) {
					reportManagementResultVo.setPayWayName(PayWay.getInfo(
							report.getPayWayId(), false));
				}

				reportManagementResultVo.setAddress(regionService
						.getRcdAddress(report.getProvinceRegionCode(),
								report.getCityRegionCode(),
								report.getDistrictRegionCode())
						+ report.getStreetInfo());
				results.add(reportManagementResultVo);
			}
		}
		return new PaginationResult<List<ReportResultVo>>(results,
				reportManagementDtos.getPagination());
	}

	/**
	 * 
	 * 报表信息管理营业部选择页面传入大团经理信息查询框，以及大团查出小团信息
	 * 
	 * @param request
	 * @param orgId
	 * @return List<OrgVo>
	 */
	@RequestMapping(value = "orgs.json")
	@ResponseBody
	public List<OrgVo> queryOrgs(Long orgId, HttpServletRequest request) {
		Assert.notNull("orgId cannot be null", orgId);
		return amService.queryOrgsByParentId(orgId);
	}

	/**
	 * 
	 * 报表信息管理根据条件查询投资数和投资金额
	 * 
	 * @param request
	 * @param reportManagementQueryVo
	 * @return ReportManagementDto
	 */
	@RequestMapping(value = "allLenderAmount.json")
	@ResponseBody
	public FormDto allLenderAmount(
			@RequestBody FormParamVo reportManagementQueryVo,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVo user = (UserVo) session.getAttribute("user");
		Long userId = user.getUserId();
		List<RoleVo> myRoList = amService.findRolesByUserId(userId);
		Map<String, Object> map = new HashMap<String, Object>();
		OrgVo orgVo = amService.queryOrgByUserId(userId);
		map.put("orgVo", orgVo);
		map.put("reportManagementQueryVo", reportManagementQueryVo);
		map.put("roleVos", myRoList);
		FormParamDto reportManagementQueryDto = convertQuery(reportExecutorService
				.getManagementQueryVo(map));

		map.put("reportManagementQueryDto", reportManagementQueryDto);
		FormDto reportManagementDto = reportExecutorService
				.queryallLenderAmount(map);
		return reportManagementDto;

	}

	/**
	 * 
	 * 报表信息管理区域经理选择页面传入分公司信息查询框
	 * 
	 * @param orgId
	 * @param request
	 * @return List<OrgVo>
	 */
	@RequestMapping(value = "branchOfficeByorgs.json")
	@ResponseBody
	public List<OrgVo> queryBranchOfficeOrgs(Long orgId,
			HttpServletRequest request) {
		Assert.notNull("areaOrgId cannot be null", orgId);
		List<OrgVo> orgVos = amService.queryOrgsByParentId(orgId);
		List<OrgVo> branchOfficeOrgs = new ArrayList<OrgVo>();
		for (int i = 0; i < orgVos.size(); i++) {
			if (orgVos.get(i).getCode().indexOf("LFGS") >= 0) {
				branchOfficeOrgs.add(orgVos.get(i));
			}
		}
		return branchOfficeOrgs;
	}

	/**
	 * 
	 * 报表信息管理分公司选择页面传入营业部信息查询框
	 * 
	 * @param orgId
	 * @param request
	 * @return List<OrgVo>
	 */
	@RequestMapping(value = "branchOfficeInOrgs.json")
	@ResponseBody
	public List<OrgVo> queryInBranchOfficeOrgs(Long orgId,
			HttpServletRequest request) {
		Assert.notNull("BranchOfficeorgId cannot be null", orgId);
		List<OrgVo> orgVos = amService.queryOrgsByParentId(orgId);
		List<OrgVo> branchOfficeOrgs = new ArrayList<OrgVo>();
		for (int i = 0; i < orgVos.size(); i++) {
			if (orgVos.get(i).getCode().indexOf("L") >= 0) {
				branchOfficeOrgs.add(orgVos.get(i));
			}
		}
		return branchOfficeOrgs;
	}

	/**
	 * 
	 * 报表信息管理团队选择页面传入客户经理信息查询框
	 * 
	 * @param orgId
	 * @return List<OrgVo>
	 */
	@RequestMapping(value = "custManagers.json")
	@ResponseBody
	public List<UserVo> queryCustManagers(Long orgId) {
		Assert.notNull("orgId cannot be null", orgId);
		return amService.queryUserByOrgAndRole(orgId, RoleConstant.KHJL);
	}

	public static String format(Date arg0, String arg1) {
		Assert.notNull("param is null", arg0, arg1);
		return new SimpleDateFormat(arg1).format(arg0);

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/pdf.json")
	@ResponseBody
	public <P, R> Map<String, String> pdf(HttpServletRequest request,
			@RequestBody ProcessResultVo processResultVo){
		LOG.info("****pdf() processResult={}****",
				new Gson().toJson(processResultVo.getProcessResult()));
		Map<String, String> result = new HashMap<String, String>();
		String address = request.getLocalAddr();
		int port = request.getLocalPort();
		String realPath = "http://"+address+":"+String.valueOf(port)+"/";
		String pdfPath = tempPath + "pdfTemp";
		try {
			ReportParamDto<P, R> dto = new ReportParamDto<P, R>();
			dto.setParam((List<P>)set(Arrays.asList(processResultVo.getProcessResult())));
			dto.setPath(pdfPath);
			dto.setRealAddress(realPath);
			dto.setReportType(ReportType.FIRST.getCode());
			List<String> urls = reportManager.pdf(dto);
			String zipPath = reportManager.zip(urls, tempPath, UUID.randomUUID().toString());
			result.put("msg", "ok");
			result.put("path", zipPath);
		} catch (ConvertException e) {
			dealExections(result,e);
			LOG.info("** 生成pdf异常: ,result={}",result,e);
		}
		return result;
	}

	@RequestMapping("download.json")
	public void fileDownload(HttpServletRequest request,
			HttpServletResponse response) {
		String path = "";
		try {
			path = new String(request.getParameter("path")
					.getBytes("ISO8859-1"), "UTF-8");
			LOG.info("**fileDownload() path={}",path); 
		} catch (UnsupportedEncodingException e) {
			throw new BaseException("资源路径获取失败",e);
		}
		String zipName = new StringBuffer().append(ZIPFILENAME).append(DateUtils.formatForDay(new Date())).toString();
		// 下载
		FileUtils.download(response, path,zipName );
	}

	private <P, R> List<ParamConvertDto<P, R>> set(List<ProcessResultVo> params) {
		List<ParamConvertDto<P, R>> dtos = new ArrayList<>();
		for (ProcessResultVo vo : params) {
			ParamConvertDto<P, R> dto = new ParamConvertDto<P, R>();
			dto.setLenderCode(vo.getLenderCode());
			dto.setProtocolFileName(vo.getProtocolFileName());
			dtos.add(dto);
		}
		return dtos;
	}
	
	@RequestMapping("/init.json")
    public  Object init( String biz ,String lenderCode, Model model) {
    	Map<String, Object> result = reportManager.view(getViewDto(lenderCode,biz));
    	model.addAttribute(REPORT, result.get("result"));
        return result.get("url");
    }
	
	@SuppressWarnings("unchecked")
	public  <P, R> ReportParamDto<P, R> getViewDto(String lenderCode ,String biz){
    	ReportParamDto<P, R> dto = new ReportParamDto<P, R>();
    	List<ParamConvertDto<P,R>> converDtos = new ArrayList<>();
    	ParamConvertDto<P, R> convertDto = new ParamConvertDto<P, R>();
    	convertDto.setLenderCode(lenderCode);
    	convertDto.setProtocolFileName("模版文件");
    	converDtos.add(convertDto);
    	dto.setParam((List<P>) (converDtos));
    	dto.setReportType(getEnum(biz).getCode());
    	return dto;
    }
    
	private ReportType getEnum(String biz){
		switch (biz) {
		case "first" :
			return ReportType.FIRST;

		case "effectFirst" :
			return ReportType.EFFECTFIRST;
		}
		throw new BaseException("unSupport ReportType");
	}
	
	
	private String getDate() {
		return DateUtils.format(new Date(), "yyyyMMddHHmmss");
	}

	private void dealExections(Map<String, String> result,BaseException e) {
		result.put("msg", "error");
		switch (e.getCode()) {
		case "1":
			result.put("cause", "PDF创建异常");
			break;
		case "2":
			result.put("cause", "PDF打包异常");
			break;
		default:
			result.put("cause", "PDF数据异常");
			break;
		}
	}
}
