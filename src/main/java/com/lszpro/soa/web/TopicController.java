package com.lszpro.soa.web;

import com.github.pagehelper.Page;
import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.model.rq.TopicRq;

import com.lszpro.soa.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lszpro.soa.model.bo.TopicBO;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 时间: 2017-12-13
 */

@Controller
@RequestMapping(value = "/topic")
public class TopicController {

    protected static Logger log = LoggerFactory.getLogger(TopicController.class);
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topicList.php")
    @ResponseBody
    public ResponseEntity topicList(TopicRq rq, HttpServletRequest request, Model model, HttpSession session) {
        PageHelper.startPage(rq.getPage(), rq.getLimit(), true).pageSizeZero(true).reasonable(true);
        Map map = LszUtil.beanToMapEmpty(rq);
        log.info("rq:" + map.toString());
        List<TopicBO> list = topicService.selectList(map);
        return (list == null) ? ResponseEntity.ok(Utils.kv()) :
                ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
    }

    @RequestMapping(value = "/topicSave.php", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity memberActivitySave(@RequestBody TopicBO topicBO, HttpServletRequest request) {
        String id = topicBO.getId();
        TopicBO returnObj = null;
        if (id == null || id.isEmpty()) {            // 新增
            returnObj = topicService.insert(topicBO);
        } else {
            returnObj = topicService.updateById(topicBO, id);
        }
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/topicById.php")
    @ResponseBody
    public ResponseEntity topicselectone(@RequestParam(required = true) String id, HttpServletRequest request) {
        TopicBO returnObj = null;
        returnObj = topicService.selectById(id);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/topicDel.php")
    @ResponseBody
    public ResponseEntity topicDel(@RequestParam(required = true) String id, HttpServletRequest request) {
        Boolean returnObj = null;
        returnObj = topicService.deleteById(id);
        return ResponseEntity.ok( Utils.kv());
    }
}