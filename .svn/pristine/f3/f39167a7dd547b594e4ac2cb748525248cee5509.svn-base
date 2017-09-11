/**   
* @Title: UserService.java 
* @Package com.server.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2017年2月23日 下午3:55:53 
* @version V1.0   
*/
package com.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.dao.UserMapper;
import com.server.pojo.User;
import com.server.service.IUserService;

/**
 * @ClassName: UserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2017年2月23日 下午3:55:53
 * 
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private UserMapper userMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IUserService#deleteByPrimaryKey(java.lang.Integer)
	 */

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.server.service.IUserService#insert(com.server.pojo.User)
	 */

	public int insert(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IUserService#insertSelective(com.server.pojo.User)
	 */

	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IUserService#selectByPrimaryKey(java.lang.Integer)
	 */

	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IUserService#updateByPrimaryKeySelective(com.server.
	 * pojo.User)
	 */

	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IUserService#updateByPrimaryKey(com.server.pojo.User)
	 */

	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(record);
	}

	/*
	 * Title: login Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see com.server.service.IUserService#login(java.util.Map)
	 */

	public User login(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return userMapper.login(qMap);
	}

	/*
	 * Title: selectByAccount Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IUserService#selectByAccount(java.util.Map)
	 */

	public User selectByAccount(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return userMapper.selectByAccount(qMap);
	}

	/*
	 * Title: deleteByIds Description:
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see com.server.service.IUserService#deleteByIds(java.lang.String[])
	 */

	public int deleteByIds(String[] ids) {
		// TODO Auto-generated method stub
		return userMapper.deleteByIds(ids);
	}

	/*
	 * Title: listAll Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IUserService#listAll(java.util.Map)
	 */

	public List<Map<String, String>> listAll(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return userMapper.listAll(qMap);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IUserService#selectByPage(java.util.Map)
	 */

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return userMapper.selectByPage(qMap);
	}

}
