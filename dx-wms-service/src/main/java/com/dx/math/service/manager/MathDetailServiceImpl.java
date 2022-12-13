package com.dx.math.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.math.service.dao.IMathSignTypeDao;
import com.dx.math.service.entity.MathSignType;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class MathDetailServiceImpl implements IMathDetailService {

    @Autowired
    private IMathSignTypeDao mathSignTypeDao;

    @Override
    public MathSignType getTypeBySign(String signKey) {
        return mathSignTypeDao.getBySignKey(signKey);
    }

}
