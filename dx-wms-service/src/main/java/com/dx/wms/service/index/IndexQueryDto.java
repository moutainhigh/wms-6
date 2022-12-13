package com.dx.wms.service.index;

import java.io.Serializable;
import java.util.List;

import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.RoleVo;
import com.dx.ccs.vo.UserVo;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class IndexQueryDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 5244696841167086642L;

    private List<RoleVo> roleList;

    private OrgVo orgVo;

    private UserVo user;

    public IndexQueryDto(List<RoleVo> roleList, OrgVo orgVo, UserVo user) {
        this.roleList = roleList;
        this.orgVo = orgVo;
        this.user = user;
    }

    public List<RoleVo> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleVo> roleList) {
        this.roleList = roleList;
    }

    public OrgVo getOrgVo() {
        return orgVo;
    }

    public void setOrgVo(OrgVo orgVo) {
        this.orgVo = orgVo;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

}
