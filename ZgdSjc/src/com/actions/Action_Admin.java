package com.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.domains.domains.Sjtg.ContentDownload;
import com.domains.domains.Sjtg.ContentGwzz;
import com.domains.domains.Sjtg.Contents_Sjtg;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tools.SqlTools;
import com.tools.ToolUtils;

public class Action_Admin extends ActionSupport {

	private HttpServletRequest request;
	private String flag = null;
	private String contentName = null;
	private int pageSize = 10;
	private int pageNow = 1;
	private int totalPages = -1;
	private ArrayList contentResult;
	private SqlTools sqlTools;
	
	private String userName;
	private String passwd;
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		//初始化
		request = (HttpServletRequest) ActionContext.getContext().get(
				ServletActionContext.HTTP_REQUEST);
		sqlTools = new SqlTools();
		sqlTools.ConnectDB();
		
		//进入登录页面
		if("gotoLogin".equals(request.getParameter("type"))){
			
			if(request.getSession().getAttribute("userName")!=null){
				flag = "login";
			}else{
				flag = "gotoLogin";
			}
		}
		//验证登录信息
		if("login".equals(request.getParameter("type"))){
			
			//到数据库验证账号密码
			//...........................................................
			if(request.getSession().getAttribute("userName")!=null){
				flag = "login";
			}else{
				String userName = request.getParameter("userName");
				String passwd = request.getParameter("passwd");
				if("admin".equals(userName) && "admin123".equals(passwd)){
					flag = "login";
					request.getSession().setAttribute("userName", userName);
					request.getSession().setAttribute("passwd", passwd);
				}else{
					flag = "gotoLogin";
					request.setAttribute("loginError", "用户名密码不正确 !");
				}
			}
		}
		//发表新的内容
		if("new".equals(request.getParameter("type"))){
		
			String contentName = request.getParameter("name");
			
			//operation参数用来判断是编辑具体数据，还是数据已经编辑好，要保存
			if("save".equals(request.getParameter("operation"))){
		
				String title = (String) request.getParameter("title");
				String type = (String) request.getParameter("filetype");
				String time = (String) request.getParameter("writetime");
				String content = (String) request.getParameter("content");
//System.out.println("Action_Admin-109"+type);				
				if("download".equals(contentName)){
					ContentDownload target = new ContentDownload();
					target.setFileName(title);
					target.setType(type);
					
					if(sqlTools.insertRecordToDB(contentName, target)){		
						flag = "success";
					}else{
						flag = "error";
					}
					
				}else if("gwzz".equals(contentName)){
					String jobname = (String) request.getParameter("jobname");
					String name = (String) request.getParameter("personname");
					String duty = (String) request.getParameter("duty");
					String addrContent = (String) request.getParameter("addrContent");
					
					ContentGwzz target = new ContentGwzz();
					target.setAddrContent(addrContent);
					target.setDuty(duty);
					target.setJobname(jobname);
					target.setName(name);
					
					if(sqlTools.insertRecordToDB(contentName, target)){		
						flag = "success";
					}else{
						flag = "error";
					}
				}
				else{
					Contents_Sjtg target = new Contents_Sjtg();
					target.setContent(content);
					target.setTime(time);
					target.setTilte(title);
				
					if(sqlTools.insertRecordToDB(contentName, target)){		
						flag = "success";
					}else{
						flag = "error";
					}
				}
			//operation为空，则是发表
			}else{			
				request.setAttribute("contentName", contentName);

				flag = "newEdit";
			}
		}
		//展示已有内容...分页
		if("show".equals(request.getParameter("type"))){
			
			contentName = request.getParameter("name");
			
			//点击了第几页
			if(request.getParameter("pageNow")!=null){
				int targetPage = Integer.parseInt(request.getParameter("pageNow"));
				request.setAttribute("pageNow", targetPage);
				contentResult = sqlTools.getContentsByPageNow(contentName,targetPage);
			}
			//首次进入
			else{
				
				if("gwzz".equals(contentName)){
					contentResult = sqlTools.getContents(contentName, null);
				}else{
					contentResult = sqlTools.getContentsByPageNow(contentName, pageNow);
					if(contentResult==null){
						contentResult = new ArrayList();
					}
					request.setAttribute("pageNow", pageNow);
				}
			}
			
			totalPages = sqlTools.getTotalPages(contentName);
			
			
			request.setAttribute("contentResult", contentResult);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("contentName", contentName);
			
			flag = "show";
		}
		//查看具体的一条内容
		if("look".equals(request.getParameter("type"))){
			
			//获得相应参数
			contentName = request.getParameter("name");
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			//从数据库查询具体内容
			contentResult = sqlTools.getContents(contentName, id);
			
			request.setAttribute("contentName", contentName);
			request.setAttribute("contentResult", contentResult);
			flag = "targetContent";
		}
		//删除具体的一条内容
		if("delete".equals(request.getParameter("type"))){
			//获得相应参数
			contentName = request.getParameter("name");
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			//删除指定的记录
			System.out.println(sqlTools.deleteTargentContent(contentName, id));
			
			//如果是下载列表里的文件，那么到硬盘上删除
			if("download".equals(contentName)){
				String fileName = request.getParameter("fileName");
				String path = ServletActionContext.getServletContext().getRealPath("/")+"upload/admin/files/"+fileName;
				File file = new File(path);
				
				System.out.println("fileName="+fileName);
				System.out.println("path="+path);
				System.out.println(file.delete());
				
			}
			
			//首次进入删除后的内容		
			if("gwzz".equals(contentName)){
				contentResult = sqlTools.getContents(contentName, null);
			}else{
				contentResult = sqlTools.getContentsByPageNow(contentName, pageNow);
				request.setAttribute("pageNow", pageNow);
			}
			
			
			totalPages = sqlTools.getTotalPages(contentName);
			
			
			request.setAttribute("contentResult", contentResult);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("contentName", contentName);
			
			flag = "show";
		}
		//编辑具体的一条内容
		if("edit".equals(request.getParameter("type"))){
			
			String contentName = request.getParameter("name");
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			//operation参数用来判断是编辑具体数据，还是数据已经编辑好，要保存
			if("save".equals(request.getParameter("operation"))){
		
				
				
				if("gwzz".equals(request.getParameter("name"))){
					
					String jobname = (String) request.getParameter("jobname");
					String name = (String) request.getParameter("personname");
					String duty = (String) request.getParameter("duty");
					String addrContent = (String) request.getParameter("addrContent");
					
					ContentGwzz target = new ContentGwzz();
					target.setAddrContent(addrContent);
					target.setDuty(duty);
					target.setId(id);
					target.setJobname(jobname);
					target.setName(name);
					
					if(sqlTools.updateRecord(contentName, target)){						
						flag = "success";
					}else{
						flag = "error";
					}
					
				}else if("download".equals(request.getParameter("name"))){
					String fileType = request.getParameter("fileType");
					
					ContentDownload target = new ContentDownload();
					target.setId(id);
					target.setType(fileType);
					
					if(sqlTools.updateRecord(contentName, target)){						
						flag = "success";
					}else{
						flag = "error";
					}
					
				}else{
					
					String title = (String) request.getParameter("title");
					String time = (String) request.getParameter("writetime");
					String content = (String) request.getParameter("content");
					
					Contents_Sjtg target = new Contents_Sjtg();
					target.setContent(content);
					target.setId(id);
					target.setTime(time);
					target.setTilte(title);
					
					if(sqlTools.updateRecord(contentName, target)){						
						flag = "success";
					}else{
						flag = "error";
					}
				}
				
			}else{			
				contentResult = sqlTools.getContents(contentName, id);
				request.setAttribute("contentResult", contentResult);
				request.setAttribute("contentName", contentName);
				
				flag = "edit";
			}
		}
		//下载
		if("download".equals(request.getParameter("type"))){
			
			/*String fileName = request.getParameter("fileName");
			
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			response.setHeader("Content-disposition", "attachment;filename="+fileName+"");
			response.setHeader("Content-Type", "text/plain");
			
			
			InputStream is = Action_Admin.class.getResourceAsStream("/files/"+fileName+"");
			OutputStream os = response.getOutputStream();*/
			String fileName = request.getParameter("fileName");
			fileName = ToolUtils.changeStringToChinese(fileName);
			String path = ServletActionContext.getServletContext().getRealPath("/")+"upload/admin/files/"+fileName;
		
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			response.setHeader("Content-Type", "text/plain;");
			response.setHeader("Content-disposition", "attachment;filename="+java.net.URLEncoder.encode(fileName,"UTF-8")+"");
			
			 
			
		
			
			//InputStream fis = this.getClass().getClassLoader().getResourceAsStream(fileName);
			InputStream fis = new FileInputStream(path);
			OutputStream fos = response.getOutputStream();
			
			ToolUtils.downloadFiles(fis, fos);
		}
		if("logout".equals(request.getParameter("type"))){
			
			request.getSession().setMaxInactiveInterval(0);
			flag = "toIndex";
		}
		
		return flag;
			
	}

	
}
