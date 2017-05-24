/**   
* @Title: NewsService.java 
* @Package com.server.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月15日 上午9:31:24 
* @version V1.0   
*/
package com.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.dao.NewsMapper;
import com.server.pojo.News;
import com.server.service.INewsService;

/**
 * @ClassName: NewsService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月15日 上午9:31:24
 * 
 */
@Service
public class NewsService implements INewsService {

	@Autowired
	private NewsMapper newsMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.INewsService#deleteByPrimaryKey(java.lang.Integer)
	 */

	public int deleteByPrimaryKey(News news) {
		// TODO Auto-generated method stub
		return newsMapper.deleteByPrimaryKey(news);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.server.service.INewsService#insert(com.server.pojo.News)
	 */

	public int insert(News record) {
		// TODO Auto-generated method stub
		return newsMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.INewsService#insertSelective(com.server.pojo.News)
	 */

	public int insertSelective(News record) {
		// TODO Auto-generated method stub
		return newsMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.INewsService#selectByPrimaryKey(java.lang.Integer)
	 */

	public News selectByPrimaryKey(News news) {
		// TODO Auto-generated method stub
		return newsMapper.selectByPrimaryKey(news);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.INewsService#updateByPrimaryKeySelective(com.server.
	 * pojo.News)
	 */

	public int updateByPrimaryKeySelective(News record) {
		// TODO Auto-generated method stub
		return newsMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.server.service.INewsService#updateByPrimaryKey(com.server.pojo.News)
	 */

	public int updateByPrimaryKey(News record) {
		// TODO Auto-generated method stub
		return newsMapper.updateByPrimaryKey(record);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.INewsService#selectByPage(java.util.Map)
	 */

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return newsMapper.selectByPage(qMap);
	}

	/*
	 * Title: listAll Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.server.service.INewsService#listAll(java.util.Map)
	 */

	public List<Map<String, String>> listAll(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return newsMapper.listAll(qMap);
	}

}
