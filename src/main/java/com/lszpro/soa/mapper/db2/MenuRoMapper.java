package com.lszpro.soa.mapper.db2;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-09-04
 */


import com.lszpro.soa.other.MenuBO;

import java.util.List;
import java.util.Map;

public interface MenuRoMapper {
    List<MenuBO> selectList(Map map);
    MenuBO selectOne(String id);
}
