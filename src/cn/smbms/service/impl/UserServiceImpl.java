package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User login(String userCode, String userPassword) {
		return userMapper.login(userCode, userPassword);
	}

	@Override
	public User checkCodeAndPwd(String userCode) {
		return userMapper.checkCodeAndPwd(userCode);
	}

	@Override
	public Integer getTotalCount(String userName, Integer roleId) {
		return userMapper.getTotalCount(userName, roleId);
	}

	@Override
	public List<User> getUserList(String userName, Integer roleId,
			Integer from, Integer pageSize) {
		return userMapper.getUserList(userName, roleId, from, pageSize);
	}

	@Override
	public List<Role> getRoleList() {
		return userMapper.getRoleList();
	}

}
