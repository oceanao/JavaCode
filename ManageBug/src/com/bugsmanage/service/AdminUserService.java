package com.bugsmanage.service;

import com.bugsmanage.pojo.Adminuser;

/**
 * @Description:AdminUser service接口
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月14日 下午8:44:22
 */
public interface AdminUserService {

	/**
	 * 用户登录
	 * 
	 * @param ad_username
	 * @param ad_password
	 * @return Adminuser对象
	 */
	Integer login(String ad_username, String ad_password);

	/**
	 * 修改管理员登录信息
	 * 
	 * @param adminuser
	 */
	public void modifyAdminUserInfo(Adminuser adminuser);

	/**
	 * 根据用户名查询管理员
	 * 
	 * @param ad_username
	 * @param
	 * @return Adminuser对象
	 */
	Adminuser getAdminUserByName(String ad_username);

	/**
	 * 插入管理员
	 * 
	 * @param adminuser
	 */
	public void insertAdminuser(Adminuser adminuser);
}
