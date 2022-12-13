package com.dx.wms.service.detail;

/**
 * 
 * 详情结果 
 *
 * @author tony
 */
import java.util.List;

import com.dx.cms.dto.FolderResultDto;
import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.log.LogResultDto;

/**
 * 
 * 结果详情
 *
 * @author tony
 */
public class ResultDetail extends BaseEntitys {

    /**
     */
    private static final long serialVersionUID = 2171206367664618504L;

    /**
     * 标题
     */
    private String title;

    /**
     * 板块信息
     */
    private List<TabDetail> tabs;

    /**
     * 日志信息
     */
    List<LogResultDto> logs;

    /**
     * 文件夹信息
     */
    private List<FolderResultDto> folders;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TabDetail> getTabs() {
        return tabs;
    }

    public void setTabs(List<TabDetail> tabs) {
        this.tabs = tabs;
    }

    public List<LogResultDto> getLogs() {
        return logs;
    }

    public void setLogs(List<LogResultDto> logs) {
        this.logs = logs;
    }

    public List<FolderResultDto> getFolders() {
        return folders;
    }

    public void setFolders(List<FolderResultDto> folders) {
        this.folders = folders;
    }
}
