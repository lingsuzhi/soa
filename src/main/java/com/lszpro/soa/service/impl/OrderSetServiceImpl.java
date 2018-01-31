package com.lszpro.soa.service.impl;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据配置
 */

import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.mapper.db1.OrderSetDao;
import com.lszpro.soa.mapper.db2.OrderSetRoDao;
import com.lszpro.soa.service.OrderSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lszpro.soa.model.bo.OrderSetBO;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class OrderSetServiceImpl implements OrderSetService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderSetServiceImpl.class);
    @Autowired
    private OrderSetDao orderSetDao;
    @Autowired
    private OrderSetRoDao orderSetRoDao;

    @Override
    public OrderSetBO updateById(OrderSetBO orderSetBO, String id) {
        orderSetBO.setId(id);
        orderSetBO.setCreateTime(null);
        int result = orderSetDao.updateById(orderSetBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:修改失败 " + orderSetBO);
        }
        return orderSetBO;
    }

    @Override
    public boolean deleteById(String id) {
        Integer result = orderSetDao.deleteById(id);
        return (result == 1);
    }

    @Override
    public OrderSetBO insert(OrderSetBO orderSetBO) {
        Date date = new Date();
        orderSetBO.setId(Utils.uuid());
        orderSetBO.setCreateTime(date);
        int result = orderSetDao.insert(orderSetBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:新增失败 " + orderSetBO);
        }
        return orderSetBO;
    }


    @Override
    public OrderSetBO selectById(String id) {
        return orderSetRoDao.selectById(id);
    }

    @Override
    public List<OrderSetBO> selectList(Map map) {
        return orderSetRoDao.selectList(map);
    }

}