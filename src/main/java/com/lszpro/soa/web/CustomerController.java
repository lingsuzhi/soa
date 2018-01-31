package com.lszpro.soa.web;
 
import com.github.pagehelper.Page;
import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.model.rq.CustomerRq;

import com.lszpro.soa.service.CustomerService;
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
import com.lszpro.soa.model.bo.CustomerBO;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * 时间: 2018-1-18
 * 网点
 */

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    protected static Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customerList.php")
    @ResponseBody
    public ResponseEntity customerList(CustomerRq rq, HttpServletRequest request, Model model, HttpSession session) {
        PageHelper.startPage(rq.getPage(), rq.getLimit(), true).pageSizeZero(true).reasonable(true);
        Map map = LszUtil.beanToMapEmpty(rq);
        log.info("rq:" + map.toString());
        List<CustomerBO> list = customerService.selectList(map);
        return (list == null) ? ResponseEntity.ok(Utils.kv()) :
                ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
    }

    @RequestMapping(value = "/customerSave.php", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity memberActivitySave(@RequestBody CustomerBO customerBO, HttpServletRequest request) {
        String id = customerBO.getId();
        CustomerBO returnObj = null;
        if (id == null || id.isEmpty()) {            // 新增
            returnObj = customerService.insert(customerBO);
        } else {
            returnObj = customerService.updateById(customerBO, id);
        }
     
        return ResponseEntity.ok(Utils.kv("data",  returnObj ));
    }

    @RequestMapping("/customerById.php")
    @ResponseBody
    public ResponseEntity customerselectone(@RequestParam(required = true) String id, HttpServletRequest request) {
        CustomerBO returnObj = null;
        returnObj = customerService.selectById(id);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/customerDel.php")
    @ResponseBody
    public ResponseEntity customerDel(@RequestParam(required = true) String id, HttpServletRequest request) {
        Boolean returnObj = null;
        returnObj = customerService.deleteById(id);
        return ResponseEntity.ok( Utils.kv());
    }
}