package com.n22.system.model;

import java.util.Date;

/**
 * @author wangsiyong
 * @Description: 角色管理
 * @date 2018/8/7 15:28
 */
public class Role {
	private String id;
	private String name;
	private Date createTime;
	private Date updateTime;

	public Role() {
	}

	public Role(String id, String name, Date createTime, Date updateTime) {
		this.id = id;
		this.name = name;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
