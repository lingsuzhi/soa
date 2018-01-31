package com.lszpro.soa.service;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */

 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lszpro.soa.model.bo.ProductCompanyBO;

public interface ProductCompanyService {
    List<ProductCompanyBO> selectList(Map map);
    ProductCompanyBO selectById(String id);
    ProductCompanyBO insert(ProductCompanyBO productCompanyBO);
    ProductCompanyBO updateById(ProductCompanyBO productCompanyBO, String id);
    boolean deleteById(String id);
  
}