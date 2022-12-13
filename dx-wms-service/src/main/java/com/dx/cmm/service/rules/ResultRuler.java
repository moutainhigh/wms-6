package com.dx.cmm.service.rules;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ResultRuler implements Serializable {

    /**
     */
    private static final long serialVersionUID = 178128796564194858L;

    /**
     * 
     */
    private Long level;

    /**
     * 
     */
    private Map<String, Object> results;

    public ResultRuler() {

    }

    public ResultRuler(Map<String, Object> results) {
        setResults(results);
    }
    
    public ResultRuler( Long level,Map<String, Object> results) {
        setLevel(level);
        setResults(results);
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Map<String, Object> getResults() {
        return results;
    }

    public void setResults(Map<String, Object> results) {
        this.results = results;
    }

}
