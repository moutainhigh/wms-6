/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CommonController.java
 * Author:   王蕊
 * Date:     2015年7月22日 下午7:56:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.Trans2Birthday;
import com.dx.common.service.utils.Trans2PinYin;
import com.dx.fms.service.dto.BankInfoDTO;
import com.dx.fms.service.dto.BankParamDTO;
import com.dx.framework.constant.entity.DataItemBean;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.hr.enums.EmployeeStatus;
import com.dx.hr.service.api.IEmployeeService;
import com.dx.hr.service.dto.EmployeeListQueryDto;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.checker.Checker;
import com.dx.wms.service.checker.ParamChecker;
import com.dx.wms.web.vo.BankVo;
import com.dx.wms.web.vo.CustInfoCheckVo;
import com.google.gson.Gson;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉 页面常用的值引用 校验
 * 
 * @author 王蕊
 */
@Controller
@RequestMapping("/common")
public class CommonController {

	/**
	 * 日志组件
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(CommonController.class);

	/**
	 * 校验手机，证件号码重复服务
	 */
	@Autowired
	private Checker checkInfoService;

	/**
	 * 区域服务
	 */
	@Autowired
	private IRegionNewService regionService;

	/**
	 * 人事系统
	 */
	@Autowired
	private IEmployeeService employeeService;

	/**
	 * 公共服务
	 */
	@Autowired
	private ICommonService commonService;

	/**
	 * 
	 * 功能描述: <br>
	 * 〈功能详细描述〉 客户手机号和身份证 唯一性校验
	 * 
	 * @param custInfoCheckVo
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping(value = "check_custInfo.json")
	@ResponseBody
	public boolean checkCustMobile(@RequestBody CustInfoCheckVo custInfoCheckVo) {
		return checkInfoService.check(getCustInfoCheckDto(custInfoCheckVo));
	}

	@RequestMapping(value = "check_mobile.json")
	@ResponseBody
	public Boolean checkMobile(@RequestParam Long custId,
			@RequestParam String mobile) {
		return checkInfoService.check(new ParamChecker(custId, mobile, false));
	}

	@RequestMapping(value = "check_id_card.json")
	@ResponseBody
	public Boolean checkIdCard(@RequestParam Long custId,
			@RequestParam String idCard) {
		return checkInfoService.check(new ParamChecker(custId, idCard, true));
	}

	/**
	 * 
	 * 功能描述: 人事预入职根据证件号码校验唯一性 〈功能详细描述〉
	 *
	 * @param custId
	 * @param idCard
	 */
	@RequestMapping(value = "check_certNo.json")
	@ResponseBody
	public Boolean checkCertNo(@RequestParam String certNo) {
		EmployeeListQueryDto queryDto = new EmployeeListQueryDto();
		queryDto.setCertNo(certNo);
		List<String> dataList = new ArrayList<String>();
		dataList.add(EmployeeStatus.PLAN_ENTRY.getCode());
		dataList.add(EmployeeStatus.REFUSE.getCode());
		dataList.add(EmployeeStatus.ON_JOB.getCode());
		dataList.add(EmployeeStatus.SUBMIT.getCode());
		queryDto.setDataStatusList(dataList);
		return !(employeeService.hasExistEmployee(queryDto));
	}
	
	/**
	 * 
	 * 功能描述:人事入职根据银行卡号校验唯一性  <br>
	 * 〈功能详细描述〉
	 *
	 * @param bankCardNo
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping(value = "check_hrBankCardNo.json")
	@ResponseBody
	public Boolean checkBankCardNo(@RequestParam String bankCardNo) {
		EmployeeListQueryDto  queryDto = new EmployeeListQueryDto();
		queryDto.setBankCardNo(bankCardNo);
		List<String> dateList = new ArrayList<String>();
		dateList.add(EmployeeStatus.ON_JOB.getCode());
		queryDto.setDataStatusList(dateList);
		return !(employeeService.hasExistEmployee(queryDto));

	}

	/**
	 * 
	 * 功能描述: 人事入职根据手机号码校验唯一性 〈功能详细描述〉
	 *
	 * @param custId
	 * @param idCard
	 */
	@RequestMapping(value = "check_hrMobile.json")
	@ResponseBody
	public Boolean checkMobile(@RequestParam String mobile) {
		EmployeeListQueryDto queryDto = new EmployeeListQueryDto();
		queryDto.setMobilePhone(mobile);
		List<String> dataList = new ArrayList<String>();
		dataList.add(EmployeeStatus.ON_JOB.getCode());
		queryDto.setDataStatusList(dataList);
		return !(employeeService.hasExistEmployee(queryDto));
	}

