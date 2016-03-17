package com.bby.ants.service;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bby.ants.dao.MenuMapper;
import com.bby.ants.entity.Menu;
import com.bby.ants.entity.MenuExample;






public class MenuService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "menuMapper")
	private MenuMapper menuMapper;
	
	public List<Menu> findAllMenus(){
		MenuExample example=new MenuExample();
		return menuMapper.selectByExample(example);
	}
	
	 public void updateMenuList(String name, Menu db) {
		   if (db == null) {
		    return;
		   }
		   MenuExample example = new MenuExample();
		   MenuExample.Criteria criteria = example.createCriteria();
		   criteria.andMenuNameEqualTo(name);
		   menuMapper.updateByExampleSelective(db, example);
		  }

	
}
