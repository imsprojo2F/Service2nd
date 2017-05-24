/**   
* @Title: MenuRedirectController.java 
* @Package com.server.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年2月24日 下午4:26:13 
* @version V1.0   
*/
package com.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: MenuRedirectController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年2月24日 下午4:26:13
 * 
 */
@Controller
@RequestMapping("/user")
public class MenuRedirectController {

	@RequestMapping("main")
	public String main() {
		return "user/main";
	}

	@RequestMapping("userOperate")
	public String toUser() {
		return "user/user";
	}

	@RequestMapping("info")
	public String info() {
		return "user/info";
	}

	@RequestMapping("productOperate")
	public String productOperate() {
		return "user/product";
	}

	@RequestMapping("typeOperate")
	public String typeOperate() {
		return "user/type";
	}

	@RequestMapping("newsOperate")
	public String newsOperate() {
		return "user/news";
	}

	@RequestMapping("toAddPro")
	public String toAddPro() {
		return "user/addPro";
	}

	@RequestMapping("toUpload")
	public String toUpload() {
		return "user/upload";
	}

}
