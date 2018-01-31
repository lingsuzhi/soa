package com.lszpro.soa.service.impl;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-18
 * 网点
 */

import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.mapper.db1.CustomerDao;
import com.lszpro.soa.mapper.db2.CustomerRoDao;
import com.lszpro.soa.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lszpro.soa.model.bo.CustomerBO;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustomerRoDao customerRoDao;

    @Override
    public CustomerBO updateById(CustomerBO customerBO, String id) {
        customerBO.setId(id);
        customerBO.setCreateTime(null);
        int result = customerDao.updateById(customerBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:修改失败 " + customerBO);
        }
        return customerBO;
    }

    @Override
    public boolean deleteById(String id) {
        Integer result = customerDao.deleteById(id);
        return (result == 1);
    }

    @Override
    public CustomerBO insert(CustomerBO customerBO) {
        Date date = new Date();
        customerBO.setId(Utils.uuid());
        customerBO.setCreateTime(date);
        int result = customerDao.insert(customerBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:新增失败 " + customerBO);
        }
        return customerBO;
    }


    @Override
    public CustomerBO selectById(String id) {
        return customerRoDao.selectById(id);
    }

    @Override
    public List<CustomerBO> selectList(Map map) {
        return customerRoDao.selectList(map);
    }

}