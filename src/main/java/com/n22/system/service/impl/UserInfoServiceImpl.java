package com.n22.system.service.impl;

import com.n22.system.dao.UserInfoDao;
import com.n22.system.model.UserInfo;
import com.n22.system.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangsiyong
 * @Description: TODO
 * @date 2018/8/8 17:24
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	private UserInfoDao userInfoDao;
	@Override
	public UserInfo findByUsername(String username) {
		System.out.println("UserInfoServiceImpl.findByUsername()");
		return userInfoDao.findByUsername(username);
	}
}
