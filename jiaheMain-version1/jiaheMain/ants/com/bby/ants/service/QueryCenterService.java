package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.dao.ComponentMapper;
import com.bby.ants.dao.MonitordataMapper;
import com.bby.ants.dao.MonitorpointsMapper;
import com.bby.ants.dao.SenderMapper;
import com.bby.ants.entity.Component;
import com.bby.ants.entity.ComponentExample;
import com.bby.ants.entity.Monitordata;
import com.bby.ants.entity.MonitordataExample;
import com.bby.ants.entity.Monitorpoints;
import com.bby.ants.entity.MonitorpointsExample;
import com.bby.ants.entity.Sender;
import com.bby.ants.entity.SenderExample;

public class QueryCenterService implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	@Resource(name = "monitorPointService")
	private MonitorpointService mpService;
	@Resource(name = "monitorDataService")
	private MonitorDataService mdService;
	@Resource(name = "componentService")
	private ComponentService componentService;
	@Resource(name = "senderService")
	private SenderService senderService;
	
	//查询发射机信息
	private Sender querySenderInfo(int id){
		return senderService.querySender(id);
	}
	private List<Sender> querySenderInfo(SenderExample example){
		return senderService.querySender(example);
	}
	
	//查询设备信息
	private Component queryComponent(int id){
		return componentService.queryMonitorPoint(id);
	}
	private List<Component> queryComponent(ComponentExample example){
		return componentService.queryMonitorPoint(example);
	}
	
	//查询monitordata
	private Monitordata queryMonitorData(int id){
		return mdService.queryMonitorPoint(id);
	}
	private List<Monitordata> queryMonitorData(MonitordataExample example){
		return mdService.queryMonitorPoint(example);
	}
	
	//查询monitorpoints
	private Monitorpoints queryMonitorpoints(long id){
		return mpService.queryMonitorPoint(id);
	}
	private List<Monitorpoints> queryMonitorpoints(MonitorpointsExample example){
		return mpService.queryMonitorPoint(example);
	}
	
	//整合后返回的结果集
	public void getResult(){
		//...
	}

}
