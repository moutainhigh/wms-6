package com.dx.cmm.service.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class AccountRuler<P, R> extends RulersAbs<P, R> {

    /**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger("account.rulers");
}
