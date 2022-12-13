package com.dx.wms.web.converter;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
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
public class StringDateConverter extends DateConverterBase implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }

        String trim = source.trim();
        if (trim.length() == 0) {
            return null;
        }

        try {
            return source.contains(":") ? getDateTimeFormat().parse(trim) : getDateFormat().parse(trim);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