	private ParamChecker getCustInfoCheckDto(CustInfoCheckVo custInfoCheckVo) {
		LOG.info("**checkCustMobile() custInfoCheckVo={}**",
				new Gson().toJson(custInfoCheckVo));
		ParamChecker custInfoCheckDto = new ParamChecker();
		BeanUtils.copyProperties(custInfoCheckVo, custInfoCheckDto);
		return custInfoCheckDto;
	}

	/**
	 * 
	 * 功能描述: <br>
	 * 合同编号唯一性校验
	 * 
	 * @param custInfoCheckVo
	 * @return custInfoCheckDto
	 */
	@RequestMapping(value = "check_contract_code.json")
	@ResponseBody
	public boolean checkContractCode( CustInfoCheckVo custInfoCheckVo) {
		return checkInfoService.checkContractCode(getCustInfoCheckDto(custInfoCheckVo));
	}

	/**
	 * 名字汉字转换拼音
	 * 
	 * @param custInfoCheckVo
	 * @return
	 */
	@RequestMapping(value = "check_spellName.json")
	@ResponseBody
	public Map<String, String> getSpellName(
			@RequestBody CustInfoCheckVo custInfoCheckVo) {
		return getSpellAndBirth(custInfoCheckVo);
	}

	private Map<String, String> getSpellAndBirth(CustInfoCheckVo custInfoCheckVo) {
		LOG.info("**getSpellName() custInfoCheckVo={}**",
				new Gson().toJson(custInfoCheckVo));
		Map<String, String> result = new HashMap<String, String>();
		if (Assert.checkParam(custInfoCheckVo.getCustName())) {
			result.put("custNameSpell",
					Trans2PinYin.getPinYin(custInfoCheckVo.getCustName()));
		}
		if (Assert.checkParam(custInfoCheckVo.getIdCard())) {
			result.put("birthDate",
					Trans2Birthday.ageByIdCard(custInfoCheckVo.getIdCard()));
		}
		if (Assert.checkParam(custInfoCheckVo.getLenderAmount())) {
			result.put("bigLenderAmount",
					AmountUtils.toChinese(custInfoCheckVo.getLenderAmount()));
		}
		return result;
	}

	/**
	 * 通过身份证返回出生日期
	 * 
	 * @param custInfoCheckVo
	 * @return
	 */
	@RequestMapping(value = "change_birthday.json")
	@ResponseBody
	public Map<String, String> getChangeBirthday(
			@RequestBody CustInfoCheckVo custInfoCheckVo) {
		return getSpellAndBirth(custInfoCheckVo);

	}

	/**
	 * 通过出借金额带出中文大写
	 * 
	 * @param custInfoCheckVo
	 * @return
	 */
	@RequestMapping(value = "change_amount.json")
	@ResponseBody
	public Map<String, String> getAmount(
			@RequestBody CustInfoCheckVo custInfoCheckVo) {
		Map<String, String> result = new HashMap<String, String>();
		LOG.info("**getAmount() custInfoCheckVo={}**",
				new Gson().toJson(custInfoCheckVo));
		Long parentId = custInfoCheckVo.getParentId();
		if (Assert.checkParam(parentId)) {
			Boolean isExcees = checkInfoService.checkLenderAmountExceed(
					parentId, custInfoCheckVo.getLenderAmount());
			if (isExcees) {
				return result;
			}
		}
		return getSpellAndBirth(custInfoCheckVo);

	}

	/**
	 * 
	 * 根据父级编号获取市区集合
	 *
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "region.json")
	@ResponseBody
	public List<Map<String, String>> getRegion(
			@RequestParam("param") String param) {
		List<Map<String, String>> results = new ArrayList<Map<String, String>>();
		LinkedList<DataItemBean> itemBeans = regionService
				.getRegionListByParentCode(param);
		if (Assert.checkParam(itemBeans)) {
			for (DataItemBean itemBean : itemBeans) {
				results.add(getArea(itemBean));
			}
		}
		return results;
	}

	private Map<String, String> getArea(DataItemBean itemBean) {
		LOG.info("**getArea() itemBean:{}**", new Gson().toJson(itemBean));
		Map<String, String> result = new HashMap<String, String>();
		result.put("area_code_name", itemBean.getName());
		result.put("area_code_id", itemBean.getCode());
		return result;
	}

	/**
	 * 
	 * 功能描述: 获取支行信息 〈功能详细描述〉
	 *
	 * @param custInfoCheckVo
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping(value = "bank.json")
	@ResponseBody
	public List<BankInfoDTO> queryBank(@RequestBody BankVo bankVo) {
		LOG.info("**queryBank() bankVo{}**", new Gson().toJson(bankVo));
		BankParamDTO bankDto = param(bankVo);
		return commonService.querySubBankNameByCode(bankDto);
	}

	private BankParamDTO param(BankVo bankVo) {
		BankParamDTO bankDto = new BankParamDTO();
		BeanUtils.copyProperties(bankVo, bankDto);
		return bankDto;
	}

}
