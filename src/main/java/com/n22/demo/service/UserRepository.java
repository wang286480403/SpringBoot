package com.n22.demo.service;

import com.n22.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangsiyong
 * @Description: 用户接口
 * @date 2018/7/2717:03
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);

	User findByUserNameOrEmail(String username, String email);
}
