/**   
* @Title: IProductService.java 
* @Package com.server.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月7日 上午10:22:33 
* @version V1.0   
*/
package com.server.service;

import java.util.List;
import java.util.Map;

import com.server.pojo.Product;

/**
 * @ClassName: IProductService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月7日 上午10:22:33
 * 
 */
public interface IProductService {

	public int deleteByPrimaryKey(String uid);

	public int insert(Product record);

	public int insertSelective(Product record);

	public List<Map<String, String>> selectById(Map<String, Object> qMap);

	public Product getById(Map<String, Object> qMap);

	public int updateByPrimaryKeySelective(Product record);

	public int updateByPrimaryKey(Product record);

	public List<Map<String, String>> listAll(Map<String, Object> qMap);

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	public List<Map<String, String>> getByUid(Map<String, Object> qMap);

	public Product selectByUid(Map<String, Object> qMap);

	public int updateByUidSelective(Product record);

}
