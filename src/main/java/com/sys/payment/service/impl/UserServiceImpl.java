package com.sys.payment.service.impl;


import com.sys.payment.entity.MyUser;
import com.sys.payment.mapper.UserDao;
import com.sys.payment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public MyUser selectUser(String Id) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(Id);
	}

}
