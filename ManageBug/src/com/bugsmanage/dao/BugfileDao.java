package com.bugsmanage.dao;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bugsmanage.pojo.Bugfile;

/**
* @Description:
* @author 作者 :lixingyan
* @version 创建时间：2017年3月21日 上午11:28:09
*/

public interface BugfileDao {

	//根据bugs_id查询所有的bugfile文件
	@Select("select * from bugfile where bug_id = #{bug_id}")
	@Results({
		@Result(id=true,column="bugfile_id",property="bugfile_id"),
		@Result(column="filename",property="filename"),
		@Result(column="creat_time",property="creat_time",javaType = java.util.Date.class)
	})
	List<Bugfile> selectbugfileByBugId(@Param("bug_id") Integer bug_id);
	
	//根据bugfile_id查询
	@Select("select * from bugfile where bugfile_id=#{bugfile_id}")
	Bugfile selectbugfileById(Integer bugfile_id);
	
	//查询所有的bugfile
	@Select("select * from bugfile")
	List<Bugfile> selectAllBugFile();
	
	//删除
	@Delete(" delete from bugfile where bugfile_id = #{bugfile_id} ")
	void deletefileById(Integer bugfile_id);
	
	//插入
	@Insert("insert into bugfile(filename,bug_id) values (#{filename},#{bug_id})")
	@Options(useGeneratedKeys=true,keyProperty="bugfile_id")
	void insertfile(Bugfile  bugfile);


}
