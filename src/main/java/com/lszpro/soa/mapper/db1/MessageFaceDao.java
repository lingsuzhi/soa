package com.lszpro.soa.mapper.db1;

import com.lszpro.soa.model.bo.MessageFaceBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-13
 */

 

public interface MessageFaceDao {
    Integer insert(MessageFaceBO messageFace);
    Integer updateById(MessageFaceBO messageFace);
    Integer deleteById(String id);
}