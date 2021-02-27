package com.example.kansyoku_kiroku.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.kansyoku_kiroku.model.domain.User;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM kansyoku_kiroku.user WHERE user_name = #{userName} AND password = #{password}")
	User findByUserNameAndPassword(
			@Param("userName") String userName,
			@Param("password") String password);
	
	@Insert("INSERT INTO kansyoku_kiroku.user (user_name, email, password)"+
			"VALUES (#{userName}, #{email}, #{password})")
	@Options(useGeneratedKeys=true, keyProperty="userId")
	int insertUser(User user);

}
