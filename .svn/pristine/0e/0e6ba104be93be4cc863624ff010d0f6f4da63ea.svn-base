/**   
* @Title: ProductTypeController.java 
* @Package com.server.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月7日 下午2:49:47 
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

import com.server.pojo.ProductType;
import com.server.service.impl.ProductTypeService;
import com.server.util.AboutUtil;
import com.server.util.ApiResult;
import com.server.util.GetUID;

/**
 * @ClassName: ProductTypeController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月7日 下午2:49:47
 * 
 */
@Controller
@RequestMapping("user")
public class ProductTypeController {
	@Autowired
	private ProductTypeService pService;

	public int pageNow = 0;
	public int pageSize = 0;
	public int isSucc = 0;
	public Object reObject = null;
	Map<String, Object> qMap = new HashMap<String, Object>();
	List<Map<String, String>> allList = new ArrayList<Map<String, String>>();
	List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();

	@RequestMapping("typeAdd")
	@ResponseBody
	public Object add(ProductType product, HttpSession session) {

		String uid = GetUID.getUUID();
		session.setAttribute("uid", uid);
		product.setUid(uid);
		product.setCreateTime(AboutUtil.getStringTime());
		product.setUpdateTime(AboutUtil.getStringTime());
		isSucc = pService.insertSelective(product);
		if (isSucc > 0) {
			reObject = new ApiResult(uid, ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("typeDelete")
	@ResponseBody
	public Object delete(ProductType product) {
		qMap.put("uid", product.getUid());
		isSucc = pService.deleteByUid(qMap);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("typeUpdate")
	@ResponseBody
	public Object update(ProductType product) {

		product.setUpdateTime(AboutUtil.getStringTime());
		isSucc = pService.updateByUidSelective(product);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("typeGetByUid")
	@ResponseBody
	public Object getByUid(HttpSession session, String uid) {

		qMap.put("uid", uid);
		resultList = pService.selectByUid(qMap);
		return resultList;
	}

	@RequestMapping("typeList")
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
		allList = pService.listAll(qMap);
		int recordNum = allList.size();

		int totalPage = (recordNum + pageSize - 1) / pageSize;

		resultList = pService.selectByPage(qMap);
		if (resultList != null) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", totalPage);
			result.put("records", recordNum);
			result.put("rows", resultList);
			return result;
		}
		return null;

	}

	@RequestMapping("listType")
	@ResponseBody
	public Object listType() {

		resultList = pService.listAll(qMap);
		return resultList;
	}

}
