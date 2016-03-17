package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.entity.Adduserlog;
import com.bby.ants.entity.AdduserlogExample;
import com.bby.ants.entity.Gateway;
import com.bby.ants.entity.GatewayExample;
import com.bby.ants.entity.Monitorpoints;
import com.bby.ants.entity.MonitorpointsExample;
import com.bby.ants.entity.l_log;
import com.bby.ants.entity.l_logExample;

public class SystemLogService implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	@Resource(name = "l_logService")
	private L_LogService l_logService;
	@Resource(name = "addUserLogService")
	private AddUserlogService addUserlogService;
	
	//插入日志
	public void insertAddUserLog(l_log record){
		l_logService.insertLog(record);
	}
	//更新日志
	public void updateAddUserLog(l_log record){
		l_logService.updateLog(record);
	}
	//删除日志
	public void deleteAddUserLog(long logId){
		l_logService.deleteLog(logId);
	}
	//查询日志
	public l_log queryAddUserLog(long logId){
		return l_logService.queryLog(logId);
	}
	public List<l_log> queryAddUserLog(l_logExample example){
		return l_logService.queryLog(example);
	}
	
	
	//插入用户信息
	public void insertUserlog(Adduserlog record){
		addUserlogService.insertUserlog(record);
	}
	//更新用户信息
	public void updateUserlog(Adduserlog record){
		addUserlogService.updateUserlog(record);
	}
	//删除用户信息
	public void deleteUserlog(int id){
		addUserlogService.deleteUserlog(id);
	}
	//查询用户信息
	public Adduserlog queryUserlog(int id){
		return addUserlogService.queryUserlog(id);
	}
	public List<Adduserlog> queryUserlog(AdduserlogExample example){
		return addUserlogService.queryUserlog(example);
	}
}
