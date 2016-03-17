package com.bby.ants.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bby.ants.entity.Menu;
import com.bby.ants.entity.MenuItems;
import com.bby.ants.service.MenuService;
import com.bby.ants.util.HttpSessionUtil;

@ManagedBean(name = "loginAction")
@SessionScoped
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{menuService}")
	private MenuService menuService;
	private MenuModel menuModel = new DefaultMenuModel();
	private MenuModel menuModel1 = new DefaultMenuModel();
	private List<Menu> menus;
	private List<Menu> menus1;

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void logOut() {
		HttpSession session = HttpSessionUtil.getHttpSession();
		session.removeAttribute("loginUser");
		session.removeAttribute("menus");

		session.removeAttribute("menuModel");
		String path = HttpSessionUtil.getServerPath2();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(path + "login/login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logUser() {
		menuModel1 = new DefaultMenuModel();
		HttpSession session = HttpSessionUtil.getHttpSession();
		List<Menu> menuss = new ArrayList<Menu>();
		menuss = menuService.findAllMenus();
		Menu menu = new Menu();
		if (menuss != null) {
			menus1 = new ArrayList<Menu>();
			for (int i = 0; i < menuss.size(); i++) {
				menu = menuss.get(i);
				if (menu.getState() == -1) {
					Menu vo = new Menu();// 注意初始化位置
					vo.setMenuId(menu.getMenuId());
					vo.setMenuName(menu.getMenuName());
					vo.setSortNum(menu.getSortNum());
					vo.setParentId(menu.getParentId());
					vo.setUrl(menu.getUrl());
					vo.setTitle(menu.getTitle());
					vo.setState(menu.getState());
					vo.setImage(menu.getImage());
					vo.setRemark(menu.getRemark());
					menus1.add(vo);
				}

			}

		}

		session.setAttribute("menus1", menus1);
		MenuItems tree = new MenuItems(menus1);

		tree.buildTree(menuModel1);
		session.setAttribute("menuModel1", menuModel1);
		String path = HttpSessionUtil.getServerPath2();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(path + "mainFrame/mainPanels1.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		menuModel = new DefaultMenuModel();
		List<Menu> menuss = menuService.findAllMenus();

		Menu menu = new Menu();
		if (menuss != null) {
			menus = new ArrayList<Menu>();
			for (int i = 0; i < menuss.size(); i++) {
				menu = menuss.get(i);
				if (menu.getState() == 0) {
					Menu vo = new Menu();// 注意初始化位置
					vo.setMenuId(menu.getMenuId());
					vo.setMenuName(menu.getMenuName());
					vo.setSortNum(menu.getSortNum());
					vo.setParentId(menu.getParentId());
					vo.setUrl(menu.getUrl());
					vo.setTitle(menu.getTitle());
					vo.setState(menu.getState());
					vo.setImage(menu.getImage());
					vo.setRemark(menu.getRemark());
					menus.add(vo);
				}

			}

		}

		session.setAttribute("menus", menus);
		MenuItems tree = new MenuItems(menus);

		tree.buildTree(menuModel);
		session.setAttribute("menuModel", menuModel);
		response.sendRedirect("deviceOverall.xhtml");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		menus = new ArrayList<Menu>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(config.getServletContext());
		menuService = (MenuService) webApplicationContext.getBean("menuService");
		super.init(config);

	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public MenuModel getMenuModel1() {
		return menuModel1;
	}

	public void setMenuModel1(MenuModel menuModel1) {
		this.menuModel1 = menuModel1;
	}

	public List<Menu> getMenus1() {
		return menus1;
	}

	public void setMenus1(List<Menu> menus1) {
		this.menus1 = menus1;
	}

}
