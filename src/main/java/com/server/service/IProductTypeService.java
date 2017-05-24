/**   
* @Title: IProductTypeTypeService.java 
* @Package com.server.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月7日 下午2:45:01 
* @version V1.0   
*/
package com.server.service;

import java.util.List;
import java.util.Map;

import com.server.pojo.ProductType;

/**
 * @ClassName: IProductTypeTypeService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月7日 下午2:45:01
 * 
 */
public interface IProductTypeService {

	public int deleteByPrimaryKey(Integer id);

	public int insert(ProductType record);

	public int insertSelective(ProductType record);

	public ProductType selectByPrimaryKey(Integer id);

	public int updateByPrimaryKeySelective(ProductType record);

	public int updateByPrimaryKey(ProductType record);

	public List<Map<String, String>> listAll(Map<String, Object> qMap);

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	public int updateByUidSelective(ProductType record);

	public int deleteByUid(Map<String, Object> qMap);

	public List<Map<String, String>> selectByUid(Map<String, Object> qMap);

	public ProductType getByUid(Map<String, Object> qMap);

}
