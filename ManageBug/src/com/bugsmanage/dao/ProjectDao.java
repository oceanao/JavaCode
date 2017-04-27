package com.bugsmanage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.bugsmanage.dao.provider.ProjectDynaSqlProvider;
import com.bugsmanage.pojo.Project;

/**
 * @Description:
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月15日 下午3:59:11
 */

public interface ProjectDao {

	// 动态查询
	@SelectProvider(type = ProjectDynaSqlProvider.class, method = "selectWhitParam")
	@Results({
		    @Result(id = true, column = "pro_id", property = "pro_id"),
			@Result(column = "pro_name", property = "pro_name"),
			@Result(column = "pro_description", property = "pro_description"),
			@Result(column = "pro_version", property = "pro_version")})
	List<Project> selectByPage(Map<String, Object> params);

	@SelectProvider(type = ProjectDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);

	// 动态插入部门
	@InsertProvider(type = ProjectDynaSqlProvider.class, method = "insertProject")
	@Options(useGeneratedKeys=true,keyProperty="pro_id")
	void save(Project project);

	// 动态修改用户
	@UpdateProvider(type = ProjectDynaSqlProvider.class, method = "updateProject")
	void updateProject(Project project);

	// 根据pro_name进行查询
	@Select("select count(*) from project where pro_name= #{pro_name}")
	Integer selectProjectByName(String pro_name);

	// 根据pro_id进行查询
	@Select("select * from project where pro_id= #{pro_id}")
	@Results({
	    @Result(id = true, column = "pro_id", property = "pro_id"),
		@Result(column = "pro_name", property = "pro_name"),
		@Result(column = "pro_description", property = "pro_description"),
		@Result(column = "pro_version", property = "pro_version")})
	Project selectProjectById(@Param("pro_id")Integer pro_id);

	// 查询所有project
	@Select("select * from project")
	@Results({
	    @Result(id = true, column = "pro_id", property = "pro_id"),
		@Result(column = "pro_name", property = "pro_name"),
		@Result(column = "pro_description", property = "pro_description"),
		@Result(column = "pro_version", property = "pro_version")})
	List<Project> selectAllProjects();

	// 根据id删除project
	@Delete("delete from project where pro_id=#{pro_id}")
	void delectProjectById(Integer pro_id);

	//
	// //更新project
	// @Update("update project set pro_name=#{pro_name},
	// pro_description=#{pro_description} where pro_id=#{pro_id} ")
	// void updateProject(Project project);
	//
	//
	// //插入Project
	// @Insert("insert int project(pro_name,pro_description) values
	// (#{pro_name},#{pro_description})")
	// @Options(useGeneratedKeys = true,keyProperty="pro_id")
	// void inserProject(Project project);
}
