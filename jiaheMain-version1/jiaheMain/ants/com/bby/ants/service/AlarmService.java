package com.bby.ants.service;


import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import com.bby.ants.dao.AlarminfoMapper;
import com.bby.ants.entity.Alarminfo;
import com.bby.ants.entity.AlarminfoExample;







public class AlarmService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "alarminfoMapper")
	private AlarminfoMapper alarminfoMapper;
	
	//告警等级分为预警、越界、告警 显示注意：黄色表示预警、橙色表示越界、红色表示告警
	public List<Alarminfo> find(String alarmtype, String searchDateStart,String searchDateEnd,String result){
		AlarminfoExample alarminfoExample=new AlarminfoExample();
		AlarminfoExample.Criteria alarminfoCriteria = alarminfoExample.createCriteria();
				if(searchDateStart!=null){
		        	if(searchDateEnd!=null){
		        		alarminfoCriteria.andAlarmtimeBetween(searchDateStart, searchDateEnd);
		        	}else{
		        		alarminfoCriteria.andAlarmtimeGreaterThanOrEqualTo(searchDateStart);
		        	}
		        }else{
		        	if(searchDateEnd!=null){
		        		alarminfoCriteria.andAlarmtimeLessThanOrEqualTo(searchDateEnd);
		        	}
		        }
				if(!alarmtype.equalsIgnoreCase("所有"))
				{
					alarminfoCriteria.andAlarmtypeEqualTo(alarmtype);
				}
				alarminfoCriteria.andResultEqualTo(result);
			List<Alarminfo> infos= alarminfoMapper.selectByExample(alarminfoExample);
			return infos;
	}
	
	/**
	 * 插入测温点告警节点
	 * @param record
	 * @return
	 */
	public int insertAlarmNode(Alarminfo record){
		return alarminfoMapper.insert(record);
	}
	
	/**
	 * 更新测温点告警节点
	 * @param record
	 * @return
	 */
	public int updateAlarmNode(Alarminfo record){
		return alarminfoMapper.updateByPrimaryKey(record);
	}
	
	/**
	 * 删除测温点告警节点
	 * @param record
	 * @return
	 */
	public int deleteAlarmNode(long id){
		return alarminfoMapper.deleteByPrimaryKey(id);
	}
	
}
