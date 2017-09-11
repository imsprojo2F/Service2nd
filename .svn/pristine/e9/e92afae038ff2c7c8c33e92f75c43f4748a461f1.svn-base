/**   
* @Title: InfoService.java 
* @Package com.server.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月3日 上午10:07:09 
* @version V1.0   
*/
package com.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.dao.InfoMapper;
import com.server.pojo.Info;
import com.server.service.IInfoService;

/**
 * @ClassName: InfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月3日 上午10:07:09
 * 
 */
@Service
public class InfoService implements IInfoService {

	@Autowired
	private InfoMapper infoMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IInfoService#deleteByPrimaryKey(java.lang.Integer)
	 */

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return infoMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.server.service.IInfoService#insert(com.server.pojo.Info)
	 */

	public int insert(Info record) {
		// TODO Auto-generated method stub
		return infoMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IInfoService#insertSelective(com.server.pojo.Info)
	 */

	public int insertSelective(Info record) {
		// TODO Auto-generated method stub
		return infoMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IInfoService#selectByPrimaryKey(java.lang.Integer)
	 */

	public Info selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return infoMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IInfoService#updateByPrimaryKeySelective(com.server.
	 * pojo.Info)
	 */

	public int updateByPrimaryKeySelective(Info record) {
		// TODO Auto-generated method stub
		return infoMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.IInfoService#updateByPrimaryKey(com.server.pojo.Info)
	 */

	public int updateByPrimaryKey(Info record) {
		// TODO Auto-generated method stub
		return infoMapper.updateByPrimaryKey(record);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IInfoService#selectByPage(java.util.Map)
	 */

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return infoMapper.selectByPage(qMap);
	}

	/*
	 * Title: listAll Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.IInfoService#listAll(java.util.Map)
	 */

	public List<Map<String, String>> listAll(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return infoMapper.listAll(qMap);
	}

}
