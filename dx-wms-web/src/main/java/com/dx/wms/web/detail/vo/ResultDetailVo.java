package com.dx.wms.web.detail.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cms.dto.FolderResultDto;
import com.dx.common.service.utils.Assert;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.wms.cla.web.vo.LogResultVo;
import com.dx.wms.service.detail.ResultDetail;
import com.dx.wms.service.detail.TabDetail;
import com.dx.wms.service.log.LogResultDto;
import com.dx.wms.web.hr.vo.EmployeeEntryVo;
import com.dx.wms.web.vo.BaseEntityVo;

/**
 * 
 * 结果详情
 *
 * @author tony
 */
public class ResultDetailVo extends BaseEntityVo {

    /**
     */
    private static final long serialVersionUID = 381963822674217439L;

    /**
     * 标题
     */
    private String title;

    /**
     * 板块信息
     */
    private List<TabDetail> tabs;

    /**
     * 文件夹信息
     */
    private List<FolderResultDto> folders;

    /**
     * 文件夹信息
     */
    private List<FolderVo> folderVos;

    /**
     * 日志信息
     */
    private List<LogResultDto> logs;

    /**
     * 日志信息
     */
    private List<LogResultVo> logVos;

    /**
     * 员工信息
     */
    private EmployeeEntryVo employeeEntryVo;
    
    
    public ResultDetailVo() {

    }

    public ResultDetailVo(ResultDetail detail,EmployeeEntryVo employeeEntryVo) {
        BeanUtils.copyProperties(detail, this);
        setEmployeeEntryVo(employeeEntryVo);
    }
    
    public ResultDetailVo(ResultDetail detail){
        BeanUtils.copyProperties(detail, this);
        setAccountVo().setProfessionVo();
        
        if(!Assert.checkParam(getComm())){
            setCommVo(new CustCommVo());
        }
        if(!Assert.checkParam(getLinkman())){
            setLinkmanVo(new CustLinkmanVo());
        }
    }
    public ResultDetailVo(ResultDetail detail, String area, String product, Map<Integer, String> bank,IRegionNewService regionNewService) {
        BeanUtils.copyProperties(detail, this);
        setAccountVo().setCommVo(area).setLinkmanVo().setProfessionVo().setApplyVo(product).setConditionVos()
                .setFinancesVos(bank,regionNewService);
        setFolderVos().setLogVos();
    }

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

    public List<LogResultVo> getLogVos() {
        return logVos;
    }

    public ResultDetailVo setLogVos(List<LogResultVo> logVos) {
        this.logVos = logVos;
        return this;
    }

    public ResultDetailVo setLogVos() {
        if (Assert.checkParam(getLogs())) {
            List<LogResultVo> logVos = new ArrayList<>();
            for (LogResultDto log : getLogs()) {
                logVos.add(new LogResultVo(log));
            }
            setLogVos(logVos);
        }
        return this;
    }

    public List<FolderResultDto> getFolders() {
        return folders;
    }

    public void setFolders(List<FolderResultDto> folders) {
        this.folders = folders;
    }

    public List<FolderVo> getFolderVos() {
        return folderVos;
    }

    public ResultDetailVo setFolderVos(List<FolderVo> folderVos) {
        this.folderVos = folderVos;
        return this;
    }

    public ResultDetailVo setFolderVos() {
        if (Assert.checkParam(getFolders())) {
            List<FolderVo> folderVos = new ArrayList<>();
            for (FolderResultDto folder : getFolders()) {
                folderVos.add(new FolderVo(folder));
            }
            setFolderVos(folderVos);
        }
        return this;
    }

	public EmployeeEntryVo getEmployeeEntryVo() {
		return employeeEntryVo;
	}

	public void setEmployeeEntryVo(EmployeeEntryVo employeeEntryVo) {
		this.employeeEntryVo = employeeEntryVo;
	}
    
    


}
