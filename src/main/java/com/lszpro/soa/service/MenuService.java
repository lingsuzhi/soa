package com.lszpro.soa.service;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-09-04
 */


import com.lszpro.soa.other.MenuBO;

import java.util.List;
import java.util.Map;

public interface MenuService {
    List<MenuBO> selectList(Map map);
    MenuBO selectOne(String id);
    MenuBO insert(MenuBO menuBO);
    MenuBO update(MenuBO menuBO, String id);
    boolean delete(String id);

}
