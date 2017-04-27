package com.bugsmanage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
* @Description:
* @author 作者 :lixingyan
* @version 创建时间：2017年3月30日 下午3:03:08
*/
public class AuthorizedInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	   
		
		String ad_username =  (String)request.getSession().getAttribute("ad_username");   
	    String username =  (String)request.getSession().getAttribute("username");   
        if(ad_username == null&&username == null){  	           
          // response.sendRedirect(request.getServletContext().getContextPath()+"/user/login");
           request.setAttribute("message", "请先登录再访问网站!");
   		   request.getRequestDispatcher("/user/login").forward(request, response);
            return false;  
        }else  
            return true;  
	}

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		
//		    String ad_username =  (String)request.getSession().getAttribute("ad_username");   
//		    String username =  (String)request.getSession().getAttribute("username");   
//	        if(ad_username == null&&username == null){  	           
//	          // response.sendRedirect(request.getServletContext().getContextPath()+"/user/login");
//	           request.setAttribute("message", "请先登录再访问网站!");
//       		   request.getRequestDispatcher("/user/login").forward(request, response);
//	            return false;  
//	        }else  
//	            return true;     
//	}


	

}
