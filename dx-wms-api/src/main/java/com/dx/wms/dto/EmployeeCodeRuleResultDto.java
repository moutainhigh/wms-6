package com.dx.wms.dto;

import java.io.Serializable;

public class EmployeeCodeRuleResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -8277701287748217072L;

    /** 名字拼音 */
    private String pinYinName;

    /** 员工编号 */
    private String employeeNo;

    /**
     * @return the pinYinName
     */
    public String getPinYinName() {
        return pinYinName;
    }

    /**
     * @param pinYinName the pinYinName to set
     */
    public void setPinYinName(String pinYinName) {
        this.pinYinName = pinYinName;
    }

    /**
     * @return the employeeNo
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * @param employeeNo the employeeNo to set
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

}
