package com.lszpro.soa.mapper.db2;

import com.lszpro.soa.model.bo.OrderSetBO;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据配置
 */

 
import java.util.List;
import java.util.Map;

import com.lszpro.soa.model.bo.OrderSetBO;

public interface OrderSetRoDao {
    List<OrderSetBO> selectList(Map map);
    OrderSetBO selectById(String id);
     
}