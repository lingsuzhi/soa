package com.lszpro.soa.service.impl;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-09-04
 */


import com.lszpro.soa.mapper.db1.MenuMapper;
import com.lszpro.soa.mapper.db2.MenuRoMapper;
import com.lszpro.soa.other.Menu;
import com.lszpro.soa.other.MenuBO;
import com.lszpro.soa.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuRoMapper menuRoMapper;

    @Override
    public MenuBO update(MenuBO menuBO, String id) {
        Menu obj = new Menu();
        BeanUtils.copyProperties(menuBO, obj);
        obj.setId(id);
        obj.setCreateTime(null);
        int result = menuMapper.update(obj);
        if (result != 1) {
            LOGGER.warn("修改失败，参数：" + obj);
            throw new RuntimeException("seviceErr:修改失败");
        }
        MenuBO returnObj = new MenuBO();
        BeanUtils.copyProperties(obj, returnObj);
        return returnObj;
    }

    @Override
    public boolean delete(String id) {
        Integer result = menuMapper.delete(id);
        return (result == 1);
    }

    @Override
    public MenuBO insert(MenuBO menuBO) {
        Menu obj = new Menu();
        BeanUtils.copyProperties(menuBO, obj);
        Date date = new Date();
        obj.setId(java.util.UUID.randomUUID().toString());
        obj.setCreateTime(date);
        int result = menuMapper.insert(obj);
        if (result != 1) {
            LOGGER.warn("新增失败，参数：" + obj);
            throw new RuntimeException("seviceErr:新增失败");
        }
        MenuBO returnObj = new MenuBO();
        BeanUtils.copyProperties(obj, returnObj);
        return returnObj;
    }

    @Override
    public MenuBO selectOne(String id) {
        return menuRoMapper.selectOne(id);
    }

    @Override
    public List<MenuBO> selectList(Map map) {
        return menuRoMapper.selectList(map);
    }
}
