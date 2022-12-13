package com.dx.cms.service.query;

import java.util.List;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;

public interface FileQuery {

    List<FileResultDto> query(Condition param);
    
    Boolean supports(Condition param);
    
    void join();
}
