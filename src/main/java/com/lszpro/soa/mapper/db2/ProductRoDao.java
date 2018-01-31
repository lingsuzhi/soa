package com.lszpro.soa.mapper.db2;

import com.lszpro.soa.model.bo.ProductBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-13
 */


 
import java.util.List;
import java.util.Map;

import com.lszpro.soa.model.bo.ProductBO;

public interface ProductRoDao {
    List<ProductBO> selectList(Map map);
    ProductBO selectById(String id);
     
}