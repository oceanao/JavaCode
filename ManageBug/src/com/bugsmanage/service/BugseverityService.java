package com.bugsmanage.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bugsmanage.pojo.Bugseverity;

/**
* @Description:BugseverityService
* @author 作者 :lixingyan
* @version 创建时间：2017年3月15日 下午5:28:06
*/
public interface BugseverityService {

	//添加Bugseverity
	void addBugseverity(Bugseverity bugseverity);
	
	//删除Bugseverity
	void delectBugseverity(Integer bugseverity_id);
	
	//修改Bugseverity
	void modifyBugseverity(Bugseverity bugseverity);
	
	//根据bugseverity_id查询
	Bugseverity selectBugseverityById(Integer bugseverity_id);
	
	//根据severity进行查询个数
	Integer  countBugseverityBySeverity( String severity);
	
	//查询所有Bugseverity
	List<Bugseverity> selectAllBugseverity();
	
}
