package com.dx.cmm.service.rules;

import com.dx.cmm.service.common.DataService;
import com.dx.cmm.service.manager.Parser;

/**
 * 
 * 规则器
 *
 * @author tony
 */
public interface Ruler extends DataService<ParamRuler>, Parser<ParamRuler, ResultRuler> {

}
