package com.ssm.service;

import java.util.List;

import com.ssm.domain.User;

/**
 * IUserService
 * @author lmn
 * @since  2016年12月12日 下午3:22:03
 */
public interface IUserService {

	/**
	 * 查询
	 * @return
	 * @author lmn
	 * @since  2016年12月12日 下午4:32:51
	 */
	public List<User> queryUsers();
	
	/**
	 * 插入
	 * @param user
	 * @return
	 * @author lmn
	 * @since  2016年12月13日 上午10:25:28
	 */
	public int insert(User user);
}
