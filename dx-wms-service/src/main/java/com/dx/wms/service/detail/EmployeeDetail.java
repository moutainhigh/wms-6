package com.dx.wms.service.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.wrapper.Wrapper;

@Service
public class EmployeeDetail extends DetailRegister {

    @Autowired
    private Wrapper<BaseEntitys> employeeWrapper;

    @Override
    public Boolean supports(ParamDetail param) {
        return Assert.equals(param.getDetail(), DetailType.EMPLOYEE);
    }

    @Override
    public void wrapper(ParamDetail param, ResultDetail result) {
        super.wrapper(param, result);
        employeeWrapper.put(param.getId(), result);
        // result.setFolders(new ArrayList<FolderResultDto>());
    }

}
