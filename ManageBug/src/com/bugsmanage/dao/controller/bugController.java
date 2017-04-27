package com.bugsmanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bugsmanage.pojo.Bug;
import com.bugsmanage.pojo.Bugfile;
import com.bugsmanage.pojo.Bugseverity;
import com.bugsmanage.pojo.Project;
import com.bugsmanage.pojo.User;
import com.bugsmanage.service.BugService;
import com.bugsmanage.service.BugfileService;
import com.bugsmanage.service.BugseverityService;
import com.bugsmanage.service.ProjectService;
import com.bugsmanage.service.UserService;
import com.bugsmanage.util.common.ViewExcel;

import com.bugsmanage.util.tag.PageModel;

/**
 * @Description:
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月23日 下午7:28:05
 */
@Controller
public class bugController {
	@Autowired
	@Qualifier("bugService")
	private BugService bugService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	@Qualifier("projectService")
	ProjectService projectService;

	@Autowired
	@Qualifier("bugseverityService")
	private BugseverityService bugseverityService;

	@Autowired
	@Qualifier("bugfileService")
	private BugfileService bugfileService;

	/*********************************** admin bug**********************************/

	// 管理员后台显示所有bug
	@RequestMapping(value = "/bug/selectBug")
	public String AdminselectBug(Model model, Integer pageIndex, Integer pro_id, Integer bugseverity_id,
			Integer reporter_id, Integer handler_id, @ModelAttribute Bug bug, HttpSession session) {

		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(pro_id, bugseverity_id, reporter_id, handler_id, bug);
		PageModel pageModel = new PageModel();

		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询信息 */
		List<User> users = userService.findAllUser();
		List<Project> projects = projectService.selectAllProjects();
		List<Bugseverity> bugseveritys = bugseverityService.selectAllBugseverity();
		List<Bug> bugs = bugService.findBug(bug, pageModel);
		model.addAttribute("bugs", bugs);
		model.addAttribute("users", users);
		model.addAttribute("projects", projects);
		model.addAttribute("bugseveritys", bugseveritys);
		model.addAttribute("pageModel", pageModel);
		return "bug/Abug";
	}

	
	//根据项目id:pro_id导出Excel
	@RequestMapping(value = "/project/exportExcel")
	public ModelAndView exportExcel(ModelMap model, Integer pro_id, HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Bug bug) throws Exception {
		
		if (pro_id != null) {
			Project project = new Project();
			project.setPro_id(pro_id);
			bug.setProject(project);
		}
		
		ViewExcel viewExcel = new ViewExcel();
		Map obj = null;		
		HSSFWorkbook workbook = bugService.SetToExcel(bug);
		viewExcel.buildExcelDocument(obj, workbook, request, response);
		return new ModelAndView(viewExcel, model);
	}

	
	//模糊查询导出Excel
	@RequestMapping(value = "/bug/exportExcel")
	public ModelAndView mohuexportExcel(ModelMap model, HttpServletRequest request,HttpSession session,
			HttpServletResponse response, @ModelAttribute Bug bug) throws Exception {		
			
		bug=(Bug) session.getAttribute("bug");
		ViewExcel viewExcel = new ViewExcel();
		Map obj = null;		
		HSSFWorkbook workbook = bugService.SetToExcel(bug);
		viewExcel.buildExcelDocument(obj, workbook, request, response);
		return new ModelAndView(viewExcel, model);
	}
	
	
	
	// 管理员修改bug（分配bug）
	@RequestMapping(value = "/bug/updateBug") 
	public ModelAndView AdminupdateBug(String flag, Integer handler_id, @ModelAttribute Bug bug, ModelAndView mv) {
		//当flag==1， 跳转页面
		if (flag.equals("1")) {
			// 根据id查询部门
			Bug target = bugService.selectBugById(bug.getBug_id());
			List<User> users = userService.findAllUser();
			List<Project> projects = projectService.selectAllProjects();
			List<Bugseverity> bugseveritys = bugseverityService.selectAllBugseverity();
			mv.addObject("projects", projects);
			mv.addObject("bugseveritys", bugseveritys);
			mv.addObject("users", users);
			// 设置Model数据
			mv.addObject("bug", target);
			// 设置跳转到修改页面
			mv.setViewName("bug/Aupdatebug");
		} else {
			// 管理员修改bug
			// 设置bug处理人
			if (handler_id != null) {
				User handler = new User();
				handler.setUser_id(handler_id);
				bug.setHandler(handler);
			}
			bugService.modifyBug(bug);
			System.out.println(bug);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/bug/selectBug");
		}
		// 返回
		return mv;
	}

	
	// 删除bug
	@RequestMapping(value = "/bug/removeBug")
	public ModelAndView removeBug(@RequestParam("bug_id") String bug_id, ModelAndView mv) {
		// 根据id删除
		bugService.deleteBug(Integer.parseInt(bug_id));
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/bug/selectBug");
		// 返回ModelAndView
		return mv;
	}

	/********************************** 公共部分 *****************************************/

