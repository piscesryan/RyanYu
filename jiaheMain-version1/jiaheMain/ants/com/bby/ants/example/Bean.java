package com.bby.ants.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class Bean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Tab> tabs;

    @PostConstruct
    public void init() {
        tabs = new ArrayList<>();
    }

    public void add() {
        tabs.add(new Tab("tab" + tabs.size(), "some content"));
    }

    public void remove(Tab tab) {
        tabs.remove(tab);
    }

    public List<Tab> getTabs() {
        return tabs;
    }

}