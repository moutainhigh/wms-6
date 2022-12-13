/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: IChangeInfoService.java
 * Author:   yangbao
 * Date:     2016年1月7日 下午9:16:07
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.changer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IChangeInfoService {
    
    /**
     * 
     * 功能描述: 获取变更信息中的出借方式、组织和团队 〈功能详细描述〉
     *
     * @param InfoChangeResultDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    InfoChangeDto getInfoChangeDto(ResultChanger InfoChangeResultDto);

}
