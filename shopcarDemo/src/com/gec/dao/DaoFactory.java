package com.gec.dao;

import com.gec.dao.impl.UserDaoImpl;

/*����Dao����Ĺ�����*/
public class DaoFactory {
	// ����������ڲ���UserDao����
	public static IUSerDao getUserDao() {
		return new UserDaoImpl();
	}
}
