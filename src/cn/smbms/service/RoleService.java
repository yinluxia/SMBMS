package cn.smbms.service;

import java.util.List;

import cn.smbms.pojo.Role;

public interface RoleService {
	/**
	 * 查询角色列表
	 * @return
	 */
	public List<Role> getRoleList();
}
