package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.dao.SenderMapper;
import com.bby.ants.entity.Sender;
import com.bby.ants.entity.SenderExample;

public class SenderService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Resource(name = "senderMapper")
	private SenderMapper senderMapper;

	// 插入发射机
	public void insertSender(Sender record) {
		senderMapper.insert(record);
	}

	// 删除发射机
	public void deleteSender(int id) {
		senderMapper.deleteByPrimaryKey(id);
	}

	// 更新发射机
	public void updateSender(Sender record) {
		senderMapper.updateByPrimaryKey(record);
	}
	
	//查询
	public Sender querySender(int id){
		return senderMapper.selectByPrimaryKey(id);
	}
	
	public List<Sender> querySender(SenderExample example){
		return senderMapper.selectByExample(example);
	}
}
