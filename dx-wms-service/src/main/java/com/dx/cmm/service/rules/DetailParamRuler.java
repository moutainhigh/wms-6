package com.dx.cmm.service.rules;

import java.io.Serializable;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DetailParamRuler implements Serializable {

    /**
     */
    private static final long serialVersionUID = -2359806895659637838L;

    private Long userId;

    private String appCode;

    /**
     * 匹配投资用户-编号
     */
    private Long investUser;

    /**
     * 匹配债权用户-编号
     */
    private Long creditUser;

    public DetailParamRuler() {

    }

    public DetailParamRuler(Long investUser, Long creditUser) {
        setInvestUser(investUser);
        setCreditUser(creditUser);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Long getInvestUser() {
        return investUser;
    }

    public void setInvestUser(Long investUser) {
        this.investUser = investUser;
    }

    public Long getCreditUser() {
        return creditUser;
    }

    public void setCreditUser(Long creditUser) {
        this.creditUser = creditUser;
    }

}
