package com.gec.dao;

import java.util.List;

import com.gec.domain.User;

public interface IUSerDao {
  public int insertUser(User user);
  public int deleteUser(User user);
  public int updateUser(User user);
  public List<User> queryUserByLogin(User user);
}
