package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.dao.MonitordataMapper;
import com.bby.ants.entity.Monitordata;
import com.bby.ants.entity.MonitordataExample;

public class MonitorDataService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource(name = "mdMapper")
	private MonitordataMapper mdMapper;
	
	//插入
	public void insertMonitorPoint(Monitordata record){
		mdMapper.insertSelective(record);
	}
	
	//删除
	public void deleteMonitorPoint(long id){
		mdMapper.deleteByPrimaryKey(id);
	}
	
	//更新
	public void updateMonitorPoint(Monitordata record){
		mdMapper.updateByPrimaryKey(record);
	}
	
	//查询
	public Monitordata queryMonitorPoint(long id){
		return mdMapper.selectByPrimaryKey(id);
	}
	
	public List<Monitordata> queryMonitorPoint(MonitordataExample example){
		return mdMapper.selectByExample(example);
	}
}
