package com.lszpro.soa.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.model.OrderChildBO;
import com.lszpro.soa.model.rq.OrderRq;

import com.lszpro.soa.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lszpro.soa.model.bo.OrderBO;
import com.github.pagehelper.PageHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-19
 * 单据
 */

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    protected static Logger log = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderList.php")
    @ResponseBody
    public ResponseEntity orderList(OrderRq rq, HttpServletRequest request, Model model, HttpSession session) {
        PageHelper.startPage(rq.getPage(), rq.getLimit(), true).pageSizeZero(true).reasonable(true);
        Map map = LszUtil.beanToMapEmpty(rq);
        log.info("rq:" + map.toString());
        List<OrderBO> list = orderService.selectList(map);
        return (list == null) ? ResponseEntity.ok(Utils.kv()) :
                ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
    }

    @RequestMapping(value = "/orderSave.php", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity memberActivitySave(@RequestBody OrderBO orderBO, HttpServletRequest request) {
        String id = orderBO.getId();
        OrderBO returnObj = null;
        orderBO.setDaydate(LszUtil.dateDay(orderBO.getDaydate()));
//这里理论上 要对一下价格  ，不过 也不合适
        if (!StringUtils.isEmpty(orderBO.getDatas())) {
            List<OrderChildBO> returnList = new ArrayList<OrderChildBO>();



                JSONArray obj1 = (JSONArray)JSON.parse(orderBO.getDatas());
                returnList =obj1.toJavaList(OrderChildBO.class);

            double jeAll =  0;
            double slAll = 0;
            for (OrderChildBO obj:returnList                 ) {
                double dou = 0;
                double sldou = 0;
                try {
                    sldou=Double.parseDouble(obj.getShuliang());
                    dou = sldou * Double.parseDouble(obj.getProce());
                }catch (Exception e){

                }
                jeAll +=dou;
                slAll += sldou;
            }
            orderBO.setZje( jeAll);
            orderBO.setZsl(slAll);
        }

        if (id == null || id.isEmpty()) {            // 新增
            returnObj = orderService.insert(orderBO);
        } else {
            returnObj = orderService.updateById(orderBO, id);
        }

        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/orderById.php")
    @ResponseBody
    public ResponseEntity orderselectone(@RequestParam(required = true) String id, HttpServletRequest request) {
        OrderBO returnObj = null;
        returnObj = orderService.selectById(id);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/orderEnd.php")
    @ResponseBody
    public ResponseEntity orderEnd(@RequestParam(required = true) String orderSetId, HttpServletRequest request) {
        OrderBO returnObj = null;
        returnObj = orderService.selectDayEnd(orderSetId);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }


    @RequestMapping("/orderDel.php")
    @ResponseBody
    public ResponseEntity orderDel(@RequestParam(required = true) String id, HttpServletRequest request) {
        Boolean returnObj = null;
        returnObj = orderService.deleteById(id);
        return ResponseEntity.ok(Utils.kv());
    }

    @RequestMapping("/orderDeldanhaoByDanhao.php")
    @ResponseBody
    public ResponseEntity orderDeldanhao(@RequestParam(required = true) String danhao, HttpServletRequest request) {
        Boolean returnObj = null;
        returnObj = orderService.deleteByDanhao(danhao);
        return ResponseEntity.ok(Utils.kv());
    }

    @RequestMapping("/orderByDanhao.php")
    @ResponseBody
    public ResponseEntity orderselectDanhao(@RequestParam(required = true) String danhao, HttpServletRequest request) {
        OrderBO returnObj = null;
        returnObj = orderService.selectByDanhao(danhao);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    /**
     * 前单
     */
    @RequestMapping("/orderLeft.php")
    @ResponseBody
    public ResponseEntity orderLeft(@RequestParam(required = true) String id, @RequestParam(required = true) String orderSetId, HttpServletRequest request) {
        OrderBO returnObj = null;
        returnObj = orderService.selectLeft(id, orderSetId);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    /**
     * 后单
     */
    @RequestMapping("/orderRight.php")
    @ResponseBody
    public ResponseEntity orderselectone(@RequestParam(required = true) String id, @RequestParam(required = true) String orderSetId, HttpServletRequest request) {
        OrderBO returnObj = null;
        returnObj = orderService.selectRight(id, orderSetId);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }
}