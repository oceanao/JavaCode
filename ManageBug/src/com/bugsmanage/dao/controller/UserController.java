package com.bugsmanage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bugsmanage.pojo.User;
import com.bugsmanage.service.UserService;

/**
 * @Description:
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月19日 上午10:13:47
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	// 跳转到用户登录页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String tologin() {

		return "user/login";
	}

	// 跳转到用户注册界面
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String toregist() {

		return "user/regist";
	}
	
	// 跳转到用户注册界面
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String tormain() {

		return "user/main";
	}


	// 用户提交登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("student_num") String student_num, 
			@RequestParam("password") String password,
			 HttpSession session) {
		 Integer cow=0;
		 cow = userService.login(student_num, password);
		if (cow!=0) {
			// 将用户保存到HttpSession当中
			User user=userService.getUserByStudent_Num(student_num);
			System.out.println(user);
			
			session.removeAttribute("msg");
			// 客户端跳转到main页面
			session.setAttribute("student_num", user.getStudent_num());
			session.setAttribute("user_id", user.getUser_id());
			session.setAttribute("username", user.getUsername());
			return "redirect:/user/main";// 用户主页
		} 
		else {
			// 设置登录失败提示信息
			session.setAttribute("msg", "登录名或密码错误!请重新输入");
			return "redirect:/user/login";
			// 服务器内部跳转到登录页面
		}
	}

	// 用户注册
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(User user, HttpSession session) {
		int cow = userService.countUserByStudent_Num(user.getStudent_num());
		if (cow==0) {
			session.setAttribute("msg", "注册成功");
			userService.addUser(user);
			return "redirect:/user/login";// 注册完毕后跳转到登录页面
		}
		session.setAttribute("msg", "该用户已注册，注册失败");
		return "redirect:/user/regist";
	}

	
	
	// 用户退出
	@RequestMapping(value = "/logOut")
	public String loginOut(HttpSession session) {

		session.invalidate();
		return "redirect:/user/login";
	}
	
	// 跳转到测试界面
		@RequestMapping(value = "/hello")
		public String hello() {
			return "/user/hello";
		}
		// 跳转到测试界面
				@RequestMapping(value = "/welcome")
				public String welcome() {
					return "/user/welcome";
				}


}
