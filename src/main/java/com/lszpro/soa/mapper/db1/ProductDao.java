package com.lszpro.soa.mapper.db1;

import com.lszpro.soa.model.bo.ProductBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-13
 */

 

public interface ProductDao {
    Integer insert(ProductBO product);
    Integer updateById(ProductBO product);
    Integer deleteById(String id);
}