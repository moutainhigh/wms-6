package com.dx.wms.web.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.dx.ccs.vo.MenuVo;
import com.dx.ccs.vo.UserVo;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.vo.MenuComparator;
import com.dx.wms.web.vo.MenuVO;

/**
 * 公共工具类
 * 
 * @author tony
 */
public class WebCommonUtil {

    /**
     * 用户常量
     */
    private static final String USER = "user";

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param menus
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static List<MenuVO> getAmMenus(List<MenuVo> menus) {
        Collections.sort(menus, new MenuComparator());
        // AM返回当前登录用户的菜单权限,构建新的菜单数据结构AppMenuVO列表
        List<MenuVO> menuVOList = new ArrayList<MenuVO>();
        for (MenuVo m : menus) {
            // 从父节点开始循环设置
            if (m.getParentId() == 0L) {
                MenuVO mvo = new MenuVO();
                mvo.setName(m.getName());
                mvo.setUrl(m.getUrl());
                // 判断是否有子节点
                if (checkIsHasChild(menus, m.getMenuId())) {
                    mvo.setHasChild(true);

                    mvo.setChildList(getChildMenu(menus, m.getMenuId()));
                } else {
                    mvo.setHasChild(false);
                }
                menuVOList.add(mvo);
            }
        }
        return menuVOList;
    }

    /**
     * 功能描述: 用户初始化菜单<br>
     * 
     * @param menuList 所有菜单ID
     * @param menuId 父级ID
     * @return String 返回渲染页面
     * @since V1.0
     */
    private static List<MenuVO> getChildMenu(List<MenuVo> menuList, long menuId) {
        List<MenuVO> menuVOList = new ArrayList<MenuVO>();
        for (MenuVo m : menuList) {
            if (m.getParentId() == menuId) {
                MenuVO mvo = new MenuVO();
                mvo.setName(m.getName());
                mvo.setUrl(m.getUrl());
                if (checkIsHasChild(menuList, m.getMenuId())) {
                    mvo.setHasChild(true);
                    mvo.setChildList(getChildMenu(menuList, m.getMenuId()));
                } else {
                    mvo.setHasChild(false);
                }
                menuVOList.add(mvo);
            }
        }
        Collections.sort(menuList, new MenuComparator());
        return menuVOList;
    }

    /**
     * 功能描述: 用户初始化菜单<br>
     * 
     * @param menuList 所有菜单ID
     * @param menuId 父级ID
     * @return String 返回渲染页面
     * @since V1.0
     */
    private static boolean checkIsHasChild(List<MenuVo> menuList, long menuId) {
        boolean bool = false;
        for (MenuVo m : menuList) {
            if (m.getParentId() == menuId) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    /**
     * 
     * 功能描述:当前用户 <br>
     * 〈功能详细描述〉
     *
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static UserVo getUser(HttpServletRequest request) {
        HttpSession session = (HttpSession) request.getSession();
        return (UserVo) session.getAttribute(USER);
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Long getUserId(HttpServletRequest request) {
        return getUser(request).getUserId();
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param dTable
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Pagination initPage(DataTableObj dTable) {
        Pagination page = new Pagination();
        if (dTable.getCurrentPage() > 0) {
            page.setCurrentPage(dTable.getCurrentPage());
        }
        page.setPagesize(dTable.getiDisplayLength());
        return page;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param model
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void putModel(Model model, Map<String, Object> param) {
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            model.addAttribute(entry.getKey(), entry.getValue());
        }
    }

    public static Map<String, Object> init() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result", true);
        result.put("msg", "操作成功");
        return result;
    }

}
