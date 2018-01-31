package com.lszpro.soa.web;
 
import com.github.pagehelper.Page;
import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.model.rq.ProductTypeRq;

import com.lszpro.soa.service.ProductTypeService;
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
import com.lszpro.soa.model.bo.ProductTypeBO;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 时间: 2017-12-13
 */

@Controller
@RequestMapping(value = "/productType")
public class ProductTypeController {

    protected static Logger log = LoggerFactory.getLogger(ProductTypeController.class);
    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("/productTypeList.php")
    @ResponseBody
    public ResponseEntity productTypeList(ProductTypeRq rq, HttpServletRequest request, Model model, HttpSession session) {
        PageHelper.startPage(rq.getPage(), rq.getLimit(), true).pageSizeZero(true).reasonable(true);
        Map map = LszUtil.beanToMapEmpty(rq);
        log.info("rq:" + map.toString());
        List<ProductTypeBO> list = productTypeService.selectList(map);
        return (list == null) ? ResponseEntity.ok(Utils.kv()) :
                ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
    }

    @RequestMapping(value = "/productTypeSave.php", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity memberActivitySave(@RequestBody ProductTypeBO productTypeBO, HttpServletRequest request) {
        String id = productTypeBO.getId();
        ProductTypeBO returnObj = null;
        if (id == null || id.isEmpty()) {            // 新增
            returnObj = productTypeService.insert(productTypeBO);
        } else {
            returnObj = productTypeService.updateById(productTypeBO, id);
        }
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/productTypeById.php")
    @ResponseBody
    public ResponseEntity productTypeselectone(@RequestParam(required = true) String id, HttpServletRequest request) {
        ProductTypeBO returnObj = null;
        returnObj = productTypeService.selectById(id);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/productTypeDel.php")
    @ResponseBody
    public ResponseEntity productTypeDel(@RequestParam(required = true) String id, HttpServletRequest request) {
        Boolean returnObj = null;
        returnObj = productTypeService.deleteById(id);
        return ResponseEntity.ok( Utils.kv());
    }
}