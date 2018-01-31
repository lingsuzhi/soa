package com.lszpro.soa.service;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */

 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lszpro.soa.model.bo.TopicBO;

public interface TopicService {
    List<TopicBO> selectList(Map map);
    TopicBO selectById(String id);
    TopicBO insert(TopicBO topicBO);
    TopicBO updateById(TopicBO topicBO, String id);
    boolean deleteById(String id);
  
}