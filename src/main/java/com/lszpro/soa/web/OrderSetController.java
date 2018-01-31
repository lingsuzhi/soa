package com.lszpro.soa.web;
 
import com.github.pagehelper.Page;
import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.model.rq.OrderSetRq;

import com.lszpro.soa.service.OrderSetService;
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
import com.lszpro.soa.model.bo.OrderSetBO;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据配置
 */

@Controller
@RequestMapping(value = "/orderSet")
public class OrderSetController {

    protected static Logger log = LoggerFactory.getLogger(OrderSetController.class);
    @Autowired
    private OrderSetService orderSetService;

    @RequestMapping("/orderSetList.php")
    @ResponseBody
    public ResponseEntity orderSetList(OrderSetRq rq, HttpServletRequest request, Model model, HttpSession session) {
        PageHelper.startPage(rq.getPage(), rq.getLimit(), true).pageSizeZero(true).reasonable(true);
        Map map = LszUtil.beanToMapEmpty(rq);
        log.info("rq:" + map.toString());
        List<OrderSetBO> list = orderSetService.selectList(map);
        return (list == null) ? ResponseEntity.ok(Utils.kv()) :
                ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
    }

    @RequestMapping(value = "/orderSetSave.php", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity memberActivitySave(@RequestBody OrderSetBO orderSetBO, HttpServletRequest request) {
        String id = orderSetBO.getId();
        OrderSetBO returnObj = null;
        if (id == null || id.isEmpty()) {            // 新增
            returnObj = orderSetService.insert(orderSetBO);
        } else {
            returnObj = orderSetService.updateById(orderSetBO, id);
        }
     
        return ResponseEntity.ok(Utils.kv("data",  returnObj ));
    }

    @RequestMapping("/orderSetById.php")
    @ResponseBody
    public ResponseEntity orderSetselectone(@RequestParam(required = true) String id, HttpServletRequest request) {
        OrderSetBO returnObj = null;
        returnObj = orderSetService.selectById(id);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/orderSetDel.php")
    @ResponseBody
    public ResponseEntity orderSetDel(@RequestParam(required = true) String id, HttpServletRequest request) {
        Boolean returnObj = null;
        returnObj = orderSetService.deleteById(id);
        return ResponseEntity.ok( Utils.kv());
    }
}