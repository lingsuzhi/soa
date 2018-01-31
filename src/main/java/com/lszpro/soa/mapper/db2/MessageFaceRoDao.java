package com.lszpro.soa.mapper.db2;

import com.lszpro.soa.model.bo.MessageFaceBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-13
 */


 
import java.util.List;
import java.util.Map;

import com.lszpro.soa.model.bo.MessageFaceBO;

public interface MessageFaceRoDao {
    List<MessageFaceBO> selectList(Map map);
    MessageFaceBO selectById(String id);
     
}