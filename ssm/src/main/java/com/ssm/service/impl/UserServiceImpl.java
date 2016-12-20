package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.UserDao;
import com.ssm.domain.User;
import com.ssm.service.IUserService;
/**
 * UserServiceImpl
 * @author lmn
 * @since  2016年12月12日 下午3:21:43
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> queryUsers() {
		return userDao.queryUsers();
	}
	
	@Transactional
	public int insert(User user) {
		//测试事物
/*		int i = 0;
		System.out.println(1/i);*/
		return userDao.insert(user);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
