package com.bugsmanage.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bugsmanage.dao.BugfileDao;
import com.bugsmanage.pojo.Bugfile;
import com.bugsmanage.service.BugfileService;

/**
* @Description:
* @author 作者 :lixingyan
* @version 创建时间：2017年3月28日 上午8:47:27
*/
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("bugfileService")
public class BugfileServiceImpl implements  BugfileService{

	@Autowired
	private BugfileDao bugfileDao;
	
	@Override
	public void addBugfilelist(List<Bugfile> files) {
	      for (Iterator<Bugfile> iterator =files.iterator(); iterator.hasNext();)
	       {
	        System.out.println("List集合结果为:"+iterator.next().toString());
	        this.bugfileDao.insertfile(iterator.next());
	       }		
	}
	
	@Override
	public void deleteBugfile(Integer bugfile_id) {
		this.bugfileDao.deletefileById(bugfile_id);		
	}

	@Override
	public void addBugfile(Bugfile file) {
		this.bugfileDao.insertfile(file);
		
	}

	@Transactional(readOnly=true)
	@Override
	public List<Bugfile> selectBugfileByBugId(Integer bug_id) {
		return this.bugfileDao.selectbugfileByBugId(bug_id);
	}

}
