package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.dao.GatewayMapper;
import com.bby.ants.dao.MonitorpointsMapper;
import com.bby.ants.entity.Gateway;
import com.bby.ants.entity.GatewayExample;
import com.bby.ants.entity.Monitorpoints;

public class GateService implements Serializable{

	private static final long serialVersionUID = 1L;
	@Resource(name = "gatewayMapper")
	private GatewayMapper gatewayMapper;
	@Resource(name = "mpMapper")
	private MonitorpointsMapper mpMapper;
	
	/**
	 * 配置->添加设备
	 * @param record
	 * @return
	 */	
	public int insertDevice(Gateway record){
		//System.out.println("processing...");
		return gatewayMapper.insert(record);
	}
	/**
	 * 配置->编辑设备（通过主键更新）
	 * @param record
	 * @return
	 */
	public int updateDevice(Gateway record){
		/*GatewayExample example = new GatewayExample();
		example.setOrderByClause(orderByClause);*/
		return gatewayMapper.updateByPrimaryKey(record);
	}
	/**
	 * 配置->删除设备（通过主键删除）
	 * @param id
	 * @return
	 */
	public int deleteDevice(Integer id){
		return gatewayMapper.deleteByPrimaryKey(id);
	}
	
	//查询
	public Gateway queryDevice(int id){
		return gatewayMapper.selectByPrimaryKey(id);
	}
	public List<Gateway> queryDevice(GatewayExample example){
		return gatewayMapper.selectByExample(example);
	}
	
	
	/**
	 * 配置->添加节点
	 * @param record
	 * @return
	 *//*	
	public int insertMonitorPoint(Monitorpoints record){
		//System.out.println("processing...");
		return mpMapper.insert(record);
	}
	*//**
	 * 配置->编辑设备（通过主键更新）
	 * @param record
	 * @return
	 *//*
	public int updateMonitorPoint(Monitorpoints record){
		GatewayExample example = new GatewayExample();
		example.setOrderByClause(orderByClause);
		return mpMapper.updateByPrimaryKey(record);
	}
	*//**
	 * 配置->删除设备（通过主键删除）
	 * @param id
	 * @return
	 *//*
	public int deleteMonitorPoint(long id){
		return mpMapper.deleteByPrimaryKey(id);
	}*/
}
