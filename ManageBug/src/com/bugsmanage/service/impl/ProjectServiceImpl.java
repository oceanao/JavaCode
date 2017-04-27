package com.bugsmanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bugsmanage.dao.ProjectDao;
import com.bugsmanage.pojo.Project;
import com.bugsmanage.service.ProjectService;
import com.bugsmanage.util.tag.PageModel;

/**
 * @Description:
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月15日 下午4:41:14
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	// 添加project实现
	@Override
	public void addProject(Project project) {

		this.projectDao.save(project);

	}

	// 删除project 实现
	@Override
	public void deleteProject(Integer pro_id) {

		this.projectDao.delectProjectById(pro_id);
	}

	// 修改project实现
	@Override
	public void modifyProject(Project project) {

		this.projectDao.updateProject(project);
	}

	// 根据pro_id查询project实现
	@Transactional(readOnly = true)
	@Override
	public Project selectProjectById(Integer pro_id) {
		return this.projectDao.selectProjectById(pro_id);
	}

	// 查询所有Project实现
	@Transactional(readOnly = true)
	@Override
	public List<Project> selectAllProjects() {
		return this.projectDao.selectAllProjects();
	}

	// 根据pro_name进行查询存在projet的记录数的实现
	@Transactional(readOnly = true)
	@Override
	public Integer checkProject(String pro_name) {
		return this.projectDao.selectProjectByName(pro_name);
	}

	// 分页查询实现
	@Transactional(readOnly = true)
	@Override
	public List<Project> findProject(Project project, PageModel pageModel) {
		/** 当前需要分页的总数据条数 */
		Map<String, Object> params = new HashMap<>();
		params.put("project", project);
		int recordCount = projectDao.count(params);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			/** 开始分页查询数据：查询第几页的数据 */
			params.put("pageModel", pageModel);
		}

		List<Project> projects = projectDao.selectByPage(params);
		return projects;
	}

}
