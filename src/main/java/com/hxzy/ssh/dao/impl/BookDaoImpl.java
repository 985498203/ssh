package com.hxzy.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import com.hxzy.ssh.entity.Book;
import com.hxzy.ssh.dao.BookDao;


@Component("bookDaoImpl")
public class BookDaoImpl implements BookDao {

	private SessionFactory sessionFactory;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加书籍信息
	 * 
	 * @return
	 */
	@Override
	public void add(Book book) {
		Session session = null;
		try {
			session = sessionFactory.openSession();// 打开session
			session.save(book);// 增加用户
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
	}

	/**
	 * 更新书籍信息
	 * 
	 * @return
	 */
	@Override
	public void update(Book book) {
		Session session = null;
		try {
			session = sessionFactory.openSession();// 打开session
			session.update(book);// 更新用户
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
	}

	/**
	 * 删除书籍信息
	 * 
	 * @return
	 */
	@Override
	public void delete(Book book) {
		Session session = null;
		try {
			session = sessionFactory.openSession();// 打开session
			session.delete(book);// 删除用户
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
	}

	/**
	 * 获取所有书籍信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		Session session = null;
		List<Book> bookList = null;
		try {
			bookList = new ArrayList<Book>();
			session = sessionFactory.openSession();// 打开session
			bookList = session.createQuery("from Book").list();// 得到所有用户集合
//			System.out.println("查询");
//			for (Book book : bookList) {
//				System.out.println(book);
//			}
//			System.out.println("查询成功");
//			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
		return bookList;
	}

	/**
	 * 通过id获取单个书籍信息
	 * 
	 * @return
	 */
	@Override
	public Book findById(Book book) {
		Session session = null;
		Book book2 = null;
		try {
			session = sessionFactory.openSession();// 打开session
			Query query = session.createQuery("from Book b where b.id =:id");// 得到Query对象
			query.setParameter("id",book.getId());
			book2 =(Book) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
		return book2;
	}

	@Override
	public Book find(Book t) {
		return null;
	}


}
