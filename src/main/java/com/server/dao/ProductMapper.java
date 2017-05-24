package com.server.dao;

import java.util.List;
import java.util.Map;

import com.server.pojo.Product;

public interface ProductMapper {
	int deleteByPrimaryKey(String uid);

	int insert(Product record);

	int insertSelective(Product record);

	List<Map<String, String>> selectById(Map<String, Object> qMap);

	Product getById(Map<String, Object> qMap);

	int updateByPrimaryKeySelective(Product record);

	int updateByPrimaryKey(Product record);

	List<Map<String, String>> listAll(Map<String, Object> qMap);

	List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	List<Map<String, String>> getByUid(Map<String, Object> qMap);

	Product selectByUid(Map<String, Object> qMap);

	int updateByUidSelective(Product record);
}