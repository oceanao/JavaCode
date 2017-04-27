package com.bugsmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bugsmanage.dao.BugseverityDao;
import com.bugsmanage.pojo.Bugseverity;
import com.bugsmanage.service.BugseverityService;

/**
* @Description:BugseverityService实现
* @author 作者 :lixingyan
* @version 创建时间：2017年3月15日 下午5:28:48
*/
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("bugseverityService")
public class BugseverityServiceImpl  implements BugseverityService {
	@Autowired
	private BugseverityDao bugseverityDao;

	//添加Bugseverity实现
	@Override
	public void addBugseverity(Bugseverity bugseverity) {

		this.bugseverityDao.insertBugseverity(bugseverity);
	}

	//删除Bugseverity实现
	@Override
	public void delectBugseverity(Integer bugseverity_id) {

		this.bugseverityDao.delectBugseverity(bugseverity_id);
	}

	//修改Bugseverity实现
	@Override
	public void modifyBugseverity(Bugseverity bugseverity) {

		this.bugseverityDao.updateBugseverity(bugseverity);
	}

	//根据bugseverity_id查询实现
	@Transactional(readOnly=true)
	@Override
	public Bugseverity selectBugseverityById(Integer bugseverity_id) {

		return this.bugseverityDao.selectBugseverityById(bugseverity_id);
	}

	//查询所有Bugseverity实现
	@Transactional(readOnly=true)
	@Override
	public List<Bugseverity> selectAllBugseverity() {

		return this.bugseverityDao.selectAllBugseverity();
	}

	//根据severity进行查询个数
	@Transactional(readOnly=true)
	@Override
	public Integer countBugseverityBySeverity(String severity) {
		
		return this.bugseverityDao.selectBugseverityBySeverity(severity);
	}

}
