package com.dx.wms.report.fillData;

import java.util.Observable;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.wms.dto.TemplateProcessDto;
import com.dx.wms.observer.base.ObserverAstr;

public abstract class FillObserver<P, R> extends ObserverAstr<TemplateProcessDto<P, R>>{
	
	 /**
     * 日志组件
     */
    public static final Logger LOG = LoggerFactory.getLogger(FillObserver.class);
    
    @Autowired
    private FillRouters router;
    
    @PostConstruct
    public void init() {
        router.addObserver(this);
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		TemplateProcessDto<P, R> param = (TemplateProcessDto<P, R>) arg;
		if(!supports(param)){
			return;
		}
		execute(param);
	}
	
	protected void execute(TemplateProcessDto<P, R> param){
		
	}
}
