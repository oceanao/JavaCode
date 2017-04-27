package com.bugsmanage.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.bugsmanage.pojo.Bug;

/**
 * @Description:
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月19日 上午10:25:23
 */
public class BugsDynaSqlProvider {

	// 动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT(" * ");
				FROM(" bug ");
				if (params.get("bug") != null) {
					Bug bug = (Bug) params.get("bug");
					// bug题目
					if (bug.getSummary() != null && !bug.getSummary().equals("")) {
						WHERE(" summary LIKE CONCAT ('%',#{bug.summary},'%') ");
					}
					// bug优先级
					if (bug.getBugseverity() != null && bug.getBugseverity().getBugseverity_id() != null
							&& bug.getBugseverity().getBugseverity_id() != 0) {
						WHERE(" bugseverity_id = #{bug.bugseverity.bugseverity_id} ");
					}
					// bug状态
					if (bug.getBug_status() != null && bug.getBug_status() != 0) {
						WHERE(" bug_status = #{bug.bug_status} ");
					}
					// 提交人
					if (bug.getReporter() != null && bug.getReporter().getUser_id() != null
							&& bug.getReporter().getUser_id() != 0) {
						WHERE(" reporter_id = #{bug.reporter.user_id} ");
					}
					// 项目查询
					if (bug.getProject() != null && bug.getProject().getPro_id() != null
							&& bug.getProject().getPro_id() != 0) {
						WHERE(" pro_id = #{bug.project.pro_id} ");
					}
					// 复现人
					if (bug.getHandler() != null && bug.getHandler().getUser_id() != null
							&& bug.getHandler().getUser_id() != 0) {
						WHERE(" handler_id = #{bug.handler.user_id} ");
					}
					// 复现结果
					if (bug.getBug_result() != null && (bug.getBug_result() != 0)) {
						WHERE("  bug_result LIKE CONCAT ('%',#{bug.bug_result},'%') ");
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
				SELECT("count(*)");
				FROM("bug");
				if (params.get("bug") != null) {
					Bug bug = (Bug) params.get("bug");
					// bug题目
					if (bug.getSummary() != null && !bug.getSummary().equals("")) {
						WHERE(" summary LIKE CONCAT ('%',#{bug.summary},'%') ");
					}
					// bug优先级
					if (bug.getBugseverity() != null && bug.getBugseverity().getBugseverity_id() != null
							&& bug.getBugseverity().getBugseverity_id() != 0) {
						WHERE(" bugseverity_id = #{bug.bugseverity.bugseverity_id} ");
					}
					// bug状态
					if (bug.getBug_status() != null && bug.getBug_status() != 0) {
						WHERE(" bug_status = #{bug.bug_status} ");
					}
					// 提交人
					if (bug.getReporter() != null && bug.getReporter().getUser_id() != null
							&& bug.getReporter().getUser_id() != 0) {
						WHERE(" reporter_id = #{bug.reporter.user_id} ");
					}
					// 项目查询
					if (bug.getProject() != null && bug.getProject().getPro_id() != null && bug.getProject().getPro_id() != 0) {
						WHERE(" pro_id = #{bug.project.pro_id} ");
					}
					// 复现人
					if (bug.getHandler() != null && bug.getHandler().getUser_id() != null
							&& bug.getHandler().getUser_id() != 0) {
						WHERE(" handler_id = #{bug.handler.user_id} ");
					}
					// 复现结果
					if (bug.getBug_result() != null && bug.getBug_result() != 0) {
						WHERE("  bug_result LIKE CONCAT ('%',#{bug.bug_result},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertBug(Bug bug) {

		return new SQL() {
			{
				INSERT_INTO("bug");
				if (bug.getSummary() != null) {
					VALUES("summary", "#{summary}");
				}
				if (bug.getBugseverity() != null) {
					VALUES("bugseverity_id", "#{bugseverity.bugseverity_id}");
				}
				if (bug.getBug_status() != null) {
					VALUES("bug_status", "#{bug_status}");
				}
				if (bug.getReporter() != null) {
					VALUES("reporter_id", "#{reporter.user_id}");
				}
				if (bug.getProject() != null) {
					VALUES("pro_id", "#{project.pro_id}");
				}
				if (bug.getHandler() != null) {
					VALUES("handler_id", "#{handler.user_id}");
				}
				if (bug.getBug_comment() != null) {
					VALUES("bug_comment", "#{bug_comment}");
				}
				if (bug.getBug_result() != null) {
					VALUES("bug_result", "#{bug_result}");
				}

				if (bug.getBug_os() != null) {
					VALUES("bug_os", "#{bug_os}");
				}
				if (bug.getBug_description() != null) {
					VALUES("bug_description", "#{bug_description}");
				}
				if (bug.getSubmite_time() != null) {
					VALUES("submite_time", "#{submite_time}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateBug(Bug bug) {

		return new SQL() {
			{
				UPDATE("bug");
				if (bug.getSummary() != null) {
					SET(" summary = #{summary} ");
				}
				if (bug.getBugseverity() != null) {
					SET(" bugseverity_id = #{bugseverity.bugseverity_id} ");
				}
				if (bug.getBug_status() != null) {
					SET(" bug_status = #{bug_status} ");
				}
				if (bug.getReporter() != null) {
					SET(" reporter_id = #{reporter.user_id} ");
				}
				if (bug.getProject() != null) {
					SET(" pro_id = #{project.pro_id} ");
				}
				if (bug.getHandler() != null) {
					SET(" handler_id = #{handler.user_id} ");
				}
				if (bug.getBug_comment() != null) {
					SET(" bug_comment = #{bug_comment} ");
				}
				if (bug.getBug_result() != null) {
					SET(" bug_result = #{bug_result} ");
				}
				if (bug.getBug_os() != null) {
					SET(" bug_os = #{bug_os} ");
				}
				if (bug.getBug_description() != null) {
					SET(" bug_description = #{bug_description} ");
				}
				if (bug.getSubmite_time() != null) {
					SET(" submite_time = #{submite_time} ");
				}
				WHERE("bug_id = #{bug_id} ");
			}
		}.toString();
	}

}
