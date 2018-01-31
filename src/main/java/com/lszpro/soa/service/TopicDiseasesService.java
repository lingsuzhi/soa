package com.lszpro.soa.service;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-15
 */

 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lszpro.soa.model.bo.TopicDiseasesBO;

public interface TopicDiseasesService {
 
    List<TopicDiseasesBO> selectList(Map map);
    TopicDiseasesBO selectOne(String id);
    TopicDiseasesBO insert(TopicDiseasesBO topicDiseasesBO);
    TopicDiseasesBO update(TopicDiseasesBO topicDiseasesBO, String id);
    boolean delete(String id);
  
}