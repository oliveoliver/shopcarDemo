package com.gec.db;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.alibaba.druid.pool.DruidDataSource;
/*��������ר��������ȡjdbc��������Դ��*/
public class DataSourceUtil {
	private static DruidDataSource ds = null;
	static {
		// ��ȡContext����
		Context context = null;
		try {
			context = new InitialContext();
			ds = (DruidDataSource) context.lookup("java:comp/env/jdbc/MysqlDataSource");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ͨ����������õ�����Դ
	public static DruidDataSource getDataSource() {
		return ds;
	}
}
