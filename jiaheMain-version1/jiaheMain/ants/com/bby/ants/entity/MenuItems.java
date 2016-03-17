package com.bby.ants.entity;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.bby.ants.service.MenuService;
  
public class MenuItems {
    private List<Menu> nodes;  
    @ManagedProperty(value = "#{menuService}")
	private MenuService menuService;
      
    public MenuItems(List<Menu> nodes){  
        this.nodes = nodes;  
    }  
    
    public void buildTree(MenuModel menu){  
    	 if(null == nodes )
         {
         	return ;
         }
        for (Menu node : nodes) {  
//            long id = node.getMENU_ID();
            if (node.getParentId() == 0) {
            	/*if(node.getMenuName().equals("账户管理")&&node.getState()==-1){
            		node.setState(0);
            		menuService.updateMenuList(node.getMenuName(), node);
            	}*/
            	DefaultSubMenu subMenu = new DefaultSubMenu(node.getMenuName(), "ui-icon-circle-arrow-e");
                build(node,subMenu);  
                menu.addElement(subMenu);
            }  
        }  
    }  
      
    private void build(Menu node, DefaultSubMenu subMenu ){  
        List<Menu> children = getChildren(node);  
        if (!children.isEmpty()) {
        	//假定无子节点

        	  for (Menu child : children) 
              {
              	
              	DefaultMenuItem sitem = new DefaultMenuItem(child.getMenuName(), "ui-icon-disk");
              	//sitem.setUpdate(":#{component.namingContainer.parent.namingContainer.clientId}");
//              	sitem.setUpdate("centerPanel");
              	sitem.setAjax(true);
//              	sitem.setCommand("#{menuManagedBean.change('"+child.getURL()+"')}");
//              	sitem.setOncomplete("updateGrowl();");
              	sitem.setHref(child.getUrl());
              	sitem.setTarget("mainframe");
              	sitem.setIcon("<i style='' class='fa fa-desktop'></i>");
//              	sitem.setIconPos("");
              	//sitem.setStyle("background-image: url('image/logistic/dataBlue.png')");
              	subMenu.addElement(sitem);
                  //Long id = child.getMENU_ID();  
                  
                  //build(child, );  
              	
              	 
              	
              }  
            
        }   
    }  
      
    private List<Menu> getChildren(Menu node){  
    	//sort_num 问题
        List<Menu> children = new ArrayList<Menu>();  
        Long id = node.getMenuId();  
        if(null == nodes )
        {
        	return children;
        }
        for (Menu child : nodes) {  
            if (child != null && id.equals(child.getParentId())) {  
                children.add(child);  
            }  
        }  
        return children;  
    }

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	} 
    
}  