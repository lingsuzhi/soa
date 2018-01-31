package com.lszpro.soa.web;

import com.github.pagehelper.Page;
import com.lszpro.soa.common.BaseResponse;
import com.lszpro.soa.common.LszUtil;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.exception.ServiceException;
import com.lszpro.soa.model.rq.TopicDiseasesRq;
import com.lszpro.soa.service.TopicDiseasesService;
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
import com.github.pagehelper.PageHelper;
import com.lszpro.soa.model.bo.TopicDiseasesBO;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
 
import javax.servlet.http.HttpSession;

/**
 * Admin: lingsuzhi <554600654@qq.com.com> 
 * 时间: 2017-12-15
 */

@Controller
@RequestMapping(value = "/topicDiseases")
public class TopicDiseasesController {

	protected static Logger log = LoggerFactory.getLogger(TopicDiseasesController.class);

	@Autowired
	private TopicDiseasesService topicDiseasesService;
	@RequestMapping("/topicDiseasesList.php")
	public @ResponseBody ResponseEntity  topicDiseasesList(TopicDiseasesRq rq, HttpServletRequest request, Model model, HttpSession session) {
		PageHelper.startPage(rq.getPage(), rq.getLimit(), true).pageSizeZero(true).reasonable(true);
		Map map = LszUtil.beanToMap(rq);
		List<TopicDiseasesBO> list = topicDiseasesService.selectList(map);
		return (list == null) ?
				ResponseEntity.ok(Utils.kv()) :
				ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
	}
	@RequestMapping(value = "/topicDiseasesSave.php", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity memberActivitySave(@RequestBody TopicDiseasesBO topicDiseasesBO,HttpServletRequest request) {
		String id = topicDiseasesBO.getId();
		TopicDiseasesBO returnObj = null;
		if (id == null || id.isEmpty()) {
			// 新增
			returnObj = topicDiseasesService.insert(topicDiseasesBO);
		} else {
			returnObj = topicDiseasesService.update(topicDiseasesBO, id);
		}

		return ResponseEntity.ok(Utils.kv("data", returnObj ));

	}
	@RequestMapping("/topicDiseasesById.php")
	public @ResponseBody ResponseEntity topicDiseasesselectone(@RequestParam(required = true) String id,
			HttpServletRequest request) throws  Exception {
		TopicDiseasesBO returnObj = null;
		returnObj = topicDiseasesService.selectOne(id);
		return ResponseEntity.ok(Utils.kv("data", returnObj));
	}
	/**
	 * 删除
	 */
	@RequestMapping("/topicDiseasesDel.php")
	@ResponseBody
	public BaseResponse topicDiseasesDel(@RequestParam(required = true) String id, HttpServletRequest request) {
		return new BaseResponse(topicDiseasesService.delete(id));
	}
}