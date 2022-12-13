package com.dx.wms.service.save;

public abstract class SaveHandler<T,U,R> {
    /**
     * 持有下一个处理请求的对象
     */
    protected SaveHandler<T,U,R> successor;

    /**
     * 处理保存申请
     */
    public abstract void handleSaveRequest(T condition,U dto,R result);

    /**
     * 取值方法
     */
    public SaveHandler<T,U,R> getSuccessor() {
        return successor;
    }

    /**
     * 设置下一个处理请求的对象
     */
    public void setSuccessor(SaveHandler<T,U,R> successor) {
        this.successor = successor;
    }
}
