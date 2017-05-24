/**   
* @Title: InfoController.java 
* @Package com.server.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月3日 上午10:09:08 
* @version V1.0   
*/
package com.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.pojo.Info;
import com.server.service.impl.InfoService;
import com.server.util.AboutUtil;
import com.server.util.ApiResult;
import com.server.util.email.SendMail;

/**
 * @ClassName: InfoController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月3日 上午10:09:08
 * 
 */
@Controller
@RequestMapping("/user")
public class InfoController {

	@Autowired
	private InfoService infoService;

	public int pageNow = 0;
	public int pageSize = 0;
	public int isSucc = 0;
	public Object reObject = null;
	Map<String, Object> qMap = new HashMap<String, Object>();
	List<Map<String, String>> allList = new ArrayList<Map<String, String>>();
	List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();

	@RequestMapping("infoAdd")
	@ResponseBody
	public Object add(Info info) {

		info.setCreateTime(AboutUtil.getStringTime());

		if ("".equals(info.getName()) || info.getName() == null) {
			info.setName("暂未填写");
		}
		if ("".equals(info.getPhone()) || info.getPhone() == null) {
			info.setPhone("暂未填写");
		}
		if ("".equals(info.getEmail()) || info.getEmail() == null) {
			info.setEmail("暂未填写");
		}
		String TEXT = "【客户姓名】：" + info.getName() + "\r\n" + "【手机号码】：" + info.getPhone() + "\r\n" + "【邮箱地址】："
				+ info.getEmail() + "\r\n" + "【目标需求】：" + info.getMessage();
		String HEAD = "廊坊·庆辉建材有限公司【客户需求表】";

		SendMail myThread = new SendMail();
		String to = "745160210@qq.com";
		/* String to = "imsprojo2fan@foxmail.com"; */
		myThread.setTo(to);
		myThread.setTEXT(TEXT);
		myThread.setHEAD(HEAD);
		// myThread.stopThread(false);
		myThread.start();

		isSucc = infoService.insertSelective(info);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
			myThread.stopThread(true);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
			myThread.stopThread(true);
		}
		return reObject;
	}

	@RequestMapping("infoDelete")
	@ResponseBody
	public Object delete(Info info) {

		isSucc = infoService.deleteByPrimaryKey(info.getId());
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("infoUpdate")
	@ResponseBody
	public Object update(Info info) {

		isSucc = infoService.updateByPrimaryKeySelective(info);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("infoList")
	@ResponseBody
	public Object list(String page, String rows) {

		pageNow = Integer.parseInt(page);
		pageSize = Integer.parseInt(rows);
		pageNow = (pageNow - 1) * pageSize;
		qMap.put("pageNow", pageNow);
		qMap.put("pageSize", pageSize);

		// 获取总记录数
		allList = infoService.listAll(qMap);
		int recordNum = allList.size();

		int totalPage = (recordNum + pageSize - 1) / pageSize;

		resultList = infoService.selectByPage(qMap);
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
