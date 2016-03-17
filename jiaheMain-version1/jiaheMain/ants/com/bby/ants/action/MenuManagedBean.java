package com.bby.ants.action;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

 
@ManagedBean
@SessionScoped
public class MenuManagedBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    
    private String url ="/experience_Center/experience_Center.xhtml";
    private String footUrl="/common/footer.xhtml";
    private String headerUrl="/common/header.xhtml";
   

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		
		this.url = url;
	}

	public MenuManagedBean(){
		
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext extContext =facesContext.getExternalContext();
		HttpSession session =(HttpSession)extContext.getSession(true);
		if(session.getAttribute("menus")!=null)
		{
		}else{
			try
			{
			/*	System.out.println(extContext.getRequestContextPath()+"/login.xhtml");*/
				FacesContext.getCurrentInstance().getExternalContext().redirect(extContext.getRequestContextPath()+"/login/login.xhtml");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			return ;
		}
		
	}	
	
	public void change(String url)
	{
		this.url = url;
//		RequestContext.getCurrentInstance().execute("PF('bar1').hide()");
	}
 
   
    public String openAction(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Open action has activiated asynchrounsly !"));
        return "";
    }
    
    public String nonajaxAction1(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajax Update"));
        url = "/example/table1.xhtml";
        return "";
    }
 
    public void nonAjaxAction(){
    	url = "/example/table2.xhtml";
        
    }
    
    public void nonAjaxAction1(){
    	url = "/example/editrow.xhtml";
        
    }

	public String getFootUrl() {
		return footUrl;
	}

	public void setFootUrl(String footUrl) {
		this.footUrl = footUrl;
	}

	public String getHeaderUrl() {
		return headerUrl;
	}

	public void setHeaderUrl(String headerUrl) {
		this.headerUrl = headerUrl;
	}
    
    
    
}
