/**   
* @Title: NewsController.java 
* @Package com.server.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月15日 上午9:34:06 
* @version V1.0   
*/
package com.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.pojo.News;
import com.server.pojo.User;
import com.server.service.impl.NewsService;
import com.server.util.AboutUtil;
import com.server.util.ApiResult;
import com.server.util.GetUID;

/**
 * @ClassName: NewsController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月15日 上午9:34:06
 * 
 */
@Controller
@RequestMapping("user")
public class NewsController {

	@Autowired
	private NewsService newsService;

	public int pageNow = 0;
	public int pageSize = 0;
	public int isSucc = 0;
	public Object reObject = null;
	Map<String, Object> qMap = new HashMap<String, Object>();
	List<Map<String, String>> allList = new ArrayList<Map<String, String>>();
	List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();

	@RequestMapping("newsAdd")
	@ResponseBody
	public Object add(News info, HttpSession session) {

		String uid = GetUID.getUUID();
		session.setAttribute("uid", uid);
		User u = (User) session.getAttribute("account");
		String editBy = u.getAccount();

		info.setUid(uid);
		info.setAuthor(editBy);
		info.setCreateTime(AboutUtil.getStringTime());

		isSucc = newsService.insertSelective(info);
		if (isSucc > 0) {
			reObject = new ApiResult(uid, ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("newsDelete")
	@ResponseBody
	public Object delete(News info) {

		isSucc = newsService.deleteByPrimaryKey(info);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("newsUpdate")
	@ResponseBody
	public Object update(News info) {

		isSucc = newsService.updateByPrimaryKeySelective(info);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("selectByKey")
	@ResponseBody
	public Object selectByKey(News news) {
		news = newsService.selectByPrimaryKey(news);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("news", news);

		return result;
	}

	@RequestMapping("listAllNews")
	@ResponseBody
	public Object listAllNews() {
		resultList = newsService.listAll(qMap);
		return resultList;
	}

	@RequestMapping("newsList")
	@ResponseBody
	public Object list(String page, String rows, String sidx, String sord) {

		pageNow = Integer.parseInt(page);
		pageSize = Integer.parseInt(rows);
		pageNow = (pageNow - 1) * pageSize;
		qMap.put("pageNow", pageNow);
		qMap.put("pageSize", pageSize);
		qMap.put("sidx", sidx);
		qMap.put("sord", sord);

		// 获取总记录数
		allList = newsService.listAll(qMap);
		int recordNum = allList.size();

		int totalPage = (recordNum + pageSize - 1) / pageSize;

		resultList = newsService.selectByPage(qMap);
		if (resultList != null) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", totalPage);
			result.put("records", recordNum);
			result.put("rows", resultList);
			return result;
		}
		return null;

	}

}
