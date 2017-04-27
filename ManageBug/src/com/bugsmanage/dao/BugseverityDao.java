package com.bugsmanage.dao;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bugsmanage.pojo.Bugseverity;
/**
* @Description:BugseverityDao
* @author 作者 :lixingyan
* @version 创建时间：2017年3月15日 下午4:47:56
*/



public interface BugseverityDao {
	
	//根据id 进行查询bugseverity
	@Select("select * from bugseverity where bugseverity_id= #{bugseverity_id}")
	@Results({
		@Result(id = true, column = "bugseverity_id", property = "bugseverity_id"),
		@Result(column = "severity", property = "severity"),
		@Result(column = "remark", property = "remark")
	})
	Bugseverity selectBugseverityById(Integer bugseverity_id);
	
	//根据severity 进行查询bugseverity
	@Select("select count(*) from bugseverity where severity= #{severity}")
	Integer  selectBugseverityBySeverity(@Param("severity") String severity);
	
	//查询所有bugseverity
	@Select("select * from bugseverity ")
	@Results({
		@Result(id = true, column = "bugseverity_id", property = "bugseverity_id"),
		@Result(column = "severity", property = "severity"),
		@Result(column = "remark", property = "remark")
	})
	List<Bugseverity> selectAllBugseverity();
	
	//修改 bugseverity
	@Update("update bugseverity set severity=#{severity} , remark=#{remark}  where bugseverity_id=#{bugseverity_id}")
     void updateBugseverity(Bugseverity bugseverity);
	
	//删除
	@Delete("delete from bugseverity where bugseverity_id=#{bugseverity_id}")
	void delectBugseverity(Integer bugseverity_id);
	
	//插入
	@Insert("insert into bugseverity(severity,remark) values (#{severity},#{remark})")
	@Options(useGeneratedKeys = true,keyProperty="bugseverity_id")
	void insertBugseverity(Bugseverity bugseverity);
	
	
}
