package com.n22.system.controller;

import com.n22.common.utils.UUIDGenerator;
import com.n22.system.model.Role;
import com.n22.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wangsiyong
 * @Description: 角色管理请求处理
 * @date 2018/8/7 14:58
 */
@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/getDb1AllRole")
	public List<Map> getDb1AllRole() {
		List<Map> list = roleService.getAllRole1();
		return list;
	}

	@RequestMapping(value = "/getDb2AllRole")
	public List<Map> getDb2AllRole() {
		List<Map> list = roleService.getAllRole2();
		return list;
	}

	@RequestMapping(value = "/addDb1Role")
	public String addDb1Role(String name) {
		Role role = new Role(UUIDGenerator.create32Key(), name, new Date(), new Date());
		//返回的是结果行数
		Long rows = roleService.addRoleGetID1(role);
		return "{id:" + role.getId() + "}";
	}

	@RequestMapping(value = "/addDb2Role")
	public String addDb2Role(String name) {
		Role role = new Role(UUIDGenerator.create32Key(), name, new Date(), new Date());
		Long rows = roleService.addRoleGetID2(role);
		return "{id:" + role.getId() + "}";
	}
}