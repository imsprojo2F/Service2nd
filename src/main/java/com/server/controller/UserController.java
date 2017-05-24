/**   
* @Title: UserController.java 
* @Package com.server.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo
* @date 2017年2月23日 下午4:00:28 
* @version V1.0   
*/
package com.server.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.pojo.User;
import com.server.service.impl.UserService;
import com.server.util.AboutUtil;
import com.server.util.ApiResult;

/**
 * @ClassName: UserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年2月23日 下午4:00:28
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	public int pageNow = 0;
	public int pageSize = 0;
	public int isSucc = 0;
	public Object reObject = null;
	Map<String, Object> qMap = new HashMap<String, Object>();
	List<Map<String, String>> allList = new ArrayList<Map<String, String>>();
	List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
	User user = new User();

	@RequestMapping("login")
	@ResponseBody
	public Object login(String account, String password, HttpSession session) {

		qMap.put("account", account);
		qMap.put("password", password);
		user = userService.login(qMap);
		if (user != null) {
			session.setAttribute("account", user);
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("toIndex")
	public Object toIndex() {

		return "/user/index";
	}

	@RequestMapping("loginOut")
	public void loginOut(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.invalidate();
		try {
			response.sendRedirect(request.getContextPath() + "/login.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("userValidate")
	@ResponseBody
	public Object validate(String account) {

		qMap.put("account", account);
		user = userService.selectByAccount(qMap);
		if (user == null) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("userAdd")
	@ResponseBody
	public Object add(User user) {

		user.setCreateTime(AboutUtil.getStringTime());
		isSucc = userService.insertSelective(user);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@ResponseBody
	@RequestMapping("userDelete")
	public Object deleteUser(HttpServletRequest request, Integer id) {
		/*
		 * String idArr = request.getParameter("ids");
		 * 
		 * String[] ids = idArr.split(",");
		 */

		isSucc = userService.deleteByPrimaryKey(id);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("userUpdate")
	@ResponseBody
	public Object update(User user) {

		isSucc = userService.updateByPrimaryKeySelective(user);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@ResponseBody
	@RequestMapping("/userList")
	public Object getLogList(String page, String rows, String sidx, String sord) {

		qMap.clear();
		pageNow = Integer.parseInt(page);
		pageSize = Integer.parseInt(rows);
		pageNow = (pageNow - 1) * pageSize;
		qMap.put("pageNow", pageNow);
		qMap.put("pageSize", pageSize);
		qMap.put("sidx", sidx);
		qMap.put("sord", sord);
		// 获取总记录数
		allList = userService.listAll(qMap);
		int recordNum = allList.size();

		int totalPage = (recordNum + pageSize - 1) / pageSize;

		resultList = userService.selectByPage(qMap);
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
