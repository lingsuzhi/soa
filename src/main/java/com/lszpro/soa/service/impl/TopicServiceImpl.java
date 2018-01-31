package com.lszpro.soa.service.impl;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */


import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.mapper.db1.TopicDao;
import com.lszpro.soa.mapper.db2.TopicRoDao;
import com.lszpro.soa.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lszpro.soa.model.bo.TopicBO;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class TopicServiceImpl implements TopicService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicServiceImpl.class);
    @Autowired
    private TopicDao topicDao;
    @Autowired
    private TopicRoDao topicRoDao;

    @Override
    public TopicBO updateById(TopicBO topicBO, String id) {
        topicBO.setId(id);
        topicBO.setCreateTime(null);
        int result = topicDao.updateById(topicBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:修改失败 " + topicBO);
        }
        return topicBO;
    }

    @Override
    public boolean deleteById(String id) {
        Integer result = topicDao.deleteById(id);
        return (result == 1);
    }

    @Override
    public TopicBO insert(TopicBO topicBO) {
        Date date = new Date();
        topicBO.setId(Utils.uuid());
        topicBO.setCreateTime(date);
        int result = topicDao.insert(topicBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:新增失败 " + topicBO);
        }
        return topicBO;
    }


    @Override
    public TopicBO selectById(String id) {
        return topicRoDao.selectById(id);
    }

    @Override
    public List<TopicBO> selectList(Map map) {
        return topicRoDao.selectList(map);
    }

}