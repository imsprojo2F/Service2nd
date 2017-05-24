/**   
* @Title: UploadController.java 
* @Package com.server.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年3月8日 上午11:09:53 
* @version V1.0   
*/
package com.server.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.server.pojo.News;
import com.server.pojo.Product;
import com.server.pojo.ProductType;
import com.server.pojo.User;
import com.server.service.impl.NewsService;
import com.server.service.impl.ProductService;
import com.server.service.impl.ProductTypeService;
import com.server.util.ApiResult;

/**
 * @ClassName: UploadController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年3月8日 上午11:09:53
 * 
 */
@Controller
@RequestMapping("user")
public class UploadController extends BaseAction {

	@Autowired
	private ProductService pService;
	@Autowired
	private ProductTypeService pTypeService;
	@Autowired
	private NewsService newsService;

	Logger log = Logger.getLogger(UploadController.class);

	boolean flag = false;
	int num = 0;
	String dir = "";

	@RequestMapping("/uploadImg")
	public String uploadHeadPic(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		int isSucc = 0;
		Map<String, Object> qMap = new HashMap<String, Object>();
		User user = (User) session.getAttribute("account");
		String uid = (String) session.getAttribute("uid");
		String type = (String) session.getAttribute("type");
		// 图片存放路径
		if (type.equals("product")) {
			dir = "user/image/product/";
		} else if (type.equals("type")) {
			dir = "user/image/type/";
		} else {
			dir = "user/image/news/";
		}
		int fileNum = Integer.parseInt(String.valueOf(session.getAttribute(user.getId() + "fileNum")));
		try {

			if (num > 0) {
				flag = false;
			}
			Map<String, Object> srcMap = super.upload(file, dir, request, flag);
			num = Integer.parseInt(srcMap.get("num").toString());
			System.err.println(fileNum + "---" + num);
			if (fileNum == num) {
				// 图片地址存入数据库
				Product product = new Product();
				ProductType pType = new ProductType();
				News news = new News();

				if (!"".equals(uid) && uid != null) {

					if (type.equals("product")) {// 产品图片数据库操作
						product.setUid(uid);
						// 获取数据库原有的图片地址并累加图片地址
						qMap.put("uid", uid);
						product = pService.selectByUid(qMap);
						String src_ = product.getImgsrc();
						String imgsrc = "";
						if (src_ != null) {
							imgsrc = src_ + srcMap.get("src").toString();
						} else {
							imgsrc = srcMap.get("src").toString();
						}
						product.setImgsrc(imgsrc);
						isSucc = pService.updateByPrimaryKeySelective(product);
					} else if (type.equals("type")) {// 产品类型图片数据库操作
						pType.setUid(uid);
						// 获取数据库原有的图片地址并累加图片地址
						qMap.put("uid", uid);
						pType = pTypeService.getByUid(qMap);
						String src_ = pType.getImgsrc();
						String imgsrc = "";
						if (src_ != null) {
							imgsrc = src_ + srcMap.get("src").toString();
						} else {
							imgsrc = srcMap.get("src").toString();
						}
						pType.setImgsrc(imgsrc);
						isSucc = pTypeService.updateByUidSelective(pType);
					} else {// 新闻图片数据库操作
						news.setUid(uid);
						news = newsService.selectByPrimaryKey(news);
						String src_ = news.getImg();
						String imgsrc = "";
						if (src_ != null) {
							imgsrc = src_ + srcMap.get("src").toString();
						} else {
							imgsrc = srcMap.get("src").toString();
						}
						news.setImg(imgsrc);
						isSucc = newsService.updateByPrimaryKeySelective(news);
					}

					if (isSucc > 0) {
						flag = true;
						num = 0;
						session.setAttribute(user.getId() + "src", srcMap.get("src").toString());
					}

				}
			}

			response.getWriter().print(super.getFileName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("setSession")
	@ResponseBody
	public void SetUid(HttpSession session, String key, String value) {

		session.setAttribute(key, value);
	}

	@RequestMapping("setFileNum")
	@ResponseBody
	public Object setFileNum(HttpSession session, String fileNum) {
		User user = (User) session.getAttribute("account");
		session.setAttribute(user.getId() + "fileNum", fileNum);
		return new ApiResult("成功", "1");
	}
}
