package com.bugsmanage.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.bugsmanage.pojo.Project;

/**
 * @Description:
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月19日 下午10:14:06
 */
public class ProjectDynaSqlProvider {

	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT(" * ");
				FROM(" project ");
				if (params.get("project") != null) {
					Project project = (Project) params.get("project");
					if (project.getPro_name() != null && !project.getPro_name().equals("")) {
						WHERE("  pro_name LIKE CONCAT ('%',#{project.pro_name},'%') ");
					}
				}
			}
		}.toString();

		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}

		return sql;
	}

	// 动态查询总数量
	public String count(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT(" count(*) ");
				FROM(" project ");
				if (params.get("project") != null) {
					Project project = (Project) params.get("project");
					if (project.getPro_name() != null && !project.getPro_name().equals("")) {
						WHERE("  pro_name LIKE CONCAT ('%',#{project.pro_name},'%') ");
					}
				}
			}
		}.toString();
	}

	
	// 动态插入
	public String insertProject(Project project) {

		return new SQL() {
			{
				INSERT_INTO(" project ");
				if (project.getPro_name() != null && !project.getPro_name().equals("")) {
					VALUES("pro_name", "#{pro_name}");
				}
				if (project.getPro_description() != null && !project.getPro_description().equals("")) {
					VALUES("pro_description", "#{pro_description}");
				}
				if (project.getPro_version() != null && !project.getPro_version().equals("")) {
					VALUES("pro_version", "#{pro_version}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateProject(Project project) {

		return new SQL() {
			{
				UPDATE(" project ");
				if (project.getPro_name() != null) {
					SET(" pro_name = #{pro_name} ");
				}
				if (project.getPro_description() != null) {
					SET(" pro_description = #{pro_description} ");
				}
				if (project.getPro_version() != null) {
					SET(" pro_version = #{pro_version} ");
				}
				WHERE(" pro_id = #{pro_id} ");
			}
		}.toString();
	}
}
