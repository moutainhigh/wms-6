package com.dx.wms.report.dataClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.view.FirstViewResult;
import com.dx.cmm.service.view.IMatchViewService;
import com.dx.wms.dto.ParamConvertDto;
import com.dx.wms.dto.ReportParamDto;
import com.dx.wms.observer.base.ObserverAstr;

public abstract class DataClientObserver<P, R> extends ObserverAstr<ReportParamDto<P, R>>{
	
    /**
     * 日志组件
     */
    public static final Logger LOG = LoggerFactory.getLogger(DataClientObserver.class);
    
    @Autowired
    protected IMatchViewService<FirstViewResult> firstTransView;
    
    @Autowired
    private DataClientRouters router;
    
    @PostConstruct
    public void init() {
        router.addObserver(this);
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		ReportParamDto<P, R> param = (ReportParamDto<P, R>) arg;
		if(!supports(param)){
			return;
		}
		
		execute(param);
	}
	
	protected void execute(ReportParamDto<P, R> param){
		
	}
	
	protected List<FirstViewResult> getFirstView(ReportParamDto<P, R> param, Boolean effect){
		List<FirstViewResult> views = new ArrayList<FirstViewResult>();
		for(ParamConvertDto<P, R> dto : (List<ParamConvertDto<P, R>>)param.getParam()){
			FirstViewResult result = firstTransView.query(dto.getLenderCode(),effect);
			dealZipCode(result);
			if(param.isView()){
				result.setIsView(true);
			}
			result.setProtocolFileName(dto.getProtocolFileName());
			views.add(result);
		}
		return views;
	}
	
	
	/*
	 * 处理邮编,每个字符加上空白拼接
	 */
	protected  void dealZipCode(FirstViewResult firstViewResult){
		StringBuffer zipCode = new StringBuffer();
		String zipCodes = firstViewResult.getZipCode();
		for(char code : zipCodes.toCharArray()){
			zipCode.append(code+" ");
		}
		firstViewResult.setZipCode(zipCode.toString());
	}

}
