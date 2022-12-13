package com.dx.wms.service.index;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.dx.ccs.vo.RoleVo;
import com.dx.wms.constant.RoleConstant;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 */
@Service
public class IndexExecutiveService extends IndexService {

    @Override
    public Boolean isSupport(IndexQueryDto q) {
        for (RoleVo role : q.getRoleList()) {
            if (StringUtils.isNotBlank(role.getCode())) {
                if (role.getCode().equals(RoleConstant.ZWH)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public String initPage(IndexQueryDto q) {
        return "indexPage/index_page_ZWH";
    }

    @Override
    public IndexResultDto initDate(IndexQueryDto q) {
        IndexResultDto resultDto = new IndexResultDto();
//        // 客户经理
//        resultDto.setCreateUser(q.getUser().getUserId());
//        // 营业部
//        resultDto.setOrgId(q.getOrgVo().getOrgId());
//        // 当前投资申请总数
//        List<IndexDisplayResultDto> list = indexDisplayDao.queryForApplyNumberByOrgId(q.getOrgVo().getOrgId());
//        if (!CollectionUtils.isEmpty(list)) {
//            resultDto.setApplyNumber((null == list.get(0)) ? 0 : list.get(0).getApplyNumber());
//        }
//        // 被拒绝申请单数
//        list = indexDisplayDao.queryForRefusedApplyNumberByCreateUserOrOrgId(q.getUser().getUserId(), q.getOrgVo()
//                .getOrgId());
//        if (!CollectionUtils.isEmpty(list)) {
//            resultDto.setRefusedApplyNumber((null == list.get(0)) ? 0 : list.get(0).getRefusedApplyNumber());
//        }
//        // 待投资审核申请单数
//        list = indexDisplayDao.queryForPendingQuality(WMSConstants.QUALITY_CHECK, q.getOrgVo().getOrgId());
//        if (!CollectionUtils.isEmpty(list)) {
//            resultDto.setPendingQualityApplyNumber((null == list.get(0)) ? 0 : list.get(0)
//                    .getPendingQualityApplyNumber());
//        }
//        // 审核结果比例
//        list = indexDisplayDao.queryForCheckResult();
//        if (null == list) {
//            resultDto.setCheckResultProportion(new ArrayList<IndexDisplayResultDto>());
//        } else {
//            resultDto.setCheckResultProportion(list);
//        }
//        // 已申请投资总额
//        list = indexDisplayDao.queryForCustNumberByNothing();
//        if (!CollectionUtils.isEmpty(list)) {
//            resultDto.setSumLenderAmount((null == list.get(0)) ? BigDecimal.ZERO : list.get(0).getSumLenderAmount());
//        }
//        // 出借方式投资比例
//        list = indexDisplayDao.queryForConductFinancialTransactionsProportion(q.getUser().getUserId(), q.getOrgVo()
//                .getOrgId());
//        if (null == list) {
//            resultDto.setLenderProportion(new ArrayList<IndexDisplayResultDto>());
//        } else {
//            resultDto.setLenderProportion(list);
//        }
        return resultDto;
    }

}
