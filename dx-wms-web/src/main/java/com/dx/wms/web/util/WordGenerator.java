package com.dx.wms.web.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Template;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 */
public class WordGenerator {

    private WordGenerator() {
        throw new AssertionError();
    }

    public static File createDoc(Map<?, ?> dataMap, Template template, String fileName) {

        File f = new File(fileName);

        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dataMap);
            w.write(html);
            w.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return f;
    }
}
