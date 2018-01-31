package com.lszpro.soa.service;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */

 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lszpro.soa.model.bo.CustomerTypeBO;

public interface CustomerTypeService {
    List<CustomerTypeBO> selectList(Map map);
    CustomerTypeBO selectById(String id);
    CustomerTypeBO insert(CustomerTypeBO customerTypeBO);
    CustomerTypeBO updateById(CustomerTypeBO customerTypeBO, String id);
    boolean deleteById(String id);
  
}