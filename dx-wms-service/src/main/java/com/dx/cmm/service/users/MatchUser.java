package com.dx.cmm.service.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.entitys.BaseEntity;

/**
 * 债权匹配管理-匹配用户实体
 *
 * @author 朱道灵
 */
@Entity(name = "t_match_user")
public class MatchUser extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -8234882940247740866L;

    /**
     * 匹配用户-编号 主键
     */
    private Long matchUserId;

    /**
     * 匹配用户-姓名
     */
    private String matchCustName;

    /**
     * 匹配用户-客户编号
     */
    private String matchCustCode;

    /**
     * 匹配用户-身份证
     */
    private String matchCustIdCard;

    public MatchUser() {

    }

    public MatchUser(MatchBizBase base) {
        setMatchCustIdCard(base).setMatchCustCode(base).setMatchCustName(base).setCreateTime().setCreateUser()
                .setUpdateTime().setUpdateUser().setDataStatus();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_user_id")
    public Long getMatchUserId() {
        return matchUserId;
    }

    public void setMatchUserId(Long matchUserId) {
        this.matchUserId = matchUserId;
    }

    @Column(name = "match_cust_name")
    public String getMatchCustName() {
        return matchCustName;
    }

    public MatchUser setMatchCustName(String matchCustName) {
        this.matchCustName = matchCustName;
        return this;
    }

    public MatchUser setMatchCustName(MatchBizBase base) {
        return setMatchCustName(base.getCustName());
    }

    @Column(name = "match_cust_code")
    public String getMatchCustCode() {
        return matchCustCode;
    }

    public MatchUser setMatchCustCode(String matchCustCode) {
        this.matchCustCode = matchCustCode;
        return this;
    }

    public MatchUser setMatchCustCode(MatchBizBase base) {
        return setMatchCustCode(base.getBizCustCode());
    }

    @Column(name = "match_cust_id_card")
    public String getMatchCustIdCard() {
        return matchCustIdCard;
    }

    public MatchUser setMatchCustIdCard(String matchCustIdCard) {
        this.matchCustIdCard = matchCustIdCard;
        return this;
    }

    public MatchUser setMatchCustIdCard(MatchBizBase base) {
        return setMatchCustIdCard(base.getIdCard());
    }

}
