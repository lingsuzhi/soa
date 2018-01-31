package com.lszpro.soa.mapper.db2;

import com.lszpro.soa.model.bo.TopicDiseasesBO;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-15
 */


 
import java.util.List;
import java.util.Map;


public interface TopicDiseasesRoDao {
    List<TopicDiseasesBO> selectList(Map map);
    TopicDiseasesBO selectOne(String id);
     
}