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
 * ʵ���û���¼��ע�Ṧ��
 */
@WebServlet(name = "/UserController", urlPatterns = { "/user_login", "user_register" })
// ������·�������Է��ʵ�����
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
		 * uriվ�������� /shopcardemo/user_registerΪע�� /shopcardemo/user_loginΪ��½
		 */
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		if (action.equals("user_login")) {
			// ��ȡ�û�����
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			User user = new User();
			user.setUserName(username);
			user.setPassWord(password);

			IUserService userService = new UserServiceImpl();// ����Ĭ�Ϲ���������ȡUserDao����
			boolean islogin = userService.login(user);
			// һ���½�ɹ���ᱣ����session����
			if (islogin) {
				System.out.println("��½�ɹ�");
			} else {
				System.out.println("��½ʧ��");
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
				System.out.println("ע��ɹ�");
			} else {
				System.out.println("ע��ʧ��");
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
