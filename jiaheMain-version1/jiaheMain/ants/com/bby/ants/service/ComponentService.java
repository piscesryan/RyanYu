package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.dao.ComponentMapper;
import com.bby.ants.dao.MonitordataMapper;
import com.bby.ants.entity.Component;
import com.bby.ants.entity.ComponentExample;
import com.bby.ants.entity.Monitordata;
import com.bby.ants.entity.MonitordataExample;

public class ComponentService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource(name = "componentMapper")
	private ComponentMapper componentMapper;
	
	//插入
	public void insertMonitorPoint(Component record){
		componentMapper.insertSelective(record);
	}
	
	//删除
	public void deleteMonitorPoint(int id){
		componentMapper.deleteByPrimaryKey(id);
	}
	
	//更新
	public void updateMonitorPoint(Component record){
		componentMapper.updateByPrimaryKey(record);
	}
	
	//查询
	public Component queryMonitorPoint(int id){
		return componentMapper.selectByPrimaryKey(id);
	}
	
	public List<Component> queryMonitorPoint(ComponentExample example){
		return componentMapper.selectByExample(example);
	}
}
