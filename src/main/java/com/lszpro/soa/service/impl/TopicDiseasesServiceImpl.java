package com.lszpro.soa.service.impl;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-15
 */

 
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.mapper.db1.TopicDiseasesDao;
import com.lszpro.soa.mapper.db2.TopicDiseasesRoDao;
import com.lszpro.soa.service.TopicDiseasesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lszpro.soa.model.bo.TopicDiseasesBO;
 

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class TopicDiseasesServiceImpl implements TopicDiseasesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicDiseasesServiceImpl.class);
    @Autowired
    private TopicDiseasesDao topicDiseasesDao;
    @Autowired
    private TopicDiseasesRoDao topicDiseasesRoDao;

    @Override
    public TopicDiseasesBO update(TopicDiseasesBO topicDiseasesBO, String id) {
   	
    	topicDiseasesBO.setId(id);
    	topicDiseasesBO.setCreateTime(null);
        int result = topicDiseasesDao.update(topicDiseasesBO);
        if (result != 1) {
                 throw new ServiceException("0000", "seviceErr:修改失败 " +  topicDiseasesBO);

        }
        return topicDiseasesBO;
    }

    @Override
    public boolean delete(String id) {
        Integer result = topicDiseasesDao.delete(id);
        return (result == 1);
     }

    @Override
    public  TopicDiseasesBO insert(TopicDiseasesBO topicDiseasesBO) {


        Date date = new Date();
        topicDiseasesBO.setId(Utils.uuid());
        topicDiseasesBO.setCreateTime(date);
        int result = topicDiseasesDao.insert(topicDiseasesBO);
        if (result != 1) {
            throw new ServiceException("9999","seviceErr:新增失败 " + topicDiseasesBO);
        }
 
        return topicDiseasesBO;
    }

    
	@Override
    public TopicDiseasesBO selectOne(String id) {

		return topicDiseasesRoDao.selectOne(id);
    }

    @Override
    public List<TopicDiseasesBO> selectList(Map map) {
        return topicDiseasesRoDao.selectList(map);
    }
 

}