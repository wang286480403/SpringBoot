package com.n22.system.service;

import com.n22.system.model.UserInfo;

/**
 * @author wangsiyong
 * @Description: TODO
 * @date 2018/8/8 17:23
 */
public interface UserInfoService {
	/**
	 * 通过username查找用户信息
	 * @param username
	 * @return
	 */
	public UserInfo findByUsername(String username);
}
