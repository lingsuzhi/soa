package com.lszpro.soa.mapper.db1;

import com.lszpro.soa.model.bo.OrderSetBO;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据配置
 */
 

public interface OrderSetDao {
    Integer insert(OrderSetBO orderSet);
    Integer updateById(OrderSetBO orderSet);
    Integer deleteById(String id);
}