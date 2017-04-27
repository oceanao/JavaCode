package com.bugsmanage.service;

import java.util.List;

import com.bugsmanage.pojo.Bugfile;

/**
* @Description:
* @author 作者 :lixingyan
* @version 创建时间：2017年3月28日 上午8:42:01
*/
public interface BugfileService {
	
	//批量插入
	void addBugfilelist(List<Bugfile> files);
	
	//删除
	void deleteBugfile(Integer bugfile_id);
	
	//单个附件插入
	void  addBugfile(Bugfile file);
	
	//根据bug_id查询
	List<Bugfile> selectBugfileByBugId(Integer bug_id);

}
