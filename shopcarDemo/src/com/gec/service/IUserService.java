package com.gec.service;

import com.gec.domain.User;

public interface IUserService {
	// ע��
	public boolean register(User user);
	// ��½��֤
	public boolean login(User user);

}
