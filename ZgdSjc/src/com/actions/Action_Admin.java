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

		//��ʼ��
		request = (HttpServletRequest) ActionContext.getContext().get(
				ServletActionContext.HTTP_REQUEST);
		sqlTools = new SqlTools();
		sqlTools.ConnectDB();
		
		//�����¼ҳ��
		if("gotoLogin".equals(request.getParameter("type"))){
			
			if(request.getSession().getAttribute("userName")!=null){
				flag = "login";
			}else{
				flag = "gotoLogin";
			}
		}
		//��֤��¼��Ϣ
		if("login".equals(request.getParameter("type"))){
			
			//�����ݿ���֤�˺�����
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
					request.setAttribute("loginError", "�û������벻��ȷ !");
				}
			}
		}
		//�����µ�����
		if("new".equals(request.getParameter("type"))){
		
			String contentName = request.getParameter("name");
			
			//operation���������ж��Ǳ༭�������ݣ����������Ѿ��༭�ã�Ҫ����
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
			//operationΪ�գ����Ƿ���
			}else{			
				request.setAttribute("contentName", contentName);

				flag = "newEdit";
			}
		}
		//չʾ��������...��ҳ
		if("show".equals(request.getParameter("type"))){
			
			contentName = request.getParameter("name");
			
			//����˵ڼ�ҳ
			if(request.getParameter("pageNow")!=null){
				int targetPage = Integer.parseInt(request.getParameter("pageNow"));
				request.setAttribute("pageNow", targetPage);
				contentResult = sqlTools.getContentsByPageNow(contentName,targetPage);
			}
			//�״ν���
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
		//�鿴�����һ������
		if("look".equals(request.getParameter("type"))){
			
			//�����Ӧ����
			contentName = request.getParameter("name");
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			//�����ݿ��ѯ��������
			contentResult = sqlTools.getContents(contentName, id);
			
			request.setAttribute("contentName", contentName);
			request.setAttribute("contentResult", contentResult);
			flag = "targetContent";
		}
		//ɾ�������һ������
		if("delete".equals(request.getParameter("type"))){
			//�����Ӧ����
			contentName = request.getParameter("name");
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			//ɾ��ָ���ļ�¼
			System.out.println(sqlTools.deleteTargentContent(contentName, id));
			
			//����������б�����ļ�����ô��Ӳ����ɾ��
			if("download".equals(contentName)){
				String fileName = request.getParameter("fileName");
				String path = ServletActionContext.getServletContext().getRealPath("/")+"upload/admin/files/"+fileName;
				File file = new File(path);
				
				System.out.println("fileName="+fileName);
				System.out.println("path="+path);
				System.out.println(file.delete());
				
			}
			
			//�״ν���ɾ���������		
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
		//�༭�����һ������
		if("edit".equals(request.getParameter("type"))){
			
			String contentName = request.getParameter("name");
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			//operation���������ж��Ǳ༭�������ݣ����������Ѿ��༭�ã�Ҫ����
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
		//����
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
