package com.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domains.domains.Sjtg.ContentsFeedback;
import com.opensymphony.xwork2.ActionSupport;
import com.tools.SqlTools;
import com.tools.ToolUtils;

public class Action_Sjxsjb extends ActionSupport {
	
	private String contentName = "xsjb";
	
	private String name;
	private String contactWay;
	private String subjects;
	private String content;
	private ContentsFeedback feedback;
	private SqlTools sqlTools;

	public String execute() {
		return SUCCESS;
	}

	public String submit() {
		 
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//进入线索举报界面
		if ("gotoWrite".equals(request.getParameter("type"))) {
			return "gotoWrite";
		}
		//提交举报数据
		else {
			
			sqlTools = new SqlTools();
			sqlTools.ConnectDB();
			
			feedback = new ContentsFeedback();
			feedback.setContactWay(getContactWay());
			feedback.setContent(getContent());
			feedback.setName(getName());
			feedback.setSubjects(getSubjects());
			
/*			System.out.println(feedback.getName());
			System.out.println(feedback.getContactWay());
			System.out.println(feedback.getSubjects());
			System.out.println(feedback.getContent());*/
			
			if(sqlTools.insertRecordToDB(contentName, feedback)){
				return "success";
			}else{
				return "error";
			}

		}
	}

	public String getName() {
		return ToolUtils.changeToUTF(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactWay() {
		return ToolUtils.changeToUTF(contactWay);
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public String getSubjects() {
		return ToolUtils.changeToUTF(subjects);
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public String getContent() {
		return ToolUtils.changeToUTF(content);
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
