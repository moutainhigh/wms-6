/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: ObservableAstr.java
 * Author:   caidengyong
 * Date:     2016年7月7日 下午1:14:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.observer.base;

import java.util.Observable;

/*
 * 主题/被观察者抽象
 */
public abstract class ObservableAstr<P> extends Observable{

	public void execute(P p) {
		setChanged();
		notifyObservers(p);
	}

	public void execute() {
		execute(null);
	}
}
