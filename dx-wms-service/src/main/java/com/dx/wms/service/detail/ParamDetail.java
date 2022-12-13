package com.dx.wms.service.detail;

/**
 * 
 * 详情参数
 *
 * @author tony
 */
public class ParamDetail {

    /**
     * 详情
     */
    private DetailType detail;

    /**
     * 编号{detail=account,id=accountId},{detail=apply,id=applyId},{detail=entry,id=employeeId}
     */
    private Long id;

    public ParamDetail() {

    }

    public ParamDetail(DetailType detail, Long id) {
        setDetail(detail);
        setId(id);
    }

    public DetailType getDetail() {
        return detail;
    }

    public void setDetail(DetailType detail) {
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
