package com.lszpro.soa.service.impl;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */


import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.mapper.db1.CustomerTypeDao;
import com.lszpro.soa.mapper.db2.CustomerTypeRoDao;
import com.lszpro.soa.service.CustomerTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lszpro.soa.model.bo.CustomerTypeBO;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerTypeServiceImpl.class);
    @Autowired
    private CustomerTypeDao customerTypeDao;
    @Autowired
    private CustomerTypeRoDao customerTypeRoDao;

    @Override
    public CustomerTypeBO updateById(CustomerTypeBO customerTypeBO, String id) {
        customerTypeBO.setId(id);
        customerTypeBO.setCreateTime(null);
        int result = customerTypeDao.updateById(customerTypeBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:修改失败 " + customerTypeBO);
        }
        return customerTypeBO;
    }

    @Override
    public boolean deleteById(String id) {
        Integer result = customerTypeDao.deleteById(id);
        return (result == 1);
    }

    @Override
    public CustomerTypeBO insert(CustomerTypeBO customerTypeBO) {
        Date date = new Date();
        customerTypeBO.setId(Utils.uuid());
        customerTypeBO.setCreateTime(date);
        int result = customerTypeDao.insert(customerTypeBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:新增失败 " + customerTypeBO);
        }
        return customerTypeBO;
    }


    @Override
    public CustomerTypeBO selectById(String id) {
        return customerTypeRoDao.selectById(id);
    }

    @Override
    public List<CustomerTypeBO> selectList(Map map) {
        return customerTypeRoDao.selectList(map);
    }

}