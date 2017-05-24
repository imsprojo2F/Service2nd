/**   
* @Title: IUserService.java 
* @Package com.server.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2017年2月23日 下午3:54:52 
* @version V1.0   
*/
package com.server.service;

import java.util.List;
import java.util.Map;

import com.server.pojo.User;

/**
 * @ClassName: IUserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2017年2月23日 下午3:54:52
 * 
 */
public interface IUserService {

	public int deleteByPrimaryKey(Integer id);

	public int insert(User record);

	public int insertSelective(User record);

	public User selectByPrimaryKey(Integer id);

	public int updateByPrimaryKeySelective(User record);

	public int updateByPrimaryKey(User record);

	public User login(Map<String, Object> qMap);

	public User selectByAccount(Map<String, Object> qMap);

	public int deleteByIds(String[] ids);

	public List<Map<String, String>> listAll(Map<String, Object> qMap);

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap);

}
