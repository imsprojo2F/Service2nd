/**   
* @Title: APIResult.java 
* @Package com.zooori.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月6日 下午4:27:12 
* @version V1.0   
*/
package com.server.util;

/**
 * @ClassName: APIResult
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月6日 下午4:27:12
 * 
 */
public class ApiResult {

	public static final String CODE_FAIL = "-1";
	public static final String CODE_SUCCESS = "1";

	public String message;
	public String code;
	public Object data;

	public ApiResult() {
		this("success", ApiResult.CODE_SUCCESS);
	}

	public ApiResult(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public ApiResult(String message, String code, Object data) {
		this.message = message;
		this.code = code;
		this.data = data;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
