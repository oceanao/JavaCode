package com.bugsmanage.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.bugsmanage.pojo.User;

/**
 * @Description:用户动态SQL语句提供类
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月14日 下午8:08:57
 */
public class UserDynaSqlProvider {

	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT(" * ");
				FROM(" user ");
				if (params.get("user") != null) {
					User user = (User) params.get("user");
					if (user.getStudent_num() != null && !user.getStudent_num().equals("")) {
						WHERE("  student_num LIKE CONCAT ('%',#{user.student_num},'%') ");
					}
					if (user.getUsername() != null && !user.getUsername().equals("")) {
						WHERE("  username LIKE CONCAT ('%',#{user.username},'%') ");
					}
					if (user.getRole() != null && user.getRole() != 0) {
						WHERE(" role = #{user.role} ");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		return sql;
	}

	// 动态查询总数量
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT(" count(*) ");
				FROM(" user ");
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getStudent_num()!= null && !user.getStudent_num().equals("")){
						WHERE(" student_num LIKE CONCAT ('%',#{user.student_num},'%') ");
					}
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE(" username LIKE CONCAT ('%',#{user.username},'%') ");
					}
					if(user.getRole() != null && user.getRole()!=0){
						WHERE(" role=#{user.role} ");
				    }
				}
			}
		}.toString();
	}

	
	// 动态插入
	public String insertUser(User user) {

		return new SQL() {
			{
				INSERT_INTO(" user ");
				if (user.getStudent_num() != null && !user.getStudent_num().equals("")) {
					VALUES("student_num", "#{student_num}");
				}
				if (user.getUsername() != null && !user.getUsername().equals("")) {
					VALUES("username", "#{username}");
				}
				if (user.getPassword() != null && !user.getPassword().equals("")) {
					VALUES("password", "#{password}");
				}
				if (user.getRole() != null && !user.getRole().equals("")) {
					VALUES("role", "#{role}");
				}
				if (user.getRegister_time() != null && !user.getRegister_time().equals("")) {
					VALUES("register_time", "#{register_time}");
				}

			}
		}.toString();
	}

	// 动态更新
	public String updateUser(User user) {

		return new SQL() {
			{
				UPDATE(" user ");
				if (user.getStudent_num() != null) {
					SET(" student_num = #{student_num} ");
				}
				if (user.getUsername() != null) {
					SET(" username = #{username} ");
				}
				if (user.getPassword() != null) {
					SET(" password = #{password} ");
				}
				if (user.getRole() != null) {
					SET(" role = #{role} ");
				}
				if (user.getRegister_time() != null) {
					SET(" register_time = #{register_time} ");
				}
				WHERE(" user_id = #{ user_id} ");
			}
		}.toString();
	}
}
