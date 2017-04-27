package com.bugsmanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bugsmanage.dao.AdminuserDao;
import com.bugsmanage.pojo.Adminuser;
import com.bugsmanage.service.AdminUserService;


/**
* @Description:adminUserService实现类
* @author 作者 :lixingyan
* @version 创建时间：2017年3月14日 下午8:45:04
*/


@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
	
	@Autowired
	private AdminuserDao adminuaserDao;

	/**
	 * 用户登录实现
	 * @param  ad_username
	 * @param  ad_password
	 * @return Adminuser对象
	 * */
	@Transactional(readOnly=true)
	@Override
	public Integer login(String ad_username, String ad_password) {
		System.out.println("adminUserService login -->>");
		return this.adminuaserDao.selectadminuserByLoginnameAndPassword(ad_username, ad_password);
	}

	/**
	 * 修改管理员登录信息实现
	 * @param  adminuser
	 * */
	@Transactional(readOnly=true)
	@Override
	public void modifyAdminUserInfo(Adminuser adminuser) {
	
		System.out.println("adminUserService modifyAdminUserInfo -->>");
		this.adminuaserDao.updateadminuser(adminuser);
	}
	
	/**
	 * 根据用户名查询管理员实现
	 * @param  ad_username
	 * @param  
	 * @return Adminuser对象
	 * */
	@Transactional(readOnly=true)
	@Override
	public Adminuser getAdminUserByName(String ad_username) {
		System.out.println("adminUserService getAdminUserByName -->>");
		return this.adminuaserDao.selectadminuserByName(ad_username);
	}

	/**
	 * 插入管理员实现
	 * @param  adminuser
	 * */
	@Transactional(readOnly=true)
	@Override
	public void insertAdminuser(Adminuser adminuser) {
		System.out.println("adminUserService insertAdminuser -->>");
		this.adminuaserDao.insertadminuser(adminuser);
		
	}
}
