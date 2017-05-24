package com.server.dao;

import java.util.List;
import java.util.Map;

import com.server.pojo.ProductType;

public interface ProductTypeMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ProductType record);

	int insertSelective(ProductType record);

	ProductType selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ProductType record);

	int updateByPrimaryKey(ProductType record);

	List<Map<String, String>> listAll(Map<String, Object> qMap);

	List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	int updateByUidSelective(ProductType record);

	int deleteByUid(Map<String, Object> qMap);

	List<Map<String, String>> selectByUid(Map<String, Object> qMap);

	ProductType getByUid(Map<String, Object> qMap);
}