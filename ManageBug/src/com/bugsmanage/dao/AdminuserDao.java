package com.bugsmanage.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.bugsmanage.pojo.Adminuser;


/**
* @Description:管理員dao
* @author 作者 :lixingyan
* @version 创建时间：2017年3月14日 下午6:54:21
*/
public interface AdminuserDao {
	
	// 根据id查询管理员用户
	@Select("select * from adminuser where ad_id = #{ad_id}")
	@Results({
		@Result(id=true,column="ad_id",property="ad_id"),
		@Result(column="ad_username",property="ad_username"),
		@Result(column="ad_password",property="ad_passsword")
	})
	Adminuser selectadminuserById(Integer ad_id);
	
	//根据管理员用户名进行查询
	@Select("select * from adminuser where ad_username = #{ad_username}")
	Adminuser selectadminuserByName(
			@Param("ad_username") String ad_username);
	
	//根据管理员进行更新操作
	@Update("update adminuser set ad_username=#{ad_username},ad_password=#{ad_password} where ad_id =#{ad_id}")
	void updateadminuser(Adminuser adminuser);
	
	// 根据id删除用户
	@Delete(" delete from adminuser where ad_id = #{ad_id } ")
	void deleteadminuserById(Integer id);
	
	//插入管理员用户
	@Insert(" insert into adminuser(ad_username,ad_password) values (#ad_username,#ad_password)")
	@Options(useGeneratedKeys=true,keyProperty="ad_id")
	void insertadminuser(Adminuser adminuser);
		
	
    //根据用户名和密码进行查询
	@Select("select count(*) from adminuser where ad_username=#{ad_username} and ad_password=#{ad_password}")
	Integer selectadminuserByLoginnameAndPassword(
			@Param("ad_username") String ad_username,@Param("ad_password") String ad_password);

}
