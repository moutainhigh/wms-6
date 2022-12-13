package com.dx.wms.service.detail;

import java.util.List;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.exception.ObjectNotFoundException;

/**
 * 
 * 业务类型
 *
 * @author tony
 */
public enum DetailType {

    /**
     * 开户申请
     */
    ACCOUNT("account", "开户申请", AccountTab.geTabs()),

    /**
     * 理财申请
     */
    APPLY("apply", "理财申请", ApplyTab.geTabs()),

    /**
     * 入职审批
     */
    EMPLOYEE("employee", "个人信息", EntryTab.geTabs()),
    
    /**
     * 综合查询
     */
    SYNTHESIZE("synthesize", "", SynthesizeTab.geTabs());
    
    DetailType(String info, String title, List<TabDetail> details) {
        setInfo(info);
        setTitle(title);
        setDetails(details);
    }

    /**
     * 标示
     */
    private String info;

    /**
     * 标题
     */
    private String title;

    /**
     * 板块
     */
    private List<TabDetail> details;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TabDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TabDetail> details) {
        this.details = details;
    }

    public static DetailType get(String info) {
        Assert.checkParam("Info must not be null", info);
        for (DetailType detail : DetailType.values()) {
            if (Assert.equals(detail.getInfo(), info)) {
                return detail;
            }
        }
        throw new ObjectNotFoundException("Detail info[{0}] not found", info);
    }

}
