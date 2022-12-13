package com.dx.wms.web.vo;

import java.util.Comparator;

import com.dx.ccs.vo.MenuVo;
/**
 * 
 * 菜单比较器
 *
 * @author tony
 */
public class MenuComparator implements Comparator<MenuVo> {

    @Override
    public int compare(MenuVo o1, MenuVo o2) {
        return o1.getDisplaySeq().compareTo(o2.getDisplaySeq());
    }
}
