package com.dx.wms.report;

import java.util.Observable;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.common.service.utils.Assert;
import com.dx.wms.dto.ReportParamDto;
import com.dx.wms.observer.base.ObserverAstr;
import com.dx.wms.service.wrapper.ReportPdfWrapper;
import com.dx.wms.service.wrapper.ViewPdfWrapper;

public abstract class ReportObserver<P, R> extends ObserverAstr<ReportParamDto<P, R>>{
	
    /**
     * 日志组件
     */
    public static final Logger LOG = LoggerFactory.getLogger(ReportObserver.class);
    
	@Autowired
    private ReportRouters router;
	
	@Autowired
	protected ViewPdfWrapper<P, R> viewWarpper;
	
	@Autowired
	protected ReportPdfWrapper<P, R> reportWarpper;
    
    @PostConstruct
    public void init() {
        router.addObserver(this);
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		Assert.notNull("**update() arg is can not be null", arg);
		ReportParamDto<P, R> param = (ReportParamDto<P, R>) arg;
		if(!supports(param)){
			return;
		}
		execute(param);
	}
	
	private void execute(ReportParamDto<P, R> param){
		if(param.isView()){
			view(param);
		}else{
			report(param);
		}
	}
	
	protected void report(ReportParamDto<P, R> param){
		
	}
	
	protected void view(ReportParamDto<P, R> param){
		
	}

}
