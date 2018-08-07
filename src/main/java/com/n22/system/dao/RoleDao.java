package com.n22.system.dao;

import com.n22.system.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangsiyong
 * @Description: 角色管理数据持久
 * @date 2018/8/7 14:56
 */
@Mapper
public interface RoleDao {
	public List<Map> getAllRole();

	public Long addRoleGetID(Role role);

	public void addRoler(@Param("name") String name);

}