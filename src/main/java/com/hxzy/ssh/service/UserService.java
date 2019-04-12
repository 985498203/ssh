package com.hxzy.ssh.service;

import java.util.List;

import com.hxzy.ssh.entity.User;

public interface UserService {

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 删除用户信息
	 * 
	 * @param user
	 */
	public void deleteUser(User user);

	/**
	 * 获取所有用户信息
	 * 
	 * @param user
	 * @return
	 */
	public List<User> findUserAll();

	/**
	 * 通过id获取单个用户信息
	 * 
	 * @param user
	 * @return
	 */
	public User findUserById(User user);
	/**
	 * 获取单个用户信息
	 * 
	 * @param user
	 * @return
	 */
	public User findUser(User user);
}
