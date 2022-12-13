package com.dx.cmm.service.chain;

/**
 * 
 * 任务链
 *
 * @author tony
 */
public abstract class Chain<T> {

    protected Chain<T> next;

    public abstract void next(T condition) throws ChainExecption;

    public Chain<T> getNext() {
        return next;
    }

    public void setNext(Chain<T> next) {
        this.next = next;
    }

}
