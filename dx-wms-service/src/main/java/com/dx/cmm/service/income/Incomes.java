package com.dx.cmm.service.income;

public interface Incomes<T> {

    void inject(T fund) throws InjectException;
}
