package com.example.kansyoku_kiroku.model.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.kansyoku_kiroku.model.domain.Menu;

@Mapper
public interface MenuMapper {
	
	@Select("SELECT * FROM menu WHERE user_id = #{userId} AND created_date = #{date}")
	List<Menu> findTodayMenu(@Param("userId") int userId, @Param("date") Date date);
	
	@Select("SELECT IFNULL(SUM(price), 0) FROM menu WHERE user_id = #{userId} AND created_date = #{date}")
	int sumTodayPrice(@Param("userId") int userId, @Param("date") Date date);
	
	@Select("SELECT IFNULL(SUM(kcal), 0) FROM menu WHERE user_id = #{userId} AND created_date = #{date}")
	int sumTodayKcal(@Param("userId") int userId, @Param("date") Date date);
	
	@Delete("DELETE FROM menu WHERE menu_id = #{menuId}")
	void deleteById(int menuId);
	
	@Insert("INSERT INTO menu (user_id, menu_name, price, kcal, shop, memo, created_date) " +
			"VALUES (#{userId}, #{menuName}, #{price}, #{kcal}, #{shop}, #{memo}, #{createdDate})")
	@Options(useGeneratedKeys = true, keyProperty="menuId")
	void insertMenu(Menu menu);
	
	@Select("SELECT * FROM menu WHERE user_id = #{userId} ORDER BY menu_id LIMIT 10")
	List<Menu> findMenuHistory(int userId);	
	
	@Insert("INSERT INTO menu(user_id,menu_name,price,kcal,shop,memo,created_date) SELECT user_id,menu_name,price,kcal,shop,memo,#{date} as created_date "
			+ "FROM kansyoku_kiroku.menu WHERE user_id = #{userId} AND menu_id = #{menuId} LIMIT 1")
	@Options(useGeneratedKeys = true, keyProperty="menuId")
	void insertMenuHistory(@Param("date") Date date,@Param("userId") int userId,@Param("menuId") int menuId);
}
