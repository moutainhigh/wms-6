/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: AllowFileTypes.java
 * Author:   黄健
 * Date:     2016年1月12日 下午6:03:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.enums;

import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum AllowFileTypes {
    /**
     * 文件支持的所有格式
     */
    ALL_FILE_TYPES {
        public String[] getFileTypes() {
            return new String[] { "RAR", "ZIP", "JPG", "PNG", "PDF" };
        }
    },
    /**
     * 压缩文件支持格式
     */
    RAR_FILE_TYPES {
        public String[] getFileTypes() {
            return new String[] { "RAR" };
        }
    },
    // ,"ZIP"
    /**
     * 其他格式文件支持
     */
    OTHER_FILE_TYPES {
        public String[] getFileTypes() {
            return new String[] { "JPG", "PNG", "PDF" };
        }
    };

    public abstract String[] getFileTypes();

    public static List<String> getFileTypes(String resKey) {
        return Arrays.asList(getFileTypesAsArray(resKey));
    }

    public static String[] getFileTypesAsArray(String resKey) {
        for (AllowFileTypes re : AllowFileTypes.values()) {
            if (resKey.equalsIgnoreCase(re.name())) {
                return re.getFileTypes();
            }
        }
        return new String[] {};
    }

    /**
     * 校验上传文件格式是否在允许范围内
     *
     * @param type 允许格式范围
     * @param fileType 指定文件的格式
     * @return true--指定文件的格式在格式集合中 false--反之不在
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Boolean checkFileType(AllowFileTypes type, String fileType) {
        return AllowFileTypes.getFileTypes(type.name()).contains(fileType.toUpperCase());
    }
}
