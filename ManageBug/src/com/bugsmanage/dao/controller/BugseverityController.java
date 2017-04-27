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

import com.bugsmanage.pojo.Bugseverity;

import com.bugsmanage.service.BugseverityService;


/**
* @Description:
* @author 作者 :lixingyan
* @version 创建时间：2017年3月20日 下午3:51:15
*/
@Controller
public class BugseverityController {
	//查询所有用户并在页面显示
	@Autowired
	@Qualifier("bugseverityService")
	private BugseverityService bugseverityService;
	
		@RequestMapping(value = "/bugseverity/selectBugseverity")
		public String selectBugseverity(
				Model model) {
			/** 查询信息 */
			List<Bugseverity> bugseveritys = bugseverityService.selectAllBugseverity();
			model.addAttribute("bugseveritys", bugseveritys);
			return "bugseverity/bugseverity";
		}

		//用户查看
		@RequestMapping(value = "/user/selectBugseverity")
		public String UserselectBugseverity(
				Model model) {
			/** 查询信息 */
			List<Bugseverity> bugseveritys = bugseverityService.selectAllBugseverity();
			model.addAttribute("bugseveritys", bugseveritys);
			return "bugseverity/Ubugseverity";
		}
		
		
		//添加
		@RequestMapping(value = "/bugseverity/addBugseverity")
		public ModelAndView addBugseverity(String flag, 
				@ModelAttribute Bugseverity bugseverity, 
				ModelAndView mv,
				 HttpSession session) {

			if (flag.equals("1")) {
				// 设置跳转到添加页面showAddProject.jsp:<a href="project/addProject?flag=1">添加项目</a>
				mv.setViewName("bugseverity/showAddBugseverity");
			} else {
				/// 检查项目名称是否同名
				Integer cow = bugseverityService.countBugseverityBySeverity(bugseverity.getSeverity());
				if (cow == 0) {
					// 执行添加操作
					System.out.println(bugseverity);
					bugseverityService.addBugseverity(bugseverity);
					System.out.println(bugseverity);
					// 设置客户端跳转到查询请求
					mv.setViewName("redirect:/bugseverity/selectBugseverity");
				} else {
					
//					mv.addObject("project",project);//回显到添加页面
					session.setAttribute("bugseveritymsg", "已存在该缺陷级别");
					mv.setViewName("bugseverity/showAddBugseverity");
				}
			}
			// 返回
			return mv;
		}
		
		
		/* 处理修改项目请求
		 * 
		 * @param String
		 *            flag 标记， 1表示跳转到修改页面，2表示执行修改操作
		 * @param bugseverity
		 *            bugseverity 要修改项目的对象
		 * @param ModelAndView
		 *            mv
		 */
		@RequestMapping(value = "/bugseverity/updateBugseverity")
		public ModelAndView updateProject(String flag, HttpSession session, @ModelAttribute Bugseverity bugseverity, ModelAndView mv) {
			if (flag.equals("1")) {
				// 根据id查询部门
				Bugseverity target = bugseverityService.selectBugseverityById(bugseverity.getBugseverity_id());
				// 设置Model数据
				mv.addObject("bugseverity", target);
				// 设置跳转到修改页面
				mv.setViewName("bugseverity/showUpdatBugseverity");
			} else {
				// 执行修改操作
//				Integer cow = bugseverityService.countBugseverityBySeverity(bugseverity.getSeverity());
//				if (cow == 1) {
				bugseverityService.modifyBugseverity(bugseverity);
				System.out.println(bugseverity);
				// 设置客户端跳转到查询请求
				mv.setViewName("redirect:/bugseverity/selectBugseverity");
//				}else{
//					session.setAttribute("bugseveritymsg", "已存在该缺陷级别");
//					mv.setViewName("bugseverity/showUpdatBugseverity");
//				}
			}
			// 返回
			return mv;
		}
		
		// 删除单个项目：<a href="${basepath}/project/removeProject?id=${project.pro_id}">
		@RequestMapping(value = "/bugseverity/removeBugseverity")
		public ModelAndView removeProject(@RequestParam("bugseverity_id") String bugseverity_id, ModelAndView mv) {
			// 根据id删除员工
			bugseverityService.delectBugseverity(Integer.parseInt(bugseverity_id));
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/bugseverity/selectBugseverity");
			// 返回ModelAndView
			return mv;
		}

}
