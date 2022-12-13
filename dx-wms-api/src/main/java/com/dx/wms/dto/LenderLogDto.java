package com.dx.wms.dto;

import java.io.Serializable;

public class LenderLogDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -7653666324207875835L;

    private String nextStep;
    
    private Long toUser;
    
    private String nextStepName;
    
    private Integer nextStepAction;

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    public String getNextStepName() {
        return nextStepName;
    }

    public void setNextStepName(String nextStepName) {
        this.nextStepName = nextStepName;
    }

    public Integer getNextStepAction() {
        return nextStepAction;
    }

    public void setNextStepAction(Integer nextStepAction) {
        this.nextStepAction = nextStepAction;
    }
    
}
