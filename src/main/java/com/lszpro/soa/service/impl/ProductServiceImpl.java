package com.lszpro.soa.service.impl;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */


import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.mapper.db1.ProductDao;
import com.lszpro.soa.mapper.db2.ProductRoDao;
import com.lszpro.soa.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lszpro.soa.model.bo.ProductBO;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductRoDao productRoDao;

    @Override
    public ProductBO updateById(ProductBO productBO, String id) {
        productBO.setId(id);
        productBO.setCreateTime(null);
        int result = productDao.updateById(productBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:修改失败 " + productBO);
        }
        return productBO;
    }

    @Override
    public boolean deleteById(String id) {
        Integer result = productDao.deleteById(id);
        return (result == 1);
    }

    @Override
    public ProductBO insert(ProductBO productBO) {
        Date date = new Date();
        productBO.setId(Utils.uuid());
        productBO.setCreateTime(date);
        int result = productDao.insert(productBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:新增失败 " + productBO);
        }
        return productBO;
    }


    @Override
    public ProductBO selectById(String id) {
        return productRoDao.selectById(id);
    }

    @Override
    public List<ProductBO> selectList(Map map) {
        return productRoDao.selectList(map);
    }

}