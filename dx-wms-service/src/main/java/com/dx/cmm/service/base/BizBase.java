package com.dx.cmm.service.base;

import java.util.List;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;

/**
 * 
 * 业务基础
 *
 * @author tony
 */
public interface BizBase<T> {

    /**
     * 功能描述: <br>
     * 根据业务编号筛选
     *
     * @param bizId
     * @return
     */
    MatchBizBase query(Long bizId);

    /**
     * 功能描述: <br>
     * 根据业务编码筛选
     *
     * @param bizCode
     * @return
     */
    MatchBizBase query(String bizCode);

    /**
     * 功能描述: <br>
     * 根据执行及状态筛选
     *
     * @param isExe
     * @param status
     * @return
     */
    List<MatchBizBase> queryArray(Boolean isExe, BizBaseStatus... status);

    /**
     * 
     * 功能描述: <br>
     * 根据端口及状态筛选
     *
     * @param port
     * @param isExe
     * @param status
     * @return
     */
    List<MatchBizBase> queryArray(Integer port, Boolean isExe, BizBaseStatus... status);

    /**
     * 
     * 功能描述: <br>
     * 保存
     *
     * @param base
     * @throws SaveException
     */
    void save(MatchBizBase base) throws SaveException;

    /**
     * 
     * 功能描述: <br>
     * 根据编号及状态保存
     *
     * @param id
     * @param status
     * @throws SaveException
     */
    void save(Long id, BizBaseStatus status) throws SaveException;
}
