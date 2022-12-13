package com.dx.cms.service.action;

import com.dx.cms.exception.FileException;

public interface FileAction<T, R> {

    R execute(T param) throws FileException;
}
