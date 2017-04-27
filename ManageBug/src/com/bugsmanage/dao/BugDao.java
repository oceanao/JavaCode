package com.bugsmanage.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.mapping.FetchType;
import com.bugsmanage.dao.provider.BugsDynaSqlProvider;
import com.bugsmanage.pojo.Bug;

/**
 * @Description:
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月20日 下午3:55:37
 */
public interface BugDao {

	// 根据bug_id查询
	@Select("select * from bug where bug_id=#{bug_id}")
	@Results({ @Result(id = true, column = "bug_id", property = "bug_id"),
			@Result(column = "summary", property = "summary"),
			
			@Result(column = "bugseverity_id", property = "bugseverity",
			one = @One(select = "com.bugsmanage.dao.BugseverityDao.selectBugseverityById",
			fetchType = FetchType.EAGER)),
			
			@Result(column = "bug_status", property = "bug_status"),
			
			@Result(column = "reporter_id", property = "reporter",
			one = @One(select = "com.bugsmanage.dao.UserDao.selectBystudentId",
			fetchType = FetchType.EAGER)),
			
			@Result(column = "pro_id", property = "project", 
			one = @One(select = "com.bugsmanage.dao.ProjectDao.selectProjectById", 
			fetchType = FetchType.EAGER)),
			
			@Result(column = "handler_id", property = "handler", 
			one = @One(select = "com.bugsmanage.dao.UserDao.selectBystudentId", 
			fetchType = FetchType.EAGER)),
			
			@Result(column = "bug_comment", property = "bug_comment"),
			@Result(column = "bug_result", property = "bug_result"), 
			@Result(column = "bug_os", property = "bug_os"),
			@Result(column = "bug_description", property = "bug_description"),
			@Result(column = "submite_time", property = "submite_time", javaType = java.util.Date.class) ,
	
	})
	Bug selectBugsById(Integer bug_id);
	
	//根据bug_id删除bug
	@Delete("delete from bug where bug_id=#{bug_id}")
	void deletebug(Integer bug_id);

	//根据pro_id进行查找
	@Select("select * from bug where pro_id=#{pro_id}")
	@Results({ @Result(id = true, column = "bug_id", property = "bug_id"),
		@Result(column = "summary", property = "summary"),
		@Result(column = "bugseverity_id", property = "bugseverity", one = @One(select = "com.bugsmanage.dao.BugseverityDao.selectBugseverityById", fetchType = FetchType.EAGER)),
		@Result(column = "bug_status", property = "bug_status"),
		@Result(column = "reporter_id", property = "reporter", one = @One(select = "com.bugsmanage.dao.UserDao.selectBystudentId", fetchType = FetchType.EAGER)),
		@Result(column = "pro_id", property = "project", one = @One(select = "com.bugsmanage.dao.ProjectDao.selectProjectById", fetchType = FetchType.EAGER)),
		@Result(column = "handler_id", property = "handler", one = @One(select = "com.bugsmanage.dao.UserDao.selectBystudentId", fetchType = FetchType.EAGER)),
		@Result(column = "bug_comment", property = "bug_comment"),
		@Result(column = "bug_result", property = "bug_result"), @Result(column = "bug_os", property = "bug_os"),
		@Result(column = "bug_description", property = "bug_description"),
		@Result(column = "submite_time", property = "submite_time", javaType = java.util.Date.class) ,
		 })
	List<Bug> selectBugByPro(Integer pro_id);
	
	// 查询所有Bugs
	@Select("select * from bug")
	@Results({ @Result(id = true, column = "bug_id", property = "bug_id"),
			@Result(column = "summary", property = "summary"),
			@Result(column = "bugseverity_id", property = "bugseverity", one = @One(select = "com.bugsmanage.dao.BugseverityDao.selectBugseverityById", fetchType = FetchType.EAGER)),
			@Result(column = "bug_status", property = "bug_status"),
			@Result(column = "reporter_id", property = "reporter", one = @One(select = "com.bugsmanage.dao.UserDao.selectBystudentId", fetchType = FetchType.EAGER)),
			@Result(column = "pro_id", property = "project", one = @One(select = "com.bugsmanage.dao.ProjectDao.selectProjectById", fetchType = FetchType.EAGER)),
			@Result(column = "handler_id", property = "handler", one = @One(select = "com.bugsmanage.dao.UserDao.selectBystudentId", fetchType = FetchType.EAGER)),
			@Result(column = "bug_comment", property = "bug_comment"),
			@Result(column = "bug_result", property = "bug_result"), @Result(column = "bug_os", property = "bug_os"),
			@Result(column = "bug_description", property = "bug_description"),
			@Result(column = "submite_time", property = "submite_time", javaType = java.util.Date.class),
			 })
	List<Bug> selectAllBug();

	
	
	// 动态查询
	@SelectProvider(type = BugsDynaSqlProvider.class, method = "selectWhitParam")
	@Results({ @Result(id = true, column = "bug_id", property = "bug_id"),
			@Result(column = "summary", property = "summary"),
			@Result(column = "bugseverity_id", property = "bugseverity", one = @One(select = "com.bugsmanage.dao.BugseverityDao.selectBugseverityById", fetchType = FetchType.EAGER)),
			@Result(column = "bug_status", property = "bug_status"),
			@Result(column = "reporter_id", property = "reporter", one = @One(select = "com.bugsmanage.dao.UserDao.selectBystudentId", fetchType = FetchType.EAGER)),
			@Result(column = "pro_id", property = "project", one = @One(select = "com.bugsmanage.dao.ProjectDao.selectProjectById", fetchType = FetchType.EAGER)),
			@Result(column = "handler_id", property = "handler", one = @One(select = "com.bugsmanage.dao.UserDao.selectBystudentId", fetchType = FetchType.EAGER)),
			@Result(column = "bug_comment", property = "bug_comment"),
			@Result(column = "bug_result", property = "bug_result"), @Result(column = "bug_os", property = "bug_os"),
			@Result(column = "bug_description", property = "bug_description"),
			@Result(column = "submite_time", property = "submite_time", javaType = java.util.Date.class) ,
			 })
	List<Bug> selectByPage(Map<String, Object> params);

	//根据pro_id进行查询
	@Select("select count(*) from bug where pro_id =#{pro_id}")
	Integer countByPro(Integer pro_id);
	
	//添加查找,返回一个bug
	@SelectProvider(type = BugsDynaSqlProvider.class, method = "selectWhitParam")
	Bug selectBugByAdd(Map<String, Object> params);
	
	
	
	// 动态插入bug
	@InsertProvider(type = BugsDynaSqlProvider.class, method = "insertBug")
	@Options(useGeneratedKeys=true,keyProperty="bug_id")
	void addBug(Bug bug);

	// 动态修改员Bug
	@UpdateProvider(type = BugsDynaSqlProvider.class, method = "updateBug")
	void update(Bug bug);

	// 根据参数查询Bug总数
	@SelectProvider(type = BugsDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);
}
