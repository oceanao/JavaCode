package com.bugsmanage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bugsmanage.pojo.User;
import com.bugsmanage.service.UserService;
import com.bugsmanage.util.tag.PageModel;

/**
 * @Description:
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月19日 下午5:16:16
 */
@Controller
public class UserManageController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	//查询所有用户并在页面显示
	@RequestMapping(value = "/user/selectUser")
	public String selectUser(Integer pageIndex, 
			@ModelAttribute User user, 
			Model model) {

		System.out.println("user = " + user);
		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息 */
		List<User> users = userService.findUser(user, pageModel);
		model.addAttribute("users", users);
		model.addAttribute("pageModel", pageModel);//获取分页标签信息
		return "user/user";
		

	}

	
	// 批量删除用户
	// @RequestMapping(value="/user/removeUser")
	// public ModelAndView removeUser(String ids,ModelAndView mv){
	// // 分解id字符串
	// String[] idArray = ids.split(",");
	// for(String user_id : idArray){
	// // 根据id删除员工
	// userService.deleteUser(Integer.parseInt(user_id));
	// }
	// // 设置客户端跳转到查询请求
	// mv.setViewName("redirect:/user/selectUser");
	// // 返回ModelAndView
	// return mv;
	// }
	//
	
	
	
	
	//删除单个用户：<a href="${basepath}/user/removeUser?id=${user.user_id}">
	@RequestMapping(value = "/user/removeUser")
	public ModelAndView removeUser(@ModelAttribute User user, ModelAndView mv) {
		// 根据id删除员工
		userService.deleteUser(user.getUser_id());
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/user/selectUser");
		// 返回ModelAndView
		return mv;
	}

	
	/**
	 * 处理修改用户请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param User user  要修改用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/user/updateUser")
	 public ModelAndView updateUser(
			 String flag,
			 @ModelAttribute User user,
			 ModelAndView mv){
		//跳转到修改页面showUpdateUser：<a href="${basepath}/user/updateUser?flag=1&id=${user.id}">
		if(flag.equals("1")){
			// 根据id查询用户
			User target = userService.findUserById(user.getUser_id());
			// 设置Model数据
			mv.addObject("user", target);
			// 返回修改员工页面
			mv.setViewName("user/showUpdateUser");
		}else{
			// 在修改页面showUpdateUser执行修改操作：<form action="${basepath}/user/updateUser" id="userForm" method="post">
			userService.modifyUser(user);
			// 设置客户端跳转到查询请求
			System.out.println(user);
			mv.setViewName("redirect:/user/selectUser");
		}
		// 返回
		return mv;
	}
	
	
	
	/**
	 * 处理添加用户请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param User user  要添加用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/user/addUser")
	 public ModelAndView addUser(
			 String flag,
			 @ModelAttribute User user,
			 ModelAndView mv,
			 HttpSession session){
		
		if(flag.equals("1")){
			// 设置跳转到添加页面showAddUser：<a href="user/addUser?flag=1">添加用户</a>
			mv.setViewName("user/showAddUser");
		}else{
			// 在添加用户页面showAddUser页面执行添加操作：<form action="${basepath}/user/addUser" id="userForm" method="post">

			int cow=userService.countUserByStudent_Num(user.getStudent_num());
			if(cow!=0){
				session.setAttribute("usermsg", "该用户已注册");
				mv.setViewName("user/showAddUser");
			}
			else{
			userService.addUser(user);
			System.out.println(user);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/user/selectUser");
			}
		}
		// 返回
		return mv;
	}
	@RequestMapping(value="/common")
	public ModelAndView common(
			String flag,
			 @ModelAttribute User user,
			 ModelAndView mv,
			 HttpSession session)
	{
		mv.setViewName("/common");
		return mv;
	}
	


}
