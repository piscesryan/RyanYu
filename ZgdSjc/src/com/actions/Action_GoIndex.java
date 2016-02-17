package com.actions;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domains.domains.Sjtg.Contents_Sjtg;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tools.SqlTools;

public class Action_GoIndex extends ActionSupport {

	private static final int SJ = 1;
	private static final int GC = 2;
	
	private String table1 = "gzdt";
	private String table2 = "sjgk";
	private String table3 = "sjxw";
	private String table4 = "sjtg";
	private String table5 = "download";
	private SqlTools sqlTools;
	private int pageNow = 1;
	private int pageSize = 10;
	private int indexPageSize = 5;
	private int indexDownloadPageSize = 3;
	private ArrayList contentResult_Gzdt;
	private ArrayList contentResult_Sjgk;
	private ArrayList contentResult_sjxw;
	private ArrayList contentResult_sjtg;
	private ArrayList contentResult_download_sj;
	private ArrayList contentResult_download_gc;
	private HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		System.out.println(new Date().toLocaleString()+"------ÓÐÓÃ»§µÇÂ¼: "+request.getRemoteAddr());
		
		sqlTools = new SqlTools();
		sqlTools.ConnectDB();
		request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		contentResult_Gzdt = sqlTools.getContentsByPageNow(table1, pageNow, indexPageSize);
		contentResult_Sjgk = sqlTools.getContentsByPageNow(table2, pageNow, indexPageSize);
		contentResult_sjxw = sqlTools.getContentsByPageNow(table3, pageNow, indexPageSize);
		contentResult_sjtg = sqlTools.getContentsByPageNow(table4, pageNow, indexPageSize);
		contentResult_download_sj = sqlTools.getDownloadContentsByPageNow(table5, pageNow, indexDownloadPageSize, SJ); 
		contentResult_download_gc = sqlTools.getDownloadContentsByPageNow(table5, pageNow, indexDownloadPageSize, GC); 
		
		request.setAttribute("contentResult_Gzdt", contentResult_Gzdt);
		request.setAttribute("contentResult_Sjgk", contentResult_Sjgk);
		request.setAttribute("contentResult_sjxw", contentResult_sjxw);
		request.setAttribute("contentResult_sjtg", contentResult_sjtg);
		
		request.getSession().setAttribute("contentResult_download_sj", contentResult_download_sj);
		request.getSession().setAttribute("contentResult_download_gc", contentResult_download_gc);
		
		return ActionSupport.SUCCESS;
	}

	
}
