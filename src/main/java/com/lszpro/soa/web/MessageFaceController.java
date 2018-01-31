package com.lszpro.soa.web;
 
import com.github.pagehelper.Page;
import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.model.rq.MessageFaceRq;

import com.lszpro.soa.service.MessageFaceService;
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
import com.lszpro.soa.model.bo.MessageFaceBO;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 时间: 2017-12-13
 */

@Controller
@RequestMapping(value = "/messageFace")
public class MessageFaceController {

    protected static Logger log = LoggerFactory.getLogger(MessageFaceController.class);
    @Autowired
    private MessageFaceService messageFaceService;

    @RequestMapping("/messageFaceList.php")
    @ResponseBody
    public ResponseEntity messageFaceList(MessageFaceRq rq, HttpServletRequest request, Model model, HttpSession session) {
        PageHelper.startPage(rq.getPage(), rq.getLimit(), true).pageSizeZero(true).reasonable(true);
        Map map = LszUtil.beanToMapEmpty(rq);
        log.info("rq:" + map.toString());
        List<MessageFaceBO> list = messageFaceService.selectList(map);
        return (list == null) ? ResponseEntity.ok(Utils.kv()) :
                ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
    }

    @RequestMapping(value = "/messageFaceSave.php", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity memberActivitySave(@RequestBody MessageFaceBO messageFaceBO, HttpServletRequest request) {
        String id = messageFaceBO.getId();
        MessageFaceBO returnObj = null;
        if (id == null || id.isEmpty()) {            // 新增
            returnObj = messageFaceService.insert(messageFaceBO);
        } else {
            returnObj = messageFaceService.updateById(messageFaceBO, id);
        }
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/messageFaceById.php")
    @ResponseBody
    public ResponseEntity messageFaceselectone(@RequestParam(required = true) String id, HttpServletRequest request) {
        MessageFaceBO returnObj = null;
        returnObj = messageFaceService.selectById(id);
        return ResponseEntity.ok(Utils.kv("data", returnObj));
    }

    @RequestMapping("/messageFaceDel.php")
    @ResponseBody
    public ResponseEntity messageFaceDel(@RequestParam(required = true) String id, HttpServletRequest request) {
        Boolean returnObj = null;
        returnObj = messageFaceService.deleteById(id);
        return ResponseEntity.ok( Utils.kv());
    }
}