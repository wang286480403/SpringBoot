package com.n22.demo.mapper;

import com.n22.demo.entity.UserEntity;

import java.util.List;

/**
 * @author wangsiyong
 * @Description: TODO
 * @date 2018/8/114:10
 */
public interface UserMapper {

	List<UserEntity> getAll();

	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}
