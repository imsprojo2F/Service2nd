/**   
* @Title: ProductTypeService.java 
* @Package com.server.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月7日 下午2:46:12 
* @version V1.0   
*/
package com.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.dao.ProductTypeMapper;
import com.server.pojo.ProductType;
import com.server.service.IProductTypeService;

/**
 * @ClassName: ProductTypeService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月7日 下午2:46:12
 * 
 */
@Service
public class ProductTypeService implements IProductTypeService {

	@Autowired
	private ProductTypeMapper pMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductTypeService#deleteByPrimaryKey(java.lang.
	 * Integer)
	 */

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return pMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductTypeService#insert(com.server.pojo.
	 * ProductType)
	 */

	public int insert(ProductType record) {
		// TODO Auto-generated method stub
		return pMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IProductTypeService#insertSelective(com.server.pojo.
	 * ProductType)
	 */

	public int insertSelective(ProductType record) {
		// TODO Auto-generated method stub
		return pMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductTypeService#selectByPrimaryKey(java.lang.
	 * Integer)
	 */

	public ProductType selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return pMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IProductTypeService#updateByPrimaryKeySelective(com.
	 * server.pojo.ProductType)
	 */

	public int updateByPrimaryKeySelective(ProductType record) {
		// TODO Auto-generated method stub
		return pMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IProductTypeService#updateByPrimaryKey(com.server.pojo
	 * .ProductType)
	 */

	public int updateByPrimaryKey(ProductType record) {
		// TODO Auto-generated method stub
		return pMapper.updateByPrimaryKey(record);
	}

	/*
	 * Title: listAll Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductTypeService#listAll(java.util.Map)
	 */

	public List<Map<String, String>> listAll(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return pMapper.listAll(qMap);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductTypeService#selectByPage(java.util.Map)
	 */

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return pMapper.selectByPage(qMap);
	}

	/*
	 * Title: updateByUidSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IProductTypeService#updateByUidSelective(com.server.
	 * pojo.ProductType)
	 */

	public int updateByUidSelective(ProductType record) {
		// TODO Auto-generated method stub
		return pMapper.updateByUidSelective(record);
	}

	/*
	 * Title: deleteByUid Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductTypeService#deleteByUid(java.util.Map)
	 */

	public int deleteByUid(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return pMapper.deleteByUid(qMap);
	}

	/*
	 * Title: selectByUid Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductTypeService#selectByUid(java.util.Map)
	 */

	public List<Map<String, String>> selectByUid(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return pMapper.selectByUid(qMap);
	}

	/*
	 * Title: getByUid Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductTypeService#getByUid(java.util.Map)
	 */

	public ProductType getByUid(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return pMapper.getByUid(qMap);
	}

}
