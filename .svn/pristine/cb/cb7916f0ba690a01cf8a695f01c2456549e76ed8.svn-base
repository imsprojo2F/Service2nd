/**   
* @Title: INewsService.java 
* @Package com.server.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月15日 上午9:30:31 
* @version V1.0   
*/
package com.server.service;

import java.util.List;
import java.util.Map;

import com.server.pojo.News;

/**
 * @ClassName: INewsService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月15日 上午9:30:31
 * 
 */
public interface INewsService {

	public int deleteByPrimaryKey(News news);

	public int insert(News record);

	public int insertSelective(News record);

	public News selectByPrimaryKey(News news);

	public int updateByPrimaryKeySelective(News record);

	public int updateByPrimaryKey(News record);

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	public List<Map<String, String>> listAll(Map<String, Object> qMap);

}
