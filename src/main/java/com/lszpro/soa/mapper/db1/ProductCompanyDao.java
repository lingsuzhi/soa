package com.lszpro.soa.mapper.db1;

import com.lszpro.soa.model.bo.ProductCompanyBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-13
 */

 

public interface ProductCompanyDao {
    Integer insert(ProductCompanyBO productCompany);
    Integer updateById(ProductCompanyBO productCompany);
    Integer deleteById(String id);
}