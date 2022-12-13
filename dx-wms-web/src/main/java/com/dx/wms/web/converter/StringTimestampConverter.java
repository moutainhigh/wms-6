package com.dx.wms.web.converter;

import java.sql.Timestamp;
import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 柳励
 */
public class StringTimestampConverter extends DateConverterBase implements Converter<String, Timestamp> {
    @Override
    public Timestamp convert(String source) {

        if (StringUtils.isBlank(source)) {
            return null;
        }

        String trim = source.trim();
        if (trim.length() == 0) {
            return null;
        }
        try {
            return source.contains(":") ? (Timestamp) getDateTimeFormat().parse(trim) : (Timestamp) getDateFormat()
                    .parse(trim);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
