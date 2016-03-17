package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.entity.Alarminfo;

public class AlarmManageService implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	@Resource(name = "alarmService")
	private AlarmService alarmService;
	
	//------------------------
	//处理告警、重发告警设置相关属性和方法
	//------------------------
	
	
	//查询（通过设置告警等级、处理情况、开始时间 、结束时间 后返回的数据集）
	public List<Alarminfo> query(String alarmtype, String searchDateStart, String searchDateEnd, String result){
		return alarmService.find(alarmtype, searchDateStart, searchDateEnd, result);
	}
	
	//增加告警节点信息
	public void insertAlarmNode(Alarminfo record){
		alarmService.insertAlarmNode(record);
	}
	//修改告警节点信息
	public void updateAlarmNode(Alarminfo record){
		alarmService.updateAlarmNode(record);
	}
	//删除告警节点信息
	public void deleteAlarmNode(long id){
		alarmService.deleteAlarmNode(id);
	}
}
