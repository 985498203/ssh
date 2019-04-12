package com.hxzy.ssh.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.ssh.entity.Book;
import com.hxzy.ssh.entity.User;
import com.hxzy.ssh.service.BookService;
import com.hxzy.ssh.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	private BookService bookService;

	@Resource(name = "bookServiceImpl")
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Resource(name = "userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("index")
	public ModelAndView index(ModelAndView mav, HttpSession session) {
		System.out.println("index");

		String username = (String) session.getAttribute("username");

		if (null != username) {
			System.out.println("session中有username");
			List<Book> bookList = bookService.findBookAll();
			mav.addObject("bookList", bookList);
			mav.setViewName("index");
		} else {
			System.out.println("session");
			System.out.println("session中没有username");
			mav.setViewName("login");
		}

		return mav;
	}

	@RequestMapping(value = "login")
	public ModelAndView Login(@ModelAttribute User user, ModelAndView mav, HttpSession session) {
		System.out.println("login");
		User user2 = userService.findUser(user);
		if (null != user2) {// 正确
			System.out.println("放入session");
			session.setAttribute("username", user2.getUsername());// 将用户名放入session域
			mav.setViewName("redirect:index.html");
		} else {// 错误
			mav.setViewName("login");
		}
		return mav;
	}
}
