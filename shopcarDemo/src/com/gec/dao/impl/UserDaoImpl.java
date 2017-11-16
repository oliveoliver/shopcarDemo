package com.gec.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gec.dao.BaseDao;
import com.gec.dao.IUSerDao;
import com.gec.domain.User;


public class UserDaoImpl extends BaseDao implements IUSerDao {

	@Override
	public int insertUser(User user) {
		// 首先应该获取数据库连接对象
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("insert into t_user(user_name,pass_word) values(?,?)");
			
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassWord());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)
				pstmt.close();
				closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> queryUserByLogin(User user) {
		// 首先应该获取数据库连接对象
				Connection conn = null;
				PreparedStatement pstmt =null;
				List<User> userList = new ArrayList<>();
				try {
					conn = getConnection();
					pstmt=conn.prepareStatement("select * from t_user where user_name=? and pass_word=?");
					
					pstmt.setString(1, user.getUserName());
					pstmt.setString(2, user.getPassWord());
					
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						User outUser = new User();
						outUser.setUserId(rs.getInt(1));
						outUser.setUserName(rs.getString(2));
						outUser.setPassWord(rs.getString(3));
						
						userList.add(outUser);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						if(pstmt!=null)
						pstmt.close();
						closeConnection(conn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return userList;
	}

}
