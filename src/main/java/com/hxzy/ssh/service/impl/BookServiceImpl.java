package com.hxzy.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.ssh.dao.BookDao;
import com.hxzy.ssh.entity.Book;
import com.hxzy.ssh.service.BookService;


@Component("bookServiceImpl")
public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	@Resource(name = "bookDaoImpl")
	public void setUserDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void addBook(Book book) {
		bookDao.add(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.update(book);
	}

	@Override
	public void deleteBook(Book book) {
		bookDao.delete(book);

	}

	@Override
	public List<Book> findBookAll() {

		return bookDao.findAll();
	}

	@Override
	public Book findBookById(Book book) {
		return bookDao.findById(book);
	}
}
