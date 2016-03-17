package com.bby.ants.util;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class JSFUtil {

	public static String getParameter(String name){
		Map<String, String> params =FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		String param = params.get(name);
		return param;
	}
	public static HttpSession getHttpSession() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = facesContext.getExternalContext();
		HttpSession session = ((HttpSession) extContext.getSession(true));
		return session;

	}
	
	public static String getServerPath(HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
		
		return basePath;
	}
	
	public static String getServerPath2(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = facesContext.getExternalContext();
		String path=extContext.getRequestContextPath();
		String basePath=extContext.getRequestScheme()+ "://"+ extContext.getRequestServerName() + ":" + extContext.getRequestServerPort()+ path + "/";
		return basePath;
	}
	
	 public static String getVisitIP() {
	        try {
	            FacesContext fc = FacesContext.getCurrentInstance();

	             //实例化request
	            HttpServletRequest request = (HttpServletRequest)fc.getExternalContext().getRequest();
	            return request.getRemoteAddr();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return "";
	    }
	 
	 public static String getVisitHost() {
	        try {
	            FacesContext fc = FacesContext.getCurrentInstance();

	             //实例化request
	            HttpServletRequest request = (HttpServletRequest)fc.getExternalContext().getRequest();
	            return request.getRemoteHost();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return "";
	    }
}
