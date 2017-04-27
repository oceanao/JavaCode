package com.bugsmanage.service;

import java.util.List;
import com.bugsmanage.pojo.User;
import com.bugsmanage.util.tag.PageModel;

/**
* @Description:
* @author 作者 :lixingyan
* @version 创建时间：2017年3月14日 下午9:42:35
*/
public interface UserService {
	
	//根据学号查询用户个数
	Integer countUserByStudent_Num(String student_num);
	
	//根据学号查找用户
	User getUserByStudent_Num(String student_num);
	
	/**
	 * 根据id删除用户
	 * @param  user_id
	 * @param 
	 * @return 
	 * */
	void deleteUser(Integer user_id);
	
	
	
	
	/**
	 * 根据id查找用户
	 * @param  user_id
	 * @param 
	 * @return 
	 * */
	User findUserById(Integer user_id);
	
	
	/**
	 * 用户登录
	 * @param  student_num
	 * @param  password
	 * @return user对象
	 * */
	Integer login(String student_num, String password);
	
	
	/**
	 * 添加用户
	 * @param  user对象
	 * */
	void addUser(User user);
	
	
	/**
	 * 修改用户
	 * @param  user对象
	 * */
	void modifyUser(User user);
	
	/**分页查询
	 * 获得所有用户
	 * @return User对象的List集合
	 * */
	List<User> findUser(User user,PageModel pageModel);
	
	
	
	//查询所有的用户
	List<User> findAllUser();
	
	
}
