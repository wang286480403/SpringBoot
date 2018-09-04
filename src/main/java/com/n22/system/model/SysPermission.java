package com.n22.system.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author wangsiyong
 * @Description: 权限管理
 * @date 2018/8/8 14:48
 */
@Entity
public class SysPermission implements Serializable {
	@Id
	@GeneratedValue
	/**主键*/
	private Integer id;
	/**名称*/
	private String name;
	/**资源类型，[menu|button]*/
	@Column(columnDefinition = "enum('menu','button')")
	private String resourceType;
	/**资源路径*/
	private String url;
	/**权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view*/
	private String permission;
	/**父编号*/
	private Long parentId;
	/**父编号列表*/
	private String parentIds;
	private Boolean available = Boolean.FALSE;
	@ManyToMany
	@JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "permissionId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
	private List<SysRole> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
}
