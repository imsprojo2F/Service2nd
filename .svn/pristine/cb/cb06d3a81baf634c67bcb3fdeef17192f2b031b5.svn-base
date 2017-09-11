/**   
* @Title: ProductController.java 
* @Package com.server.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月7日 上午10:25:50 
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

import com.server.pojo.Product;
import com.server.pojo.User;
import com.server.service.impl.ProductService;
import com.server.util.AboutUtil;
import com.server.util.ApiResult;
import com.server.util.GetUID;

/**
 * @ClassName: ProductController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月7日 上午10:25:50
 * 
 */
@Controller
@RequestMapping("user")
public class ProductController {

	@Autowired
	private ProductService pService;

	public int pageNow = 0;
	public int pageSize = 0;
	public int isSucc = 0;
	public Object reObject = null;
	Map<String, Object> qMap = new HashMap<String, Object>();
	List<Map<String, String>> allList = new ArrayList<Map<String, String>>();
	List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();

	@RequestMapping("productAdd")
	@ResponseBody
	public Object add(Product product, HttpSession session) {

		String uid = GetUID.getUUID();
		session.setAttribute("uid", uid);
		User u = (User) session.getAttribute("account");
		String editBy = u.getAccount();
		product.setEditBy(editBy);
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

	@RequestMapping("productDelete")
	@ResponseBody
	public Object delete(Product product) {

		isSucc = pService.deleteByPrimaryKey(product.getUid());
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("productUpdate")
	@ResponseBody
	public Object update(Product product) {

		product.setUpdateTime(AboutUtil.getStringTime());

		isSucc = pService.updateByPrimaryKeySelective(product);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("updateByUid")
	@ResponseBody
	public Object updateImgsrc(Product product) {

		product.setCreateTime(AboutUtil.getStringTime());
		product.setUpdateTime(AboutUtil.getStringTime());

		isSucc = pService.updateByUidSelective(product);
		if (isSucc > 0) {
			reObject = new ApiResult("成功", ApiResult.CODE_SUCCESS);
		} else {
			reObject = new ApiResult("失败", ApiResult.CODE_FAIL);
		}
		return reObject;
	}

	@RequestMapping("productGetByUid")
	@ResponseBody
	public Object getByUid(HttpSession session, String uid) {

		qMap.put("uid", uid);
		resultList = pService.getByUid(qMap);
		return resultList;
	}

	@RequestMapping("getById")
	@ResponseBody
	public Object getById(String id) {
		qMap.put("id", id);
		resultList = pService.selectById(qMap);
		return resultList;
	}

	@RequestMapping("getIds")
	@ResponseBody
	public Object getIds() {

		resultList = pService.listAll(qMap);
		return resultList;
	}

	@RequestMapping("productList")
	@ResponseBody
	public Object list(String page, String rows, String sidx, String sord, String typeId, String name) {

		pageNow = Integer.parseInt(page);
		pageSize = Integer.parseInt(rows);
		pageNow = (pageNow - 1) * pageSize;
		qMap.put("pageNow", pageNow);
		qMap.put("pageSize", pageSize);
		qMap.put("sidx", sidx);
		qMap.put("sord", sord);
		qMap.put("typeId", typeId);
		qMap.put("name", name);

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

}
