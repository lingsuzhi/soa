package com.lszpro.soa.mapper.db1;

import com.lszpro.soa.model.bo.ProductTypeBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-13
 */

 

public interface ProductTypeDao {
    Integer insert(ProductTypeBO productType);
    Integer updateById(ProductTypeBO productType);
    Integer deleteById(String id);
}