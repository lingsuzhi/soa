package com.lszpro.soa.web;
 
import com.github.pagehelper.Page;
import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.model.rq.ProductRq;

import com.lszpro.soa.service.ProductService;
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
import com.lszpro.soa.model.bo.ProductBO;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 时间: 2017-12-13
 */

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    protected static Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @RequestMapping("/productList.php")
    @ResponseBody
    public ResponseEntity productList(ProductRq rq, HttpServletRequest request, Model model, HttpSession session) {
        PageHelper.startPage(rq.getPage(), rq.getLimit(), true).pageSizeZero(true).reasonable(true);
        Map map = LszUtil.beanToMapEmpty(rq);
        log.info("rq:" + map.toString());
        List<ProductBO> list = productService.selectList(map);
        return (list == null) ? ResponseEntity.ok(Utils.kv()) :
                ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
    }

    @RequestMapping(value = "/productSave.php", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity memberActivitySave(@RequestBody ProductBO productBO, HttpServletRequest request) {
        String id = productBO.getId();
        ProductBO returnObj = null;
        if (id == null || id.isEmpty()) {            // 新增
            returnObj = productService.insert(productBO);
        } else {
            returnObj = productService.updateById(productBO, id);
        }
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/productById.php")
    @ResponseBody
    public ResponseEntity productselectone(@RequestParam(required = true) String id, HttpServletRequest request) {
        ProductBO returnObj = null;
        returnObj = productService.selectById(id);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/productDel.php")
    @ResponseBody
    public ResponseEntity productDel(@RequestParam(required = true) String id, HttpServletRequest request) {
        Boolean returnObj = null;
        returnObj = productService.deleteById(id);
        return ResponseEntity.ok( Utils.kv());
    }
}