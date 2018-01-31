package com.lszpro.soa.mapper.db2;

import com.lszpro.soa.model.bo.ProductTypeBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-13
 */


 
import java.util.List;
import java.util.Map;

import com.lszpro.soa.model.bo.ProductTypeBO;

public interface ProductTypeRoDao {
    List<ProductTypeBO> selectList(Map map);
    ProductTypeBO selectById(String id);
     
}