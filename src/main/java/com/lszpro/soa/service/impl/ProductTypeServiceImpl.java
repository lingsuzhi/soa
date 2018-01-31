package com.lszpro.soa.service.impl;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */


import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.mapper.db1.ProductTypeDao;
import com.lszpro.soa.mapper.db2.ProductTypeRoDao;
import com.lszpro.soa.service.ProductTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lszpro.soa.model.bo.ProductTypeBO;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTypeServiceImpl.class);
    @Autowired
    private ProductTypeDao productTypeDao;
    @Autowired
    private ProductTypeRoDao productTypeRoDao;

    @Override
    public ProductTypeBO updateById(ProductTypeBO productTypeBO, String id) {
        productTypeBO.setId(id);
        productTypeBO.setCreateTime(null);
        int result = productTypeDao.updateById(productTypeBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:修改失败 " + productTypeBO);
        }
        return productTypeBO;
    }

    @Override
    public boolean deleteById(String id) {
        Integer result = productTypeDao.deleteById(id);
        return (result == 1);
    }

    @Override
    public ProductTypeBO insert(ProductTypeBO productTypeBO) {
        Date date = new Date();
        productTypeBO.setId(Utils.uuid());
        productTypeBO.setCreateTime(date);
        int result = productTypeDao.insert(productTypeBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:新增失败 " + productTypeBO);
        }
        return productTypeBO;
    }


    @Override
    public ProductTypeBO selectById(String id) {
        return productTypeRoDao.selectById(id);
    }

    @Override
    public List<ProductTypeBO> selectList(Map map) {
        return productTypeRoDao.selectList(map);
    }

}