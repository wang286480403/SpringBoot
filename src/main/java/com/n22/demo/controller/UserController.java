package com.n22.demo.controller;

import com.n22.demo.domain.User;
import com.n22.demo.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * @author wangsiyong
 * @Description: TODO
 * @date 2018/7/3016:19
 */
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/getUser")
	@Cacheable(value = "user-key")
	public User getUser() {
		User user = userRepository.findByUserName("aaa");
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return user;
	}

	@RequestMapping("/getUsers")
	@Cacheable(value = "key-Users")
	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return users;
	}

	@RequestMapping("/uid")
	String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return session.getId();
	}
}
