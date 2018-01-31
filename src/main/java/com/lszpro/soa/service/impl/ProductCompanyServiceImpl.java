package com.lszpro.soa.service.impl;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */


import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.mapper.db1.ProductCompanyDao;
import com.lszpro.soa.mapper.db2.ProductCompanyRoDao;
import com.lszpro.soa.service.ProductCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lszpro.soa.model.bo.ProductCompanyBO;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class ProductCompanyServiceImpl implements ProductCompanyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCompanyServiceImpl.class);
    @Autowired
    private ProductCompanyDao productCompanyDao;
    @Autowired
    private ProductCompanyRoDao productCompanyRoDao;

    @Override
    public ProductCompanyBO updateById(ProductCompanyBO productCompanyBO, String id) {
        productCompanyBO.setId(id);
        productCompanyBO.setCreateTime(null);
        int result = productCompanyDao.updateById(productCompanyBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:修改失败 " + productCompanyBO);
        }
        return productCompanyBO;
    }

    @Override
    public boolean deleteById(String id) {
        Integer result = productCompanyDao.deleteById(id);
        return (result == 1);
    }

    @Override
    public ProductCompanyBO insert(ProductCompanyBO productCompanyBO) {
        Date date = new Date();
        productCompanyBO.setId(Utils.uuid());
        productCompanyBO.setCreateTime(date);
        int result = productCompanyDao.insert(productCompanyBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:新增失败 " + productCompanyBO);
        }
        return productCompanyBO;
    }


    @Override
    public ProductCompanyBO selectById(String id) {
        return productCompanyRoDao.selectById(id);
    }

    @Override
    public List<ProductCompanyBO> selectList(Map map) {
        return productCompanyRoDao.selectList(map);
    }

}