package com.ssm.dao;

import java.util.List;

import com.ssm.domain.User;
/**
 * UserDao
 * @author lmn
 * @since  2016年12月13日 上午10:39:50
 */
public interface UserDao {
	
	/**
	 * 查询
	 * @return
	 * @author lmn
	 * @since  2016年12月12日 下午4:28:50
	 */
	public List<User> queryUsers();
	
	/**
	 * 插入
	 * @param user
	 * @return
	 * @author lmn
	 * @since  2016年12月13日 上午10:24:54
	 */
	public int insert(User user);
}
