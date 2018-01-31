package com.lszpro.soa.mapper.db1;

import com.lszpro.soa.model.bo.TopicBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-13
 */

 

public interface TopicDao {
    Integer insert(TopicBO topic);
    Integer updateById(TopicBO topic);
    Integer deleteById(String id);
}