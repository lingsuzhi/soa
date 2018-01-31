package com.lszpro.soa.common;

 

import java.util.List;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author JiangZuoWei
 * @createTime 2015年11月10日 下午3:52:30
 * @description 
 */
public class BaseResponse implements java.io.Serializable{

	
	private String code;
	
	private String message;

	protected BaseResponse(){}


	public BaseResponse(Boolean b) {
		if(b){
			this.code = "2000";
			this.message = "访问成功";
		}else{
			this.code = "5555";
			this.message = "访问失败";
		}
	}
	public BaseResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
