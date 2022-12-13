package com.dx.cms.service.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;

@Service
public class QueryRouter implements FileQueryGateway {

    private List<FileQuery> queries = new ArrayList<>();

    @Override
    public void regist(FileQuery query) {
        queries.add(query);
    }

    @Override
    public List<FileResultDto> query(Condition param) {
        for (FileQuery query : queries) {
            if (query.supports(param)) {
                return query.query(param);
            }
        }
        return new ArrayList<>();
    }

}
