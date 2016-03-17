package com.bby.ants.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Messages
{
	static public void info(String detail) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", detail));
    }
    
	static public void warn(String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", detail));
    }
    
	static public void error(String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", detail));
    }
    
	static public void fatal(String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", detail));
    }
}
