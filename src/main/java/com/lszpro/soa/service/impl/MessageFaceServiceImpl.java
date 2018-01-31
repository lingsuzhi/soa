package com.lszpro.soa.service.impl;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-12-13
 */


import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.mapper.db1.MessageFaceDao;
import com.lszpro.soa.mapper.db2.MessageFaceRoDao;
import com.lszpro.soa.service.MessageFaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lszpro.soa.model.bo.MessageFaceBO;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class MessageFaceServiceImpl implements MessageFaceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageFaceServiceImpl.class);
    @Autowired
    private MessageFaceDao messageFaceDao;
    @Autowired
    private MessageFaceRoDao messageFaceRoDao;

    @Override
    public MessageFaceBO updateById(MessageFaceBO messageFaceBO, String id) {
        messageFaceBO.setId(id);
        messageFaceBO.setCreateTime(null);
        int result = messageFaceDao.updateById(messageFaceBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:修改失败 " + messageFaceBO);
        }
        return messageFaceBO;
    }

    @Override
    public boolean deleteById(String id) {
        Integer result = messageFaceDao.deleteById(id);
        return (result == 1);
    }

    @Override
    public MessageFaceBO insert(MessageFaceBO messageFaceBO) {
        Date date = new Date();
        messageFaceBO.setId(Utils.uuid());
        messageFaceBO.setCreateTime(date);
        int result = messageFaceDao.insert(messageFaceBO);
        if (result != 1) {
            throw new ServiceException("9999", "seviceErr:新增失败 " + messageFaceBO);
        }
        return messageFaceBO;
    }


    @Override
    public MessageFaceBO selectById(String id) {
        return messageFaceRoDao.selectById(id);
    }

    @Override
    public List<MessageFaceBO> selectList(Map map) {
        return messageFaceRoDao.selectList(map);
    }

}