	// bug详情
	@RequestMapping(value = "/bug/detailBug")
	public ModelAndView detailProject(@ModelAttribute Bug bug, ModelAndView mv) {
		// 根据bug_id查询附件
		Bug target = bugService.selectBugById(bug.getBug_id());
		List<Bugfile> bugfiles = bugfileService.selectBugfileByBugId(bug.getBug_id());
		// 设置Model数据
		mv.addObject("bugfiles", bugfiles);
		mv.addObject("bug", target);
		// 设置跳转到修改页面
		mv.setViewName("bug/bugdetail");
		return mv;

	}

	
	/**
	 * 由于对象关联映射， 所以不能直接接收参数，需要创建对象
	 */
	private void genericAssociation(Integer pro_id, Integer bugseverity_id, Integer reporter_id, Integer handler_id,
			Bug bug) {
		if (pro_id != null) {
			Project project = new Project();
			project.setPro_id(pro_id);
			bug.setProject(project);
		}
		if (bugseverity_id != null) {
			Bugseverity bugseverity = new Bugseverity();
			bugseverity.setBugseverity_id(bugseverity_id);
			bug.setBugseverity(bugseverity);
		}

		if (reporter_id != null) {
			User reporter = new User();
			reporter.setUser_id(reporter_id);
			bug.setReporter(reporter);
		}

		if (handler_id != null) {
			User handler = new User();
			handler.setUser_id(handler_id);
			bug.setHandler(handler);
		}
	}

	
	//图标统计：按缺陷级别	
	@RequestMapping(value = "/project/countByBugseverity")
	public ModelAndView countByBugseverity(Integer pro_id,ModelAndView mv){
		Bug bug=new Bug();
		if (pro_id != null) {
			Project project = new Project();
			project.setPro_id(pro_id);
			bug.setProject(project);//设置项目
		}		
		Map<String, Integer> map = new HashMap<String, Integer>();		
		int count;
		List<Bugseverity> bugseveritys = bugseverityService.selectAllBugseverity();//查询得到所有bugseverity
		for(Bugseverity bugseverity : bugseveritys){//遍历缺陷级别					
			count=0;			
			bug.setBugseverity(bugseverity);//设置缺陷级别			
			count=bugService.countbug(bug);//查询个数			
			map.put(bugseverity.getSeverity(), count);//可能需要加tostring
		
		}		
		mv.addObject("map", map);
		mv.setViewName("project/projectdetail");//转向项目详情页面
		return mv;
	}
	
	
	
	
	//图标统计：按提交人进行统计
	@RequestMapping(value = "/project/countByReporter")
	public ModelAndView countByReporter(Integer pro_id, ModelAndView mv){
		Bug bug=new Bug();
		if (pro_id != null) {
			Project project = new Project();
			project.setPro_id(pro_id);
			bug.setProject(project);//设置项目
		}		
		Map<String, Integer> map = new HashMap<String, Integer>();
		int count;
		List<User> users = userService.findAllUser();//查询出所有用户
		for(User reporter : users){//遍历用户
			count=0;
			bug.setReporter(reporter);//设置用户
			count=bugService.countbug(bug);//查询得到个数
			if(count!=0){
			map.put(reporter.getUsername(), count);//可能需要加tostring
			}
		}
		mv.addObject("map", map);
		mv.setViewName("project/projectdetail");//转向项目详情页面
		return mv;
	}
	
	
	
	
	
	
	/************************************* user bug **********************************/
	// 只显示该项目下的所有bug 点击序号
	@RequestMapping(value = "/user/selectProjectbug")
	public String UserselectProjectBug(Model model, @RequestParam("pro_id") Integer pro_id, Integer bugseverity_id,
			Integer reporter_id, Integer handler_id, Integer pageIndex, @ModelAttribute Bug bug) {

		this.genericAssociation(pro_id, bugseverity_id, reporter_id, handler_id, bug);

		PageModel pageModel = new PageModel();
		System.out.println("getPageIndex = " + pageModel.getPageIndex());
		System.out.println("getPageSize = " + pageModel.getPageSize());
		System.out.println("getRecordCount = " + pageModel.getRecordCount());
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询信息 */
		List<User> users = userService.findAllUser();
		List<Bugseverity> bugseveritys = bugseverityService.selectAllBugseverity();
		List<Bug> bugs = bugService.findBug(bug, pageModel);

		model.addAttribute("pro_id", pro_id);// 继续在此项目内进行查询
		model.addAttribute("bugs", bugs);
		model.addAttribute("users", users);
		model.addAttribute("bugseveritys", bugseveritys);
		model.addAttribute("pageModel", pageModel);
		return "bug/Uprojectbug";
	}

	
	// 用户添加bug
	@RequestMapping(value = "/user/addBug") 
	public ModelAndView addBug(String flag, Integer pro_id, Integer bugseverity_id, @ModelAttribute Bug bug,
			ModelAndView mv, HttpSession session) {
		// 当flag==1时，跳转到添加bug页面
		// 设置跳转到添加页面showAddProject.jsp:<a href="/user/addBug?flag=1">添加缺陷</a>
		if (flag.equals("1")) {
			List<Project> projects = projectService.selectAllProjects();
			List<Bugseverity> bugseveritys = bugseverityService.selectAllBugseverity();
			mv.addObject("projects", projects);
			mv.addObject("bugseveritys", bugseveritys);
			mv.setViewName("bug/Uaddbug");
		} else {
			// 用户执行添加bug操作
			// 设置reporter
			User reporter = new User();
			//得到当前用户的user_id 
			int reporter_id = (int) session.getAttribute("user_id");
			reporter.setUser_id(reporter_id);
			bug.setReporter(reporter);
			// 由于数据库handler_id不能为空，添加处理人时，直接指派给admin
			User handler = new User();
			//admin的user_id=1
			handler.setUser_id(1);
			bug.setHandler(handler);
			//添加Project
			if (pro_id != null) {
				Project project = new Project();
				project.setPro_id(pro_id);
				bug.setProject(project);
			}
			//添加bugseverity
			if (bugseverity_id != null) {
				Bugseverity bugseverity = new Bugseverity();
				bugseverity.setBugseverity_id(bugseverity_id);
				bug.setBugseverity(bugseverity);
			}
			
			//先查询是否该项目已经存在该bug
			Integer cow = bugService.countbug(bug);
			//已存在该bug 
			if (cow != 0) {
				mv.addObject("message", "该缺陷已经存在");
				List<Project> projects = projectService.selectAllProjects();
				List<Bugseverity> bugseveritys = bugseverityService.selectAllBugseverity();
				mv.addObject("projects", projects);
				mv.addObject("bugseveritys", bugseveritys);
				mv.setViewName("bug/Uaddbug");
			} else {
				//执行添加操作
				bugService.addBug(bug);
				//模糊查询
				Bug bug1 = bugService.selectBugByAdd(bug);
				//精确查询
				Bug bug2 = bugService.selectBugById(bug1.getBug_id());
				mv.addObject("bug", bug2);
				//跳转到添加附件页面
				mv.setViewName("bug/AdddetailBug");
			}
		}
		// 返回
		return mv;
	}

	
	
