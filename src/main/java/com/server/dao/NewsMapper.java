package com.server.dao;

import java.util.List;
import java.util.Map;

import com.server.pojo.News;

public interface NewsMapper {
	int deleteByPrimaryKey(News news);

	int insert(News record);

	int insertSelective(News record);

	News selectByPrimaryKey(News news);

	int updateByPrimaryKeySelective(News record);

	int updateByPrimaryKey(News record);

	List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	List<Map<String, String>> listAll(Map<String, Object> qMap);
}