package com.lszpro.soa.mapper.db1;

import com.lszpro.soa.model.bo.OrderBO;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据
 */
 

public interface OrderDao {
    Integer insert(OrderBO order);
    Integer updateById(OrderBO order);
    Integer deleteById(String id);

    Integer deleteByDanhao(String danaho);
}