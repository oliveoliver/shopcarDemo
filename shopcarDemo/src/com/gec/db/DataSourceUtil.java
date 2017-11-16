package com.gec.db;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.alibaba.druid.pool.DruidDataSource;
/*这里类是专门用来获取jdbc阿里数据源的*/
public class DataSourceUtil {
	private static DruidDataSource ds = null;
	static {
		// 获取Context对象
		Context context = null;
		try {
			context = new InitialContext();
			ds = (DruidDataSource) context.lookup("java:comp/env/jdbc/MysqlDataSource");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 通过这个方法拿到数据源
	public static DruidDataSource getDataSource() {
		return ds;
	}
}
