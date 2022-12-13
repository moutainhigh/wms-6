package com.dx.wms.dto;

import java.io.Serializable;

public class EmployeeCodeRuleDto implements Serializable{

    /**
     */
    private static final long serialVersionUID = -7969975392385395992L;
    
    /**中文名字 */
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
