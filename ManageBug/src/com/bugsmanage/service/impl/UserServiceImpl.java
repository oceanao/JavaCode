package com.bugsmanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bugsmanage.dao.UserDao;
import com.bugsmanage.pojo.User;
import com.bugsmanage.service.UserService;
import com.bugsmanage.util.tag.PageModel;

/**
 * @Description:userservice实现
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月14日 下午9:43:33
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 用户登录实现
	 * 
	 * @param student_num
	 * @param ad_password
	 * @return Adminuser对象
	 */
	@Transactional(readOnly = true)
	@Override
	public Integer login(String student_num, String password) {

		return this.userDao.selectuserByLoginnameAndPassword(student_num, password);
	}

	// 添加用户操作实现
	@Override
	public void addUser(User user) {

		this.userDao.insertUser(user);
	}

	// 修改用户操作实现
	@Override
	public void modifyUser(User user) {

		this.userDao.updateUser(user);
	}

	/**
	 * 根据id删除用户实现
	 * 
	 * @param user_id
	 * @param
	 * @return
	 */
	@Override
	public void deleteUser(Integer user_id) {

		this.userDao.deleteUserById(user_id);
	}

	// 通过学号查找用户个数
	@Transactional(readOnly = true)
	@Override
	public Integer countUserByStudent_Num(String student_num) {
		// TODO Auto-generated method stub
		return this.userDao.countBystudent_Num(student_num);
	}

	// 获取所有用户
	@Transactional(readOnly = true)
	@Override
	public List<User> findUser(User user, PageModel pageModel) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("user", user);
		int recordCount = userDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			/** 开始分页查询数据：查询第几页的数据 */
			params.put("pageModel", pageModel);
		}
		List<User> users = userDao.selectUserByPage(params);

		return users;
	}

	// 根据id查找用户
	@Transactional(readOnly = true)
	@Override
	public User findUserById(Integer user_id) {
		// TODO Auto-generated method stub
		return this.userDao.selectBystudentId(user_id);
	}

	//查询所有用户
	@Transactional(readOnly = true)
	@Override
	public List<User> findAllUser() {
		
		return this.userDao.selectAllUsers();
	}

	//根据学号查询用户
	@Transactional(readOnly = true)
	@Override
	public User getUserByStudent_Num(String student_num) {
		return this.userDao.getUserBystudent_Num(student_num);
	}

}
