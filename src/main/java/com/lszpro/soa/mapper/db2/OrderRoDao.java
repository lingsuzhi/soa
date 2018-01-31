package com.lszpro.soa.mapper.db2;

import com.lszpro.soa.model.bo.OrderBO;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据
 */

 
import java.util.List;
import java.util.Map;

import com.lszpro.soa.model.bo.OrderBO;

public interface OrderRoDao {
    List<OrderBO> selectList(Map map);
    OrderBO selectById(String id);
    OrderBO selectByDanhao(String danhao);
    OrderBO selectDayEnd(String orderSetId);
    Integer maxDayNumber(Map map);
    List<String> selectAllId(String orderSetId);
}