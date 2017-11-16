package com.gec.service.impl;

import java.util.List;

import com.gec.dao.DaoFactory;
import com.gec.dao.IUSerDao;
import com.gec.domain.User;
import com.gec.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUSerDao userDao;

	public UserServiceImpl() {
		// ��ȡUserDao����
		userDao = DaoFactory.getUserDao();
	}

	@Override
	public boolean register(com.gec.domain.User user) {
		// ʵ��ע��������
		int pos = userDao.insertUser(user);
		if (pos > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean login(com.gec.domain.User user) {
		// ʵ�ֵ�½��֤�������
		List<User> userlist = userDao.queryUserByLogin(user);
		if (userlist != null && userlist.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
