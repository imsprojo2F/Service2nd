package com.server.dao;

import java.util.List;
import java.util.Map;

import com.server.pojo.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User login(Map<String, Object> qMap);

	User selectByAccount(Map<String, Object> qMap);

	int deleteByIds(String[] ids);

	List<Map<String, String>> listAll(Map<String, Object> qMap);

	List<Map<String, String>> selectByPage(Map<String, Object> qMap);
}