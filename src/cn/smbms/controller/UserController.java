package cn.smbms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.constans.Constants;
import cn.smbms.pojo.Page;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;

import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;

	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	@RequestMapping("/doLogin")
	public String doLogin(Model model,
			@RequestParam("userCode") String userCode,
			@RequestParam("userPassword") String userPassword,
			HttpSession session,
			HttpServletRequest request) {
		User user = userService.login(userCode, userPassword);
		if(user != null){
			session.setAttribute(Constants.USER_SESSION, user);
			return "redirect:/user/main";
		}else{
			User user1 = userService.checkCodeAndPwd(userCode);
			if(user1 == null){
				request.setAttribute("error", "用户名不正确");
			}else if(user1.getUserPassword() != userPassword){
				request.setAttribute("error", "密码输入错误");
			}
			return "/login";
		}
	}
	
	
	@RequestMapping("/main")
	public String main(HttpSession session){
		if(session.getAttribute(Constants.USER_SESSION) == null){
			return "redirect:/user/login";
		}
		return "/frame";
	}
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session){
		session.removeAttribute(Constants.USER_SESSION);
		return "/login";
	}
	
	
	@RequestMapping("/userlist")
	public String userLits(Model model,
			@RequestParam(value="queryname",required=false) String queryUserName,
			@RequestParam(value="queryUserRole",required=false)String queryUserRole,
			@RequestParam(value="pageIndex",required=false)String pageIndex){
		int pageSize = Constants.pageSize;
		int roleId = 0;
		int currPageNo = 1;
		if(!StringUtils.isNullOrEmpty(queryUserRole)){
			roleId = Integer.valueOf(queryUserRole);
		}
		if(!StringUtils.isNullOrEmpty(pageIndex)){
			currPageNo = Integer.valueOf(pageIndex);
		}
		int totalCount = userService.getTotalCount(queryUserName, roleId);
		
		Page page = new Page();
		page.setPageSize(pageSize);
		page.setCurrPageNo(currPageNo);
		page.setTotalCount(totalCount);
		
		Integer from = (page.getCurrPageNo() - 1)*page.getPageSize();
		List<User> userList = userService.getUserList(queryUserName, roleId, from, pageSize);
		
		List<Role> roleList = userService.getRoleList();
		model.addAttribute("userList", userList);
		model.addAttribute("page", page);
		model.addAttribute("roleList", roleList);
		model.addAttribute("queryUserRole", queryUserRole);
		model.addAttribute("queryname", queryUserName);
		return "/userlist";
		
	}
}
