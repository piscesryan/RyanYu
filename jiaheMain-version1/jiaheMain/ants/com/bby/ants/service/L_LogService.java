package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.dao.AdduserlogMapper;
import com.bby.ants.dao.l_logMapper;
import com.bby.ants.entity.Adduserlog;
import com.bby.ants.entity.l_log;
import com.bby.ants.entity.l_logExample;

 

public class L_LogService implements Serializable{

	private static final long serialVersionUID = 1L;
	@Resource(name = "l_logMapper")
	private l_logMapper l_logMapper;
	@Resource(name = "addUserlogMapper")
	private AdduserlogMapper addUserlogMapper;
	/**
	 * 系统日志->添加日志
	 * @param record
	 * @return
	 */	
	public int insertLog(l_log record){
		//System.out.println("processing...");
		return l_logMapper.insert(record);
	}
	/**
	 * 系统日志->更新日志（通过主键更新）
	 * @param record
	 * @return
	 */
	public int updateLog(l_log record){
		/*GatewayExample example = new GatewayExample();
		example.setOrderByClause(orderByClause);*/
		return l_logMapper.updateByPrimaryKey(record);
	}
	/**
	 * 系统日志->删除设备（通过主键删除）
	 * @param id
	 * @return
	 */
	public int deleteLog(long logId){
		return l_logMapper.deleteByPrimaryKey(logId);
	}
	//查询日志
	public l_log queryLog(long logId){
		return l_logMapper.selectByPrimaryKey(logId);
	}
	public List<l_log> queryLog(l_logExample example){
		return l_logMapper.selectByExample(example);
	}
	
	
	
	
	/**
	 * 系统日志->添加用户
	 * @param id
	 * @return
	 *//*
	public int addUserlogInsert(Adduserlog record){
		return addUserlogMapper.insert(record);
	}
	
	*//**
	 * 系统日志->更新用户
	 * @param id
	 * @return
	 *//*
	public int updateUserlog(Adduserlog record){
		return addUserlogMapper.updateByPrimaryKey(record);
	}
	
	*//**
	 * 系统日志->删除用户
	 * @param id
	 * @return
	 *//*
	public int deleteUserlog(Integer Id){
		return addUserlogMapper.deleteByPrimaryKey(Id);
	}*/
	 
}
