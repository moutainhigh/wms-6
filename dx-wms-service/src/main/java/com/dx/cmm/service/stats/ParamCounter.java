package com.dx.cmm.service.stats;

import java.io.Serializable;

import com.dx.cmm.enums.BizCategory;
import com.dx.cmm.enums.MatchModule;

/**
 * 
 * 统计参数Dto<br>
 * 统计参数Dto
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ParamCounter implements Serializable {

    /**
     */
    private static final long serialVersionUID = -1108638537526639597L;

    /**
     * 业务类别
     */
    private Integer type;

    /**
     * 业务类型
     */
    private BizCategory biz;

    /**
     * 模块
     */
    private MatchModule module;

    public ParamCounter() {

    }

    public ParamCounter(MatchModule module){
        setModule(module);
    }
    public ParamCounter(String biz,MatchModule module) {
        setType(BizCategory.getCode(biz));
        setBiz(BizCategory.getEunm(biz));
        setModule(module);
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BizCategory getBiz() {
        return biz;
    }

    public void setBiz(BizCategory biz) {
        this.biz = biz;
    }

    public MatchModule getModule() {
        return module;
    }

    public void setModule(MatchModule module) {
        this.module = module;
    }

}
