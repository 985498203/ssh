package com.hxzy.ssh.dao;

import java.util.List;

public interface BaseDao<T> {
	public void add(T t);
	public void update(T t);
	public void delete(T t);
	public List<T> findAll();
	public T findById(T t);
	public T find(T t);
}
