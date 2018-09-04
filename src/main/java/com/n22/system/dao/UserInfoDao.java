package com.n22.system.dao;

import com.n22.system.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @author wangsiyong
 * @Description: TODO
 * @date 2018/8/8 17:24
 */
public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
	/**通过username查找用户信息;*/
	public UserInfo findByUsername(String username);
}
