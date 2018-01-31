package com.lszpro.soa.mapper.db1;

import com.lszpro.soa.model.bo.CustomerTypeBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-13
 */

 

public interface CustomerTypeDao {
    Integer insert(CustomerTypeBO customerType);
    Integer updateById(CustomerTypeBO customerType);
    Integer deleteById(String id);
}