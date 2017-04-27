package com.bugsmanage.service;

import java.util.List;
import com.bugsmanage.pojo.Project;
import com.bugsmanage.util.tag.PageModel;

/**
 * @Description:project service接口
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月15日 下午4:33:15
 */
public interface ProjectService {

	// 添加project
	void addProject(Project project);

	// 删除project
	void deleteProject(Integer pro_id);

	// 修改project
	void modifyProject(Project project);

	// 根据pro_id查询project
	Project selectProjectById(Integer pro_id);

	// 查询所有Project
	List<Project> selectAllProjects();

	// 根据pro_name进行查询存在projet的记录数
	Integer checkProject(String pro_name);

	// 分页查询
	List<Project> findProject(Project project, PageModel pageModel);

}
