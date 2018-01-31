package com.lszpro.soa.service;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */

 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lszpro.soa.model.bo.ProductTypeBO;

public interface ProductTypeService {
    List<ProductTypeBO> selectList(Map map);
    ProductTypeBO selectById(String id);
    ProductTypeBO insert(ProductTypeBO productTypeBO);
    ProductTypeBO updateById(ProductTypeBO productTypeBO, String id);
    boolean deleteById(String id);
  
}