package com.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tools.SqlTools;
import com.tools.ToolUtils;

public class Action_DownloadTables extends ActionSupport {

	private ArrayList contentResult;
	private int pageSize = 10;
	private int pageNow = 1;
	private int totalPages = -1;
	private String contentName = "download";
	private HttpServletResponse response;
	private HttpServletRequest request;
	private SqlTools tools;
	private int TYPE;
	
	private String flag = null;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		tools = new SqlTools();
		tools.ConnectDB();
		
		request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		if("sj".equals(request.getParameter("tableType"))){
			TYPE = 1;
		}else{
			TYPE = 2;
		}
		totalPages = tools.getTotalPages(contentName,TYPE);
		

		if("downloadFile".equals(request.getParameter("type"))){
			
			String fileName = request.getParameter("fileName");
			fileName = ToolUtils.changeStringToChinese(fileName);
			String path = ServletActionContext.getServletContext().getRealPath("/")+"upload/admin/files/"+fileName;
		
			response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			response.setHeader("Content-Type", "text/plain;");
			response.setHeader("Content-disposition", "attachment;filename="+java.net.URLEncoder.encode(fileName,"UTF-8")+"");
			
			 			
			//InputStream fis = this.getClass().getClassLoader().getResourceAsStream(fileName);
			InputStream fis = new FileInputStream(path);
			OutputStream fos = response.getOutputStream();
			
			ToolUtils.downloadFiles(fis, fos);
			
			flag = "toIndex";
		}
		if("download".equals(request.getParameter("type"))){
			
			//通过点击第几页，展示说选择的页数的内容
			if (request.getParameter("pageNow") != null) {
				int targetPage = Integer.parseInt(request
						.getParameter("pageNow"));
				contentResult = tools.getDownloadContentsByPageNow(contentName,
						targetPage, pageSize, TYPE);
				request.setAttribute("pageNow", targetPage);
			} 
			//首次进入"表格下载->更多"栏目，pageNow默认为1
			else {
				contentResult = tools.getDownloadContentsByPageNow(contentName, pageNow, pageSize, TYPE);
				request.setAttribute("pageNow", pageNow);
			}
			request.setAttribute("contentResult", contentResult);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("contentName", contentName);
			request.setAttribute("tableType", request.getParameter("tableType"));
			request.setAttribute("contentNameChinese", ToolUtils.getItemName(contentName));
			
			flag = "download_targetContent";
		}
		 
		return flag;
	}

	
}
