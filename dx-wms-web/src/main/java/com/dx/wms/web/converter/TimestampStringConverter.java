package com.dx.wms.web.converter;

import java.sql.Timestamp;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 柳励
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TimestampStringConverter extends DateConverterBase implements Converter<Timestamp, String> {

    @Override
    public String convert(Timestamp source) {
        if (source == null) {
            return "";
        }
        return getDateFormat().format(source);
    }

}
