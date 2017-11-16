package com.gec.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gec.domain.User;
import com.gec.service.IUserService;
import com.gec.service.impl.UserServiceImpl;

/**
 * 实现用户登录与注册功能
 */
@WebServlet(name = "/UserController", urlPatterns = { "/user_login", "user_register" })
// 这两个路径都可以访问到这里
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * uri站点的入口名 /shopcardemo/user_register为注册 /shopcardemo/user_login为登陆
		 */
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		if (action.equals("user_login")) {
			// 获取用户参数
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			User user = new User();
			user.setUserName(username);
			user.setPassWord(password);

			IUserService userService = new UserServiceImpl();// 触发默认构造器，获取UserDao对象
			boolean islogin = userService.login(user);
			// 一般登陆成功后会保存在session里面
			if (islogin) {
				System.out.println("登陆成功");
			} else {
				System.out.println("登陆失败");
			}

		} else if (action.equals("user_register")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			User user = new User();
			user.setUserName(username);
			user.setPassWord(password);

			IUserService userService = new UserServiceImpl();
			boolean isregister = userService.register(user);
			if (isregister) {
				System.out.println("注册成功");
			} else {
				System.out.println("注册失败");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
