package com.cyt.music.common.exception;

/**
 * 
 * @author: chenyantao
 * @since: 2016-8-19  下午2:10:33
 * @Description: 统一异常类
 * @file: BizException.java
 */
public class BizException extends Exception{
 
		String message;
		
		public BizException (String message){
			super(message);
			this.message=message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
}
