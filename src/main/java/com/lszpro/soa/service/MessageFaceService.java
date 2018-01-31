package com.lszpro.soa.service;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */

 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lszpro.soa.model.bo.MessageFaceBO;

public interface MessageFaceService {
    List<MessageFaceBO> selectList(Map map);
    MessageFaceBO selectById(String id);
    MessageFaceBO insert(MessageFaceBO messageFaceBO);
    MessageFaceBO updateById(MessageFaceBO messageFaceBO, String id);
    boolean deleteById(String id);
  
}