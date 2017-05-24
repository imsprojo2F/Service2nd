/**   
* @Title: IInfoService.java 
* @Package com.server.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月3日 上午10:06:02 
* @version V1.0   
*/
package com.server.service;

import java.util.List;
import java.util.Map;

import com.server.pojo.Info;

/**
 * @ClassName: IInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月3日 上午10:06:02
 * 
 */
public interface IInfoService {

	public int deleteByPrimaryKey(Integer id);

	public int insert(Info record);

	public int insertSelective(Info record);

	public Info selectByPrimaryKey(Integer id);

	public int updateByPrimaryKeySelective(Info record);

	public int updateByPrimaryKey(Info record);

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	public List<Map<String, String>> listAll(Map<String, Object> qMap);

}
