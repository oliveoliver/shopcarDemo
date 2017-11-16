package com.gec.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.gec.db.DataSourceUtil;

/*getConnection����
closeConnection����*/
public class BaseDao {
	// ��ȡ��������Դ���ӵĶ���
	public Connection getConnection() throws SQLException {
		Connection conn = DataSourceUtil.getDataSource().getConnection();
		return conn;

	}
	public void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
