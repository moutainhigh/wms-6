/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileCodeUtil.java
 * Author:   黄健
 * Date:     2015年9月9日 下午4:58:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.service.util;

import java.text.MessageFormat;

import com.dx.common.service.utils.Assert;

public final class FileCodeUtils {

    /**
     * 组装未生效影像文件的临时openCode
     *
     * @param appCode 系统标示
     * @param resKey 资源标示
     * @param bizId 用户主键或业务主键
     * @return 未生效影像文件的临时openCode 或 空
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String init(String appCode, String resKey, Long bizId) {
        Assert.notNull("App code must not be null", appCode);
        Assert.notNull("Res key must not be null", resKey);
        Assert.notNull("Arg id must not be null", bizId);
        return MessageFormat.format("{0}{1}{2}", appCode, resKey, Long.toString(bizId));
    }

}
