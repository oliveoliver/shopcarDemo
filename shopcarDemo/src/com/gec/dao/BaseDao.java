package com.gec.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.gec.db.DataSourceUtil;

/*getConnection方法
closeConnection方法*/
public class BaseDao {
	// 获取阿里数据源连接的对象
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
