/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: ChangeInfoServiceImpl.java
 * Author:   yangbao
 * Date:     2016年1月7日 下午9:20:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.changer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.UserVo;
import com.dx.wms.service.ICommonService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ChangeInfoServiceImpl implements IChangeInfoService {

    /**
     * 公共服务
     */
    @Autowired
    private ICommonService commonService;

    @Override
    public InfoChangeDto getInfoChangeDto(ResultChanger result) {
        Map<Long, OrgVo> orgMap = new HashMap<Long, OrgVo>();
        Map<Long, UserVo> userMap = new HashMap<Long, UserVo>();
        String productName = commonService.queryByProductId(result.getProductId()).getProductName();
        String department = commonService.queryOrgCache(result.getOrgId(), orgMap).getName();
        String custManager = commonService.queryUserCache(result.getCreateUser(), userMap).getName();
        OrgVo teamVo = commonService.queryOrgCache(result.getTeamId(), orgMap);
        OrgVo clusterVo = commonService.queryClusterCache(teamVo, orgMap);
        String currentStep = commonService.queryStatus(result.getFormStatus());
        return new InfoChangeDto(result.getProductId(),productName, department, custManager, teamVo, clusterVo, currentStep);
    }

}
