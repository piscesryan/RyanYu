
package com.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tools.SqlTools;
import com.tools.ToolUtils;

public class Action_Common extends ActionSupport {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String contentName = "";
	private String contentNameChinese = "";
	private int pageSize = 10;
	private int pageNow = 1;
	private int totalPages = -1;
	private ArrayList contentResult;

	private SqlTools sqlTools;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		//初始化
		request = (HttpServletRequest) ActionContext.getContext().get(
				ServletActionContext.HTTP_REQUEST);
		response = (HttpServletResponse) ActionContext.getContext().get(
				ServletActionContext.HTTP_RESPONSE);
		sqlTools = new SqlTools();
		sqlTools.ConnectDB();
		contentName = request.getParameter("type");
		totalPages = sqlTools.getTotalPages(contentName);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		

		//显示具体某一条记录内容
		if (request.getParameter("targetContentId") != null) {
			
			String s_id = request.getParameter("targetContentId");
			Integer id = Integer.parseInt(s_id);
			
			contentResult = sqlTools.getContents(contentName,id);
			
			request.setAttribute("contentName", contentName);
			request.setAttribute("contentNameChinese", ToolUtils.getItemName(contentName));
			request.setAttribute("contentResult", contentResult);
			
			return "targetContent";
			
		} 
		//显示第x页的内容
		else {
			//通过点击第几页，展示说选择的页数的内容
			if (request.getParameter("pageNow") != null) {
				int targetPage = Integer.parseInt(request
						.getParameter("pageNow"));
				contentResult = sqlTools.getContentsByPageNow(contentName,
						targetPage);
				request.setAttribute("pageNow", targetPage);
			} 
			//首次进入栏目，pageNow默认为1
			else {
				contentResult = sqlTools.getContentsByPageNow(contentName,pageNow);
				request.setAttribute("pageNow", pageNow);
			}
			request.setAttribute("contentResult", contentResult);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("contentName", contentName);
			request.setAttribute("contentNameChinese", ToolUtils.getItemName(contentName));
			
			return "listContent";
		}
		
	}

}
