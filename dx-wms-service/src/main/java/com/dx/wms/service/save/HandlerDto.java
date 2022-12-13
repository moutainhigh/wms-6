package com.dx.wms.service.save;

public class HandlerDto {
    
    /**
     * 操作人
     */
    private Long userId;
    
    /**
     * Id
     */
    private Long id;

    public HandlerDto(){
        
    }
    
    public HandlerDto(Long userId){
        setUserId(userId);
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
