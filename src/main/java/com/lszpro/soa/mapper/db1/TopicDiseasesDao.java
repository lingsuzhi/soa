package com.lszpro.soa.mapper.db1;

import com.lszpro.soa.model.bo.TopicDiseasesBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-15
 */

 

public interface TopicDiseasesDao {
    Integer insert(TopicDiseasesBO topicDiseases);
    Integer update(TopicDiseasesBO topicDiseases);
    Integer delete(String id);
}