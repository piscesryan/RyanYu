package com.bby.ants.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.dao.AdduserlogMapper;
import com.bby.ants.dao.ComponentMapper;
import com.bby.ants.entity.Adduserlog;
import com.bby.ants.entity.AdduserlogExample;
import com.bby.ants.entity.Component;
import com.bby.ants.entity.ComponentExample;

public class AddUserlogService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource(name = "addUserlogMapper")
	private AdduserlogMapper addUserlogMapper;
	
	//插入
	public void insertUserlog(Adduserlog record){
		addUserlogMapper.insertSelective(record);
	}
	
	//删除
	public void deleteUserlog(int id){
		addUserlogMapper.deleteByPrimaryKey(id);
	}
	
	//更新
	public void updateUserlog(Adduserlog record){
		addUserlogMapper.updateByPrimaryKey(record);
	}
	
	//查询
	public Adduserlog queryUserlog(int id){
		return addUserlogMapper.selectByPrimaryKey(id);
	}
	
	public List<Adduserlog> queryUserlog(AdduserlogExample example){
		return addUserlogMapper.selectByExample(example);
	}
}
