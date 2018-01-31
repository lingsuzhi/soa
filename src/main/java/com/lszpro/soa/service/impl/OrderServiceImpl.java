package com.lszpro.soa.service.impl;


/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据
 */

import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.mapper.db1.OrderDao;
import com.lszpro.soa.mapper.db2.OrderRoDao;
import com.lszpro.soa.mapper.db2.OrderSetRoDao;
import com.lszpro.soa.model.bo.OrderSetBO;
import com.lszpro.soa.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lszpro.soa.model.bo.OrderBO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderRoDao orderRoDao;
    @Autowired
    private OrderSetRoDao orderSetRoDao;

    @Override
    public OrderBO updateById(OrderBO orderBO, String id) {
        orderBO.setId(id);
        orderBO.setCreateTime(null);
        int result = orderDao.updateById(orderBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:修改失败 " + orderBO);
        }
        return orderBO;
    }

    @Override
    public boolean deleteById(String id) {
        Integer result = orderDao.deleteById(id);
        return (result == 1);
    }

    @Override
    public boolean deleteByDanhao(String danhao) {
        Integer result = orderDao.deleteByDanhao(danhao);
        return (result > 1);
    }

    @Override
    public OrderBO selectByDanhao(String danhao) {

        return orderRoDao.selectByDanhao(danhao);
    }

    @Override
    public OrderBO selectLeft(String id, String orderSetId) {
        List<String> list = orderRoDao.selectAllId(orderSetId);
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i))) {


                if (i == list.size()-1) return null;
                return this.selectById(list.get(i + 1));
            }
        }
        return null;
    }

    @Override
    public OrderBO selectRight(String id, String orderSetId) {
        List<String> list = orderRoDao.selectAllId(orderSetId);
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i))) {
                if (i == 0) return null;
                return this.selectById(list.get(i - 1));
            }
        }
        return null;
    }

    @Override
    public OrderBO insert(OrderBO orderBO) {
        if (orderBO.getOrderSetId() == null || orderBO.getDaydate() == null) {
            throw new ServiceException("9999", "参数有错误 " + orderBO);
        }
        Date date = new Date();
        orderBO.setId(Utils.uuid());
        orderBO.setCreateTime(date);
        //首先是把天流水号 得出来

        Map map = new HashMap<String, Object>();
        map.put("daydate", orderBO.getDaydate());
        map.put("orderSetId", orderBO.getOrderSetId());
        Integer num = orderRoDao.maxDayNumber(map);
        if (num == null) {
            num = 1;
        } else {
            num++;
        }
        orderBO.setDayNumber(num);

        OrderSetBO orderSetBO = orderSetRoDao.selectById(orderBO.getOrderSetId());
        if (orderSetBO == null) {
            throw new ServiceException("9999", "单据配置错误 " + orderBO);
        }
        String danhao = orderSetBO.getLeftStr() + "-";
        String numStr = num.toString();

        danhao = danhao + LszUtil.yyyyMMdd(orderBO.getDaydate());
        danhao = danhao + "-" + "0000".substring(1, 5 - numStr.length()) + numStr;
        orderBO.setDanhao(danhao);


        int result = orderDao.insert(orderBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:新增失败 " + orderBO);
        }
        return orderBO;
    }


    @Override
    public OrderBO selectById(String id) {
        return orderRoDao.selectById(id);
    }

    @Override
    public OrderBO selectDayEnd(String orderSetId) {
        return orderRoDao.selectDayEnd(orderSetId);
    }

    @Override
    public List<OrderBO> selectList(Map map) {
        return orderRoDao.selectList(map);
    }

}