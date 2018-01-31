package com.lszpro.soa.mapper.db1;

import com.lszpro.soa.model.bo.CustomerBO;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-18
 * 网点
 */
 

public interface CustomerDao {
    Integer insert(CustomerBO customer);
    Integer updateById(CustomerBO customer);
    Integer deleteById(String id);
}