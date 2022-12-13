package com.dx.cms.service.query;

import java.util.List;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;

public interface FileQueryGateway {

    void regist(FileQuery query);

    List<FileResultDto> query(Condition param);
}