	// 显示所有bug，查询bug
	@RequestMapping(value = "/user/selectBug")
	public String UserselectBug(Model model, Integer pageIndex, Integer pro_id, Integer bugseverity_id,
			Integer reporter_id, Integer handler_id, @ModelAttribute Bug bug, HttpSession session) {
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(pro_id, bugseverity_id, reporter_id, handler_id, bug);

		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询信息 */
		List<User> users = userService.findAllUser();
		List<Project> projects = projectService.selectAllProjects();
		List<Bugseverity> bugseveritys = bugseverityService.selectAllBugseverity();
		List<Bug> bugs = bugService.findBug(bug, pageModel);

		session.setAttribute("bug", bug);
		model.addAttribute("bugs", bugs);
		model.addAttribute("users", users);
		model.addAttribute("projects", projects);
		model.addAttribute("bugseveritys", bugseveritys);
		model.addAttribute("pageModel", pageModel);
		return "bug/Ubug";
	}

	
	// 查找当前用户需的任务（需要复现的bug列表）
	@RequestMapping(value = "/user/mission")
	public String Userselectmission(Model model, Integer pageIndex, @ModelAttribute Bug bug, HttpSession session) {
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		User handler = new User();
		//得到登录用户的user_id
		int user_id = (int) session.getAttribute("user_id");
		handler.setUser_id(user_id);
		bug.setHandler(handler);
		//流程状态：已分配，ID=3
		bug.setBug_status(3);

		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询信息 */
		List<User> users = userService.findAllUser();
		List<Project> projects = projectService.selectAllProjects();
		List<Bugseverity> bugseveritys = bugseverityService.selectAllBugseverity();
		List<Bug> bugs = bugService.findBug(bug, pageModel);

		model.addAttribute("bugs", bugs);
		model.addAttribute("users", users);
		model.addAttribute("projects", projects);
		model.addAttribute("bugseveritys", bugseveritys);
		model.addAttribute("pageModel", pageModel);
		return "bug/Umission";
	}

	
	// 用户处理bug（复现bug）：用户可修改  bug流程状态:bug_status，bug处理结果:bug_result，评论:bug_comment
	@RequestMapping(value = "/user/updateBug") 
	public ModelAndView UserupdateBug(String flag, @ModelAttribute Bug bug, ModelAndView mv) {
		if (flag.equals("1")) {// 跳转页面
			// 根据id查询bug
			Bug target = bugService.selectBugById(bug.getBug_id());
			//查询附件
			List<Bugfile> bugfiles = bugfileService.selectBugfileByBugId(bug.getBug_id());
			// 设置Model数据
			mv.addObject("bugfiles", bugfiles);		
			mv.addObject("bug", target);
			// 设置跳转到修改页面
			mv.setViewName("bug/Uupdatebug");
		} else {// 用户修改bug
			bugService.modifyBug(bug);
			System.out.println(bug);
			// 修改完成后，返回mission页面
			mv.setViewName("redirect:/user/mission");
		}
		// 返回
		return mv;
	}

}
