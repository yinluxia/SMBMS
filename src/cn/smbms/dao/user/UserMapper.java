package cn.smbms.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;

public interface UserMapper {
	/**
	 * 使用用户编码和用户密码登录
	 * 
	 * @param userCode
	 *            用户编码
	 * @param userPassword
	 *            用户密码
	 * @return
	 */
	public User login(@Param("userCode") String userCode,
			@Param("userPassword") String userPassword);

	/**
	 * 检查用户名和密码是否错误
	 * 
	 * @param userCode
	 *            用户名
	 * @param userPassword
	 *            用户密码
	 * @return
	 */
	public User checkCodeAndPwd(@Param("userCode") String userCode);

	/**
	 * 根据用户名和角色id查询总记录
	 * 
	 * @param userName 用户名
	 * @param roleId 角色id
	 * @return 返回记录数
	 */
	public Integer getTotalCount(@Param("userName") String userName,
			@Param("roleId") Integer roleId);

	/**
	 * 根据用户名和角色id查询用户数据
	 * @param userName 用户名
	 * @param roleId 用户角色
	 * @param from 页面显示的起始值
	 * @param pageSize 每页显示的大小
	 * @return
	 */
	public List<User> getUserList(@Param("userName") String userName,
					@Param("roleId") Integer roleId, 
					@Param("from")Integer from, @Param("pageSize")Integer pageSize);
	
	/**
	 * 查询角色信息列表
	 * @return 
	 */
	public List<Role> getRoleList();
}
