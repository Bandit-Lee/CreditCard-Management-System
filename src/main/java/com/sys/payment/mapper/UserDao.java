package com.sys.payment.mapper;


import com.sys.payment.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("userDao")
@Mapper
public interface UserDao {
	public MyUser selectUserById(String Id);

}
