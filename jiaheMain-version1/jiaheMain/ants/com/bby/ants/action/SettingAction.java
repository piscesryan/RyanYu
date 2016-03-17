package com.bby.ants.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bby.ants.util.JSFUtil;
import com.bby.ants.vo.LogVo;
import com.bby.ants.vo.NodeVo;


@ManagedBean(name = "settingAction")
@SessionScoped
public class SettingAction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<NodeVo> nvs;
	private List<NodeVo> nvs2;
	private List<NodeVo> nvs3;
	private List<NodeVo> nvs4;
	private List<LogVo> lvs;
	private String[] abc=new String[]{"A","B","C","D","E","F","G","H"};
	private NodeVo[] selectedNode;
	
	@PostConstruct
	public void init(){
		nvs=new ArrayList<NodeVo>();
		nvs2=new ArrayList<NodeVo>();
		nvs3=new ArrayList<NodeVo>();
		for(int i=1;i<8;i++){
			NodeVo vo=new NodeVo();
			vo.setId(i);
			vo.setName("散热片"+abc[i-1]);
			nvs.add(vo);
		}
		for(int i=1;i<8;i++){
			NodeVo vo=new NodeVo();
			vo.setId(i);
			vo.setName("网关"+i);
			nvs2.add(vo);
		}
		NodeVo vo1=new NodeVo();
		vo1.setId(1);
		vo1.setName("散热片");
		nvs3.add(vo1);
		NodeVo vo2=new NodeVo();
		vo2.setId(2);
		vo2.setName("阻流线圈");
		nvs3.add(vo2);
		NodeVo vo3=new NodeVo();
		vo3.setId(3);
		vo3.setName("散热片B相");
		nvs3.add(vo3);
		NodeVo vo4=new NodeVo();
		vo4.setId(4);
		vo4.setName("散热片C相");
		nvs3.add(vo4);
		
		initNVS4();
		initLog();
	}
	
	public void testAction(){
		String classId=JSFUtil.getParameter("classID");
		System.out.println(classId);
	}
	
	private void initLog(){
		lvs=new ArrayList<LogVo>();
		LogVo lv=new LogVo();
		lv.setEvent("查询历史事件");
		lv.setId(1);
		lv.setOperateDate(new Date());
		lv.setPhone("13841525241");
		lv.setUserId("321452");
		lv.setUsername("abc123");
		lvs.add(lv);
		lv=new LogVo();
		lv.setId(2);
		lvs.add(lv);
		lv=new LogVo();
		lv.setId(3);
		lvs.add(lv);
		lv=new LogVo();
		lv.setId(4);
		lvs.add(lv);
		lv=new LogVo();
		lv.setId(5);
		lvs.add(lv);
		
	}
	
	private void initNVS4(){
		setNvs4(new ArrayList<NodeVo>());
		NodeVo vo1=new NodeVo();
		vo1.setName("散热片A相");
		vo1.setId(1);
		vo1.setBelongTransmitter("CO1发射机");
		vo1.setBelongDeive("整流柜");
		vo1.setValue(500);
		vo1.setCreateDate(new Date());
		nvs4.add(vo1);
		
		vo1=new NodeVo();
		vo1.setName("散热片B相");
		vo1.setId(2);
		vo1.setBelongTransmitter("CO1发射机");
		vo1.setBelongDeive("功放柜");
		vo1.setValue(343);
		vo1.setCreateDate(new Date());
		nvs4.add(vo1);
		
		vo1=new NodeVo();
		vo1.setName("散热片B相");
		vo1.setId(3);
		vo1.setBelongTransmitter("CO1发射机");
		vo1.setBelongDeive("功放柜");
		vo1.setValue(342);
		vo1.setCreateDate(new Date());
		nvs4.add(vo1);
		
		vo1=new NodeVo();
		vo1.setName("散热片B相");
		vo1.setId(4);
		vo1.setBelongTransmitter("CO1发射机");
		vo1.setBelongDeive("功放柜");
		vo1.setValue(23);
		vo1.setCreateDate(new Date());
		nvs4.add(vo1);
		
		vo1=new NodeVo();
		vo1.setName("散热片B相");
		vo1.setId(5);
		vo1.setBelongTransmitter("CO1发射机");
		vo1.setBelongDeive("功放柜");
		vo1.setValue(34);
		vo1.setCreateDate(new Date());
		nvs4.add(vo1);
		
		vo1=new NodeVo();
		vo1.setName("散热片B相");
		vo1.setId(5);
		vo1.setBelongTransmitter("CO2发射机");
		vo1.setBelongDeive("功放柜");
		vo1.setValue(34);
		vo1.setCreateDate(new Date());
		nvs4.add(vo1);
		
		vo1=new NodeVo();
		vo1.setName("散热片B相");
		vo1.setId(6);
		vo1.setBelongTransmitter("CO2发射机");
		vo1.setBelongDeive("功放柜");
		vo1.setValue(34);
		vo1.setCreateDate(new Date());
		nvs4.add(vo1);
		
		vo1=new NodeVo();
		vo1.setName("散热片B相");
		vo1.setId(7);
		vo1.setBelongTransmitter("CO2发射机");
		vo1.setBelongDeive("功放柜");
		vo1.setValue(34);
		vo1.setCreateDate(new Date());
		nvs4.add(vo1);
	}

	public List<NodeVo> getNvs() {
		return nvs;
	}

	public void setNvs(List<NodeVo> nvs) {
		this.nvs = nvs;
	}

	public String[] getAbc() {
		return abc;
	}

	public void setAbc(String[] abc) {
		this.abc = abc;
	}

	public List<NodeVo> getNvs2() {
		return nvs2;
	}

	public void setNvs2(List<NodeVo> nvs2) {
		this.nvs2 = nvs2;
	}

	public List<NodeVo> getNvs3() {
		return nvs3;
	}

	public void setNvs3(List<NodeVo> nvs3) {
		this.nvs3 = nvs3;
	}

	public List<NodeVo> getNvs4() {
		return nvs4;
	}

	public void setNvs4(List<NodeVo> nvs4) {
		this.nvs4 = nvs4;
	}

	public List<LogVo> getLvs() {
		return lvs;
	}

	public void setLvs(List<LogVo> lvs) {
		this.lvs = lvs;
	}

	public NodeVo[] getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(NodeVo[] selectedNode) {
		this.selectedNode = selectedNode;
	}
}
