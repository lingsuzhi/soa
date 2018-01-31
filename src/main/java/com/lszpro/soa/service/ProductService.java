package com.lszpro.soa.service;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */

 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lszpro.soa.model.bo.ProductBO;

public interface ProductService {
    List<ProductBO> selectList(Map map);
    ProductBO selectById(String id);
    ProductBO insert(ProductBO productBO);
    ProductBO updateById(ProductBO productBO, String id);
    boolean deleteById(String id);
  
}