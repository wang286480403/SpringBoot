package com.n22.system.service;

import com.n22.common.config.db.DS;
import com.n22.system.dao.RoleDao;
import com.n22.system.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wangsiyong
 * @Description: 角色管理业务逻辑
 * @date 2018/8/7 14:57
 */
@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;

	/**
	 * 使用数据源1查询
	 * @return
	 */
	@DS("datasource1")
	public List<Map> getAllRole1(){
		return roleDao.getAllRole();
	}

	/**
	 * 使用数据源2查询
	 * @return
	 */
	@DS("datasource2")
	public List<Map> getAllRole2(){
		return roleDao.getAllRole();
	}

	/**
	 * 使用数据源1插入数据
	 * @param role
	 * @return
	 */
	@DS("datasource1")
	public Long addRoleGetID1(Role role){
		return roleDao.addRoleGetID(role);
	}

	/**
	 * 使用数据源1插入数据
	 * @param role
	 * @return
	 */
	@DS("datasource2")
	public Long addRoleGetID2(Role role){
		return roleDao.addRoleGetID(role);
	}

	/**
	 * 使用数据源1插入数据
	 * @param name
	 */
	@DS("datasource1")
	public void addRoler1(String name){
		roleDao.addRoler(name);
	}

	/**
	 * 使用数据源2插入数据
	 * @param name
	 */
	@DS("datasource2")
	public void addRoler2(String name){
		roleDao.addRoler(name);
	}
}