package com.gec.dao;

import com.gec.dao.impl.UserDaoImpl;

/*产生Dao对象的工厂类*/
public class DaoFactory {
	// 这个方法用于产生UserDao对象
	public static IUSerDao getUserDao() {
		return new UserDaoImpl();
	}
}
