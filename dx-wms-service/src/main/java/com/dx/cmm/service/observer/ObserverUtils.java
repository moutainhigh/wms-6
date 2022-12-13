package com.dx.cmm.service.observer;

public final class ObserverUtils {
    private static final String BASE = "no find biz";

    public static ObserverException error() {
        return new ObserverException(BASE);
    }

    public static ObserverException error(String msg) {
        return new ObserverException(msg);
    }

}
