package com.lszpro.soa.service;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据
 */

 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lszpro.soa.model.bo.OrderBO;

public interface OrderService {
    List<OrderBO> selectList(Map map);
    OrderBO selectById(String id);

    OrderBO selectDayEnd(String orderSetId);
    OrderBO insert(OrderBO orderBO);
    OrderBO updateById(OrderBO orderBO, String id);
    boolean deleteById(String id);
    boolean deleteByDanhao(String danhao);
    OrderBO selectByDanhao(String danhao);
    OrderBO selectLeft( String id,String orderSetId);
    OrderBO selectRight( String id,String orderSetId);
}