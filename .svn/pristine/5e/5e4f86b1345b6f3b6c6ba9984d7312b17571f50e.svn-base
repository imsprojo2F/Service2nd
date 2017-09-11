package com.server.dao;

import java.util.List;
import java.util.Map;

import com.server.pojo.Info;

public interface InfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Info record);

	int insertSelective(Info record);

	Info selectByPrimaryKey(Integer id);

	List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	int updateByPrimaryKeySelective(Info record);

	int updateByPrimaryKey(Info record);

	List<Map<String, String>> listAll(Map<String, Object> qMap);
}