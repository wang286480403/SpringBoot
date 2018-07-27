package com.n22.demo;

import com.n22.demo.model.User;
import com.n22.demo.service.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author wangsiyong
 * @Description: 用户测试
 * @date 2018/7/2717:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);

		userRepository.deleteAll();

		userRepository.save(new User("aa", "aa1", "aa@126.com", "aa123456",formattedDate));
		userRepository.save(new User("bb", "bb2", "bb@126.com", "bb123456",formattedDate));
		userRepository.save(new User("cc", "cc3", "cc@126.com", "cc123456",formattedDate));

		System.out.println(userRepository.findAll().size());
		Assert.assertEquals(3, userRepository.findAll().size());
		Assert.assertEquals("bb123456", userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());
		userRepository.delete(userRepository.findByUserName("aa"));
	}
}
