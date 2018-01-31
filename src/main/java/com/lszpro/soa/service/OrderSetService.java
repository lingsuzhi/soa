package com.lszpro.soa.service;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据配置
 */

 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lszpro.soa.model.bo.OrderSetBO;

public interface OrderSetService {
    List<OrderSetBO> selectList(Map map);
    OrderSetBO selectById(String id);
    OrderSetBO insert(OrderSetBO orderSetBO);
    OrderSetBO updateById(OrderSetBO orderSetBO, String id);
    boolean deleteById(String id);
  
}