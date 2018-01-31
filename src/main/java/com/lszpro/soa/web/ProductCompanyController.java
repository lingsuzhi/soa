package com.lszpro.soa.web;
 
import com.github.pagehelper.Page;
import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.model.rq.ProductCompanyRq;

import com.lszpro.soa.service.ProductCompanyService;
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
import com.lszpro.soa.model.bo.ProductCompanyBO;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 时间: 2017-12-13
 */

@Controller
@RequestMapping(value = "/productCompany")
public class ProductCompanyController {

    protected static Logger log = LoggerFactory.getLogger(ProductCompanyController.class);
    @Autowired
    private ProductCompanyService productCompanyService;

    @RequestMapping("/productCompanyList.php")
    @ResponseBody
    public ResponseEntity productCompanyList(ProductCompanyRq rq, HttpServletRequest request, Model model, HttpSession session) {
        PageHelper.startPage(rq.getPage(), rq.getLimit(), true).pageSizeZero(true).reasonable(true);
        Map map = LszUtil.beanToMapEmpty(rq);
        log.info("rq:" + map.toString());
        List<ProductCompanyBO> list = productCompanyService.selectList(map);
        return (list == null) ? ResponseEntity.ok(Utils.kv()) :
                ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
    }

    @RequestMapping(value = "/productCompanySave.php", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity memberActivitySave(@RequestBody ProductCompanyBO productCompanyBO, HttpServletRequest request) {
        String id = productCompanyBO.getId();
        ProductCompanyBO returnObj = null;
        if (id == null || id.isEmpty()) {            // 新增
            returnObj = productCompanyService.insert(productCompanyBO);
        } else {
            returnObj = productCompanyService.updateById(productCompanyBO, id);
        }
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/productCompanyById.php")
    @ResponseBody
    public ResponseEntity productCompanyselectone(@RequestParam(required = true) String id, HttpServletRequest request) {
        ProductCompanyBO returnObj = null;
        returnObj = productCompanyService.selectById(id);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/productCompanyDel.php")
    @ResponseBody
    public ResponseEntity productCompanyDel(@RequestParam(required = true) String id, HttpServletRequest request) {
        Boolean returnObj = null;
        returnObj = productCompanyService.deleteById(id);
        return ResponseEntity.ok( Utils.kv());
    }
}