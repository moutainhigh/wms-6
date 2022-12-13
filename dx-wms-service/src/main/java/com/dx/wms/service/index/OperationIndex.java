package com.dx.wms.service.index;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.dx.ccs.vo.RoleVo;
import com.dx.wms.constant.RoleConstant;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class OperationIndex extends IndexService {

    @Override
    public Boolean isSupport(IndexQueryDto q) {
        for (RoleVo role : q.getRoleList()) {
            if (StringUtils.isNotBlank(role.getCode())) {
                if (role.getCode().equals(RoleConstant.YY)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public String initPage(IndexQueryDto q) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IndexResultDto initDate(IndexQueryDto q) {
        // TODO Auto-generated method stub
        return null;
    }

}
