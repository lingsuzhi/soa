package com.lszpro.soa.service;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-18
 * 网点
 */

 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lszpro.soa.model.bo.CustomerBO;

public interface CustomerService {
    List<CustomerBO> selectList(Map map);
    CustomerBO selectById(String id);
    CustomerBO insert(CustomerBO customerBO);
    CustomerBO updateById(CustomerBO customerBO, String id);
    boolean deleteById(String id);
  
}