package com.dx.cmm.service.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.cmm.service.entitys.BaseEntity;

/**
 * 
 * 债权匹配管理-匹配用户关系
 *
 * @author tony
 */
@Entity(name = "t_match_user_relation")
public class MatchUserRelation extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = 8031917081604665658L;

    /**
     * 删除
     */
    public static final String DEL = "D";

    /**
     * 匹配用户关系-编号
     */
    private Long matchUserRelationId;

    /**
     * 匹配投资用户-编号
     */
    private Long investmentUserId;

    /**
     * 匹配债权用户-编号
     */
    private Long creditorUserId;

    public MatchUserRelation() {

    }

    public MatchUserRelation(Long invest, Long credit) {
        setInvestmentUserId(invest);
        setCreditorUserId(credit);
        insert();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_user_relation_id")
    public Long getMatchUserRelationId() {
        return matchUserRelationId;
    }

    public void setMatchUserRelationId(Long matchUserRelationId) {
        this.matchUserRelationId = matchUserRelationId;
    }

    @Column(name = "investment_user_id")
    public Long getInvestmentUserId() {
        return investmentUserId;
    }

    public void setInvestmentUserId(Long investmentUserId) {
        this.investmentUserId = investmentUserId;
    }

    @Column(name = "creditor_user_id")
    public Long getCreditorUserId() {
        return creditorUserId;
    }

    public void setCreditorUserId(Long creditorUserId) {
        this.creditorUserId = creditorUserId;
    }
}
