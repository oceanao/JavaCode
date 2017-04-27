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

import com.bugsmanage.pojo.Project;
import com.bugsmanage.service.ProjectService;
import com.bugsmanage.util.tag.PageModel;

/**
 * @Description:
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月19日 下午9:57:58
 */
@Controller
public class ProjectController {

	@Autowired
	@Qualifier("projectService")
	ProjectService projectService;
	
	
	
/**********************************admin Project******************************************/
	//项目详情
	@RequestMapping(value ="/project/detailProject")
	public ModelAndView detailProject(@ModelAttribute Project project, ModelAndView mv){
		// 根据id查询部门
		Project target = projectService.selectProjectById(project.getPro_id());
		// 设置Model数据
		mv.addObject("project", target);
		// 设置跳转到修改页面
		mv.setViewName("project/projectdetail");
		return mv;
		
	}
	
	@RequestMapping(value ="/project/selectProject")
	public String selectProject(
			Model model, 
			Integer pageIndex,
			@ModelAttribute Project project) {
		System.out.println("selectDept -->>");
		System.out.println("pageIndex = " + pageIndex);
		System.out.println("project = " + project);
		PageModel pageModel = new PageModel();
		System.out.println("getPageIndex = " + pageModel.getPageIndex());
		System.out.println("getPageSize = " + pageModel.getPageSize());
		System.out.println("getRecordCount = " + pageModel.getRecordCount());
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询信息 */
		List<Project> projects = projectService.findProject(project, pageModel);
		model.addAttribute("projects", projects);
		model.addAttribute("pageModel", pageModel);
		return "project/project";
	}

	/**
	 * 处理添加请求
	 * 
	 * @param String
	 *            flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param Project
	 *            project 要添加的项目对象
	 * @param ModelAndView
	 *            mv
	 */
	@RequestMapping(value = "/project/addProject")
	public ModelAndView addProject(String flag, 
			@ModelAttribute Project project, 
			ModelAndView mv,
			 HttpSession session) {

		if (flag.equals("1")) {
			// 设置跳转到添加页面showAddProject.jsp:<a href="project/addProject?flag=1">添加项目</a>
			mv.setViewName("project/showAddProject");
		} else {
			/// 检查项目名称是否同名
			Integer cow = projectService.checkProject(project.getPro_name());
			if (cow == 0) {
				// 执行添加操作
				System.out.println(project);
				projectService.addProject(project);
				System.out.println(project);
				// 设置客户端跳转到查询请求
				mv.setViewName("redirect:/project/selectProject");
			} else {
				
//				mv.addObject("project",project);//回显到添加页面
				session.setAttribute("projectmsg", "已存在该项目");
				mv.setViewName("project/showAddProject");
			}
		}
		// 返回
		return mv;
	}

	/**
	 * 处理修改项目请求
	 * 
	 * @param String
	 *            flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Project
	 *            project 要修改项目的对象
	 * @param ModelAndView
	 *            mv
	 */
	@RequestMapping(value = "/project/updateProject")
	public ModelAndView updateProject(String flag, @ModelAttribute Project project, ModelAndView mv) {
		if (flag.equals("1")) {
			// 根据id查询部门
			Project target = projectService.selectProjectById(project.getPro_id());
			// 设置Model数据
			mv.addObject("project", target);
			// 设置跳转到修改页面
			mv.setViewName("project/showUpdatProject");
		} else {
			// 执行修改操作
			projectService.modifyProject(project);
			System.out.println(project);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/project/selectProject");
		}
		// 返回
		return mv;
	}

	
	// 删除单个项目：<a href="${basepath}/project/removeProject?id=${project.pro_id}">
	@RequestMapping(value = "/project/removeProject")
	public ModelAndView removeProject(@RequestParam("pro_id") String pro_id, ModelAndView mv) {
		// 根据id删除员工
		projectService.deleteProject(Integer.parseInt(pro_id));
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/project/selectProject");
		// 返回ModelAndView
		return mv;
	}
	
/**************************************user project**************************************/	
	
	@RequestMapping(value ="/user/Project")
	public String UserselectProject(
			Model model, 
			Integer pageIndex,
			@ModelAttribute Project project) {
		System.out.println("selectDept -->>");
		System.out.println("pageIndex = " + pageIndex);
		System.out.println("project = " + project);
		PageModel pageModel = new PageModel();
		System.out.println("getPageIndex = " + pageModel.getPageIndex());
		System.out.println("getPageSize = " + pageModel.getPageSize());
		System.out.println("getRecordCount = " + pageModel.getRecordCount());
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询信息 */
		List<Project> projects = projectService.findProject(project, pageModel);
		model.addAttribute("projects", projects);
		model.addAttribute("pageModel", pageModel);
		return "project/uproject";
	}

}
