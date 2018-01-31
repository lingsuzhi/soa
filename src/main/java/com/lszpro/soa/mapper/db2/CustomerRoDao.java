package com.lszpro.soa.mapper.db2;

import com.lszpro.soa.model.bo.CustomerBO;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-18
 * 网点
 */

 
import java.util.List;
import java.util.Map;

import com.lszpro.soa.model.bo.CustomerBO;

public interface CustomerRoDao {
    List<CustomerBO> selectList(Map map);
    CustomerBO selectById(String id);
     
}