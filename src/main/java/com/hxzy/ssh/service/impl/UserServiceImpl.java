package com.hxzy.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.ssh.dao.UserDao;
import com.hxzy.ssh.entity.User;
import com.hxzy.ssh.service.UserService;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Resource(name = "userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		userDao.add(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);

	}

	@Override
	public List<User> findUserAll() {

		return userDao.findAll();
	}

	@Override
	public User findUserById(User user) {
		return userDao.findById(user);
	}

	@Override
	public User findUser(User user) {
		return userDao.find(user);
	}

}
