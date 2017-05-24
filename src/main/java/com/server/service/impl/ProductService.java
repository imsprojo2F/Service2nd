/**   
* @Title: ProductService.java 
* @Package com.server.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月7日 上午10:23:47 
* @version V1.0   
*/
package com.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.dao.ProductMapper;
import com.server.pojo.Product;
import com.server.service.IProductService;

/**
 * @ClassName: ProductService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月7日 上午10:23:47
 * 
 */
@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductMapper productMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IProductService#deleteByPrimaryKey(java.lang.Integer)
	 */

	public int deleteByPrimaryKey(String uid) {
		// TODO Auto-generated method stub
		return productMapper.deleteByPrimaryKey(uid);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductService#insert(com.server.pojo.Product)
	 */

	public int insert(Product record) {
		// TODO Auto-generated method stub
		return productMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductService#insertSelective(com.server.pojo.
	 * Product)
	 */

	public int insertSelective(Product record) {
		// TODO Auto-generated method stub
		return productMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IProductService#selectByPrimaryKey(java.lang.Integer)
	 */

	public List<Map<String, String>> selectById(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return productMapper.selectById(qMap);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IProductService#updateByPrimaryKeySelective(com.server
	 * .pojo.Product)
	 */

	public int updateByPrimaryKeySelective(Product record) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IProductService#updateByPrimaryKey(com.server.pojo.
	 * Product)
	 */

	public int updateByPrimaryKey(Product record) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKey(record);
	}

	/*
	 * Title: listAll Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductService#listAll(java.util.Map)
	 */

	public List<Map<String, String>> listAll(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return productMapper.listAll(qMap);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductService#selectByPage(java.util.Map)
	 */

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return productMapper.selectByPage(qMap);
	}

	/*
	 * Title: getByUid Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductService#getByUid(java.util.Map)
	 */

	public List<Map<String, String>> getByUid(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return productMapper.getByUid(qMap);
	}

	/*
	 * Title: updateByUidSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IProductService#updateByUidSelective(com.server.pojo.
	 * Product)
	 */

	public int updateByUidSelective(Product record) {
		// TODO Auto-generated method stub
		return productMapper.updateByUidSelective(record);
	}

	/*
	 * Title: getById Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductService#getById(java.util.Map)
	 */

	public Product getById(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return productMapper.getById(qMap);
	}

	/*
	 * Title: selectByUid Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IProductService#selectByUid(java.util.Map)
	 */

	public Product selectByUid(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return productMapper.selectByUid(qMap);
	}

}
