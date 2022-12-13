package com.dx.cms.service.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.exception.FileException;
import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;
@Service("queryPayment")
public class QueryPayment extends ActionRouter<Condition,List<Long>>{

	@Override
	public List<Long> execute(Condition param) throws FileException {
		LOG.info("**start**execute() param={}", param);
      if(!validate(param)){
    	  return new ArrayList<Long>();
      }
      Map<String, Object> paramMap = new HashMap<String, Object>();
      paramMap.put("resKey", param.getResKey());
      paramMap.put("lenderCode", param.getLenderCode());
      paramMap.put("dataStatus", judgeFileStatus(param.getType()));
      return dalClient.queryForList("contentManagement.queryVoucherPaymentFiles", paramMap, Long.class);
  }
	
	private Boolean validate(Condition param){
		return Assert.checkParam(param) || Assert.checkParam(param.getLenderCode()) ||
				Assert.checkParam(param.getRes());
	}

  private String judgeFileStatus(Integer type) {
      if (1 == type) {
          return WMSConstants.EFFECTIVE;
      } else if (-1 == type) {
          return WMSConstants.DELETED;
      }
		return null;
	}

}
