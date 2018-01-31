package com.lszpro.soa.web;
 
import com.github.pagehelper.Page;
import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.model.rq.CustomerTypeRq;

import com.lszpro.soa.service.CustomerTypeService;
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
import com.lszpro.soa.model.bo.CustomerTypeBO;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 时间: 2017-12-13
 */

@Controller
@RequestMapping(value = "/customerType")
public class CustomerTypeController {

    protected static Logger log = LoggerFactory.getLogger(CustomerTypeController.class);
    @Autowired
    private CustomerTypeService customerTypeService;

    @RequestMapping("/customerTypeList.php")
    @ResponseBody
    public ResponseEntity customerTypeList(CustomerTypeRq rq, HttpServletRequest request, Model model, HttpSession session) {
        PageHelper.startPage(rq.getPage(), rq.getLimit(), true).pageSizeZero(true).reasonable(true);
        Map map = LszUtil.beanToMapEmpty(rq);
        log.info("rq:" + map.toString());
        List<CustomerTypeBO> list = customerTypeService.selectList(map);
        return (list == null) ? ResponseEntity.ok(Utils.kv()) :
                ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
    }

    @RequestMapping(value = "/customerTypeSave.php", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity memberActivitySave(@RequestBody CustomerTypeBO customerTypeBO, HttpServletRequest request) {
        String id = customerTypeBO.getId();
        CustomerTypeBO returnObj = null;
        if (id == null || id.isEmpty()) {            // 新增
            returnObj = customerTypeService.insert(customerTypeBO);
        } else {
            returnObj = customerTypeService.updateById(customerTypeBO, id);
        }
     
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/customerTypeById.php")
    @ResponseBody
    public ResponseEntity customerTypeselectone(@RequestParam(required = true) String id, HttpServletRequest request) {
        CustomerTypeBO returnObj = null;
        returnObj = customerTypeService.selectById(id);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/customerTypeDel.php")
    @ResponseBody
    public ResponseEntity customerTypeDel(@RequestParam(required = true) String id, HttpServletRequest request) {
        Boolean returnObj = null;
        returnObj = customerTypeService.deleteById(id);
        return ResponseEntity.ok( Utils.kv());
    }
}