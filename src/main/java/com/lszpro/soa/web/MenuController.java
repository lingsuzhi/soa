package com.lszpro.soa.web;

/**
 * Admin: lingsuzhi <554600654@qq.com.com>
 * Date: 2017-09-04
 */


import com.lszpro.soa.common.Constant;
import com.lszpro.soa.common.Utils;
import com.lszpro.soa.other.MenuBO;
import com.lszpro.soa.service.MenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/admin/menu" )
public class MenuController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
	@Autowired
	private MenuService menuService;

	@GetMapping
	public ResponseEntity selectList(@RequestParam(required = false) String parentId,@RequestParam(required = false, defaultValue = Constant.pageNum) int page,
			@RequestParam(required = false, defaultValue = Constant.pageSize) int size) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtil.isNotEmpty(parentId))		map.put("parentId", parentId);
		PageHelper.startPage(page, size, true).pageSizeZero(true).reasonable(true);
		List<MenuBO> list = menuService.selectList(map);
		LOGGER.info("selectList:{}", list);
		return (list == null) ? ResponseEntity.ok(Utils.kv())
				: ResponseEntity.ok(Utils.kv("dataList", (Page) list, "total", ((Page) list).getTotal()));
	}

	@PostMapping
	public ResponseEntity insert(@RequestBody MenuBO menuBO) {
		LOGGER.info("insert:{}", menuBO);
		MenuBO returnObj = menuService.insert(menuBO);
		return ResponseEntity.ok(Utils.kv("data", returnObj));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity update(@RequestBody MenuBO menuBO, @PathVariable String id) {
		LOGGER.info("update：{} id:{}", menuBO, id);
		MenuBO returnObj = menuService.update(menuBO, id);
		LOGGER.info("{}", returnObj);
		return ResponseEntity.ok(Utils.kv("data", returnObj));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable String id) {
		LOGGER.info("deleteDo:{}", id);
		menuService.delete(id);
		return ResponseEntity.ok(Utils.kv());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity selectOne(@PathVariable String id) {
		MenuBO returnObj = menuService.selectOne(id);
		return ResponseEntity.ok(Utils.kv("data", returnObj));
	}
}
