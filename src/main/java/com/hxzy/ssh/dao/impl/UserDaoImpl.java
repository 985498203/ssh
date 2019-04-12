package com.hxzy.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.hxzy.ssh.dao.UserDao;
import com.hxzy.ssh.entity.User;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加用户信息
	 * 
	 * @return
	 */
	@Override
	public void add(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();// 打开session
			session.save(user);// 增加用户
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
	}

	/**
	 * 更新用户信息
	 * 
	 * @return
	 */
	@Override
	public void update(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();// 打开session
			session.update(user);// 更新用户
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
	}

	/**
	 * 删除用户信息
	 * 
	 * @return
	 */
	@Override
	public void delete(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();// 打开session
			session.delete(user);// 删除用户
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
	}

	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Session session = null;
		List<User> userList = null;
		try {
			userList = new ArrayList<User>();
			session = sessionFactory.openSession();// 打开session
			userList = session.createQuery("from User").list();// 得到所有用户集合
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
		return userList;
	}

	/**
	 * 通过id获取单个用户信息
	 * 
	 * @return
	 */
	@Override
	public User findById(User user) {
		Session session = null;
		User user2 = null;
		try {
			session = sessionFactory.openSession();// 打开session
			Query query = session.createQuery("from User u where u.id =:id");// 得到Query对象
			query.setParameter("id",user.getId());
			user2 =(User) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
		return user2;
	}

	@Override
	public User find(User user) {
		Session session = null;
		User user2 = null;
		try {
			session = sessionFactory.openSession();// 打开session
			Query query = session.createQuery("from User u where u.username = :username and u.password = :password");// 得到Query对象
			query.setString("username",user.getUsername());
			query.setString("password",user.getPassword());
			user2 =(User) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
		return user2;
	}

}
