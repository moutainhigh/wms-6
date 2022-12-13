package com.dx.wms.web.detail.vo;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.dx.cms.dto.FileResultDto;
import com.dx.cms.dto.FolderResultDto;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 文件夹信息
 * 
 * @author tony
 */
public class FolderVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -431449295827668795L;

    private static final String GREY = "btn grey";

    private static final String BLUE = "btn blue switch";

    private static final String CLOSE = "未上传";

    private static final String OPEN = "展开";
    /**
     * 文件目录-编号
     */
    private String id;

    /**
     * 文件目录-名称
     */
    private String name;

    /**
     * 某一目录下文件数量
     */
    private String num;

    /**
     * 文件目录-标示
     */
    private String dirKey;

    /**
     * 文件
     */
    private List<FileVo> files;

    /**
     * 按钮内容
     */
    private String btnContent = OPEN;

    /**
     * 按钮样式
     */
    private String btnClass = BLUE;

    public FolderVo() {

    }

    public FolderVo(FolderResultDto base) {
        setName(base.getFileDirName());
        setNum(String.valueOf(base.getFileResultDtoes().size()));
        setBtnClass(base.getFileResultDtoes().size() > 0 ? BLUE : GREY);
        setBtnContent(base.getFileResultDtoes().size() > 0 ? OPEN : CLOSE);
        setId(MessageFormat.format("folder_{0}", base.getFileDirId()));
        if (Assert.checkParam(base.getFileResultDtoes())) {
            List<FileVo> files = new ArrayList<>();
            for (FileResultDto file : base.getFileResultDtoes()) {
                files.add(new FileVo(file));
            }
            setFiles(files);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDirKey() {
        return dirKey;
    }

    public void setDirKey(String dirKey) {
        this.dirKey = dirKey;
    }

    public List<FileVo> getFiles() {
        return files;
    }

    public void setFiles(List<FileVo> files) {
        this.files = files;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBtnContent() {
        return btnContent;
    }

    public void setBtnContent(String btnContent) {
        this.btnContent = btnContent;
    }

    public String getBtnClass() {
        return btnClass;
    }

    public void setBtnClass(String btnClass) {
        this.btnClass = btnClass;
    }

}
