package com.dx.cmm.service.block;

public class BlockResult extends BlockBase {

    /**
     */
    private static final long serialVersionUID = -6926596445193868775L;

    /**
     * 资金池编号
     */
    private Long poolId;

    /**
     * 当前操作人
     */
    private Long userId;

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
