package com.bugsmanage.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.bugsmanage.pojo.Bug;
import com.bugsmanage.util.tag.PageModel;

/**
* @Description:
* @author 作者 :lixingyan
* @version 创建时间：2017年3月20日 下午3:56:07
*/
public interface BugService {

	//分页查询
	List<Bug> findBug(Bug bug, PageModel pageModel);
	
	//添加后查询
	Bug selectBugByAdd(Bug bug);

	//根据bug_id查询
	Bug selectBugById(Integer bug_id);
	
	//添加bug
	void addBug(Bug bug);
	
	//删除bug
	void deleteBug(Integer bug_id);
	
	//修改bugs
	
	void modifyBug(Bug bug);
	
	//统计
	Integer countbug(Bug bug);
	
//	List<Bug> selectBugByPro(Integer pro_id);
	
//	Integer countByP(Integer pro_id);

	//模糊不分页查询
	List<Bug> selectBug(Bug bug);
	
	//excel
	HSSFWorkbook SetToExcel(Bug bug);
}
