package com.hxzy.ssh.service;

import java.util.List;

import com.hxzy.ssh.entity.Book;

public interface BookService {

	/**
	 * 添加书籍信息
	 * 
	 * @return
	 */
	public void addBook(Book book);

	/**
	 * 更新书籍信息
	 * 
	 * @return
	 */
	public void updateBook(Book book);

	/**
	 * 删除书籍信息
	 * 
	 * @return
	 */
	public void deleteBook(Book book);

	/**
	 * 获取所有书籍信息
	 * 
	 * @return
	 */
	public List<Book> findBookAll();

	/**
	 * 通过id获取单个书籍信息
	 * 
	 * @return
	 */
	public Book findBookById(Book book);
}
