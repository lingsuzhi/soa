package com.lszpro.soa.mapper.db1;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-09-04
 */


import com.lszpro.soa.other.Menu;

public interface MenuMapper {
    Integer insert(Menu menu);
    Integer update(Menu menu);
    Integer delete(String id);
}
