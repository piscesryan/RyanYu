package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.entity.Gateway;
import com.bby.ants.entity.GatewayExample;
import com.bby.ants.entity.MonitordataExample;
import com.bby.ants.entity.Monitorpoints;
import com.bby.ants.entity.MonitorpointsExample;

public class ConfigurationService implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	@Resource(name = "gatewayService")
	private GateService gatewayService;
	@Resource(name = "monitorPointService")
	private MonitorpointService monitorPointService;
	
	//插入结点
	public void insertMonitorpoint(Monitorpoints record){
		monitorPointService.insertMonitorPoint(record);
	}
	//更新节点
	public void updateMonitorpoint(Monitorpoints record){
		monitorPointService.updateMonitorPoint(record);
	}
	//删除节点
	public void Monitorpoint(long id){
		monitorPointService.deleteMonitorPoint(id);
	}
	//查询节点
	public Monitorpoints queryMonitorpoint(long id){
		return monitorPointService.queryMonitorPoint(id);
	}
	public List<Monitorpoints> queryMonitorpoint(MonitorpointsExample example){
		return monitorPointService.queryMonitorPoint(example);
	}
	
	
	//插入网关信息
	public void insertGateway(Gateway record){
		gatewayService.insertDevice(record);
	}
	//更新网关信息
	public void updateGateway(Gateway record){
		gatewayService.updateDevice(record);
	}
	//删除网关信息
	public void deleteGateway(int id){
		gatewayService.deleteDevice(id);
	}
	//查询网关信息
	public Gateway queryGateway(int id){
		return gatewayService.queryDevice(id);
	}
	public List<Gateway> queryGateway(GatewayExample example){
		return gatewayService.queryDevice(example);
	}
}
