package cn.smbms.dao.role;

import java.util.List;

import cn.smbms.pojo.Role;

public interface RoleMapper {
	/**
	 * 查询角色列表
	 * @return
	 */
	public List<Role> getRoleList();
}
