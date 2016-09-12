package com.cyt.music.common.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

public class BizExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		//如果该 异常类型是系统 自定义的异常，直接取出异常信息，在错误页面展示。  
        BizException bizException=null;  
        if(ex instanceof BizException){  
        	bizException=(BizException)ex;  
              
        }else{  
            //如果该 异常类型不是系统 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）。  
        	bizException=new BizException(ex.getMessage());  
        }  
  
        //错误信息  
        String message=bizException.getMessage();  
          
        ModelAndView modelAndView=new ModelAndView();  
          
        //将错误信息传到页面  
        modelAndView.addObject("message",message);  
          
        //指向到错误界面  
        modelAndView.setViewName("error.jsp"); 
          
        return modelAndView;
                    
	}

}
