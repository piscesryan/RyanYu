package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.dao.MonitorpointsMapper;
import com.bby.ants.entity.Monitordata;
import com.bby.ants.entity.MonitordataExample;
import com.bby.ants.entity.Monitorpoints;
import com.bby.ants.entity.MonitorpointsExample;

 

public class MonitorpointService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Resource(name = "mpMapper")
	private MonitorpointsMapper mpMapper;
	
	//插入
	public void insertMonitorPoint(Monitorpoints record){
		mpMapper.insertSelective(record);
	}
	
	//删除
	public void deleteMonitorPoint(long id){
		mpMapper.deleteByPrimaryKey(id);
	}
	
	//更新
	public void updateMonitorPoint(Monitorpoints record){
		mpMapper.updateByPrimaryKey(record);
	}
	
	//查询
	public Monitorpoints queryMonitorPoint(long id){
		return mpMapper.selectByPrimaryKey(id);
	}
	
	public List<Monitorpoints> queryMonitorPoint(MonitorpointsExample example){
		return mpMapper.selectByExample(example);
	}
}
