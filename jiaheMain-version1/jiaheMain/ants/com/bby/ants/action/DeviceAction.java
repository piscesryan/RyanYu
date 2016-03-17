package com.bby.ants.action;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.functions.Now;

import com.bby.ants.util.HttpSessionUtil;
import com.bby.ants.util.Messages;
import com.bby.ants.vo.DeviceVo;
import com.google.common.collect.Maps;

@ManagedBean(name = "deviceAction")
@SessionScoped
public class DeviceAction implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<DeviceVo> transDeviceVos;
	
	private List<DeviceVo> feedTubeDeviceVos;
	
	private List<DeviceVo> powerCabinetDeviceVos;
	
	private List<DeviceVo> outputCabinetDeviceVos ;
	
	private List<DeviceVo> rectifierCabinetDeviceVos ;
	
	
	public List<DeviceVo> getPowerCabinetDeviceVos()
	{
		return powerCabinetDeviceVos;
	}

	public void setPowerCabinetDeviceVos(List<DeviceVo> powerCabinetDeviceVos)
	{
		this.powerCabinetDeviceVos = powerCabinetDeviceVos;
	}

	public List<DeviceVo> getOutputCabinetDeviceVos()
	{
		return outputCabinetDeviceVos;
	}

	public void setOutputCabinetDeviceVos(List<DeviceVo> outputCabinetDeviceVos)
	{
		this.outputCabinetDeviceVos = outputCabinetDeviceVos;
	}

	public List<DeviceVo> getRectifierCabinetDeviceVos()
	{
		return rectifierCabinetDeviceVos;
	}

	public void setRectifierCabinetDeviceVos(
			List<DeviceVo> rectifierCabinetDeviceVos)
	{
		this.rectifierCabinetDeviceVos = rectifierCabinetDeviceVos;
	}



	public List<DeviceVo> getFeedTubeDeviceVos()
	{
		return feedTubeDeviceVos;
	}

	public void setFeedTubeDeviceVos(List<DeviceVo> feedTubeDeviceVos)
	{
		this.feedTubeDeviceVos = feedTubeDeviceVos;
	}

	public List<DeviceVo> getTransDeviceVos()
	{
		return transDeviceVos;
	}

	public void setTransDeviceVos(List<DeviceVo> transDeviceVos)
	{
		this.transDeviceVos = transDeviceVos;
	}

	private final SimpleDateFormat c_simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@PostConstruct
	public void init() {
		HttpSession session = HttpSessionUtil.getHttpSession();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = facesContext.getExternalContext();
		transDeviceVos = TransDevice2Vos();
		feedTubeDeviceVos = FeedDevice2Vos();
		
		powerCabinetDeviceVos = PowerCabinet2Vos();
		
		outputCabinetDeviceVos = OutputCabinet2Vos();
		
		rectifierCabinetDeviceVos = RectifierCabinet2Vos();
	}
	
	public List<DeviceVo> PowerCabinet2Vos() {
		List<DeviceVo> vos = new ArrayList<>();
		DeviceVo vo = new DeviceVo();
		vo.setImgUrl("../Image/device/u133.png");
		vo.setNode("功放 35℃/正常");
		vo.setDate(c_simpleFormat.format(new Date()));
		vos.add(vo);
		vos.add(vo);
		return vos;
	}
	
	public List<DeviceVo> OutputCabinet2Vos() {
		List<DeviceVo> vos = new ArrayList<>();
		DeviceVo vo = new DeviceVo();
		vo.setImgUrl("../Image/device/u133.png");
		vo.setNode("功放 35℃/正常");
		vo.setDate(c_simpleFormat.format(new Date()));
		vos.add(vo);
		vos.add(vo);
		return vos;
	}
	
	public List<DeviceVo> RectifierCabinet2Vos() {
		List<DeviceVo> vos = new ArrayList<>();
		DeviceVo vo = new DeviceVo();
		vo.setImgUrl("../Image/device/u157.png");
		vo.setNode("散热片 35℃/正常");
		vo.setDate(c_simpleFormat.format(new Date()));
		vos.add(vo);
		vos.add(vo);
		return vos;
	}
	
	public List<DeviceVo> FeedDevice2Vos() {
		List<DeviceVo> vos = new ArrayList<>();
		DeviceVo vo = new DeviceVo();
		vo.setImgUrl("../Image/device/u128.png");
		vo.setNode("节点1 35℃/正常");
		vo.setDate(c_simpleFormat.format(new Date()));
		vos.add(vo);
		vos.add(vo);
		return vos;
	}
	
	public List<DeviceVo> TransDevice2Vos() {
		List<DeviceVo> vos = new ArrayList<>();
		DeviceVo vo = new DeviceVo();
		vo.setImgUrl("../Image/device/u127.png");
		vo.setNode("A相 35℃/正常");
		vo.setDate(c_simpleFormat.format(new Date()));
		vos.add(vo);
		vos.add(vo);
//		List<DeviceVo> vos = new ArrayList<>();
//		for (DeviceShard d : ds) {
//			DeviceVo vo = new DeviceVo();
//			HistoryShard hd = historyShardService.findRecentByEquipId(d.getEquipmentid());
//
//			DeviceType t = id2DeviceType.get(d.getEquitype());
//			if (t == null) {
//				t = new DeviceType();
//			}
//			if (hd == null) {
//				hd = new HistoryShard();
//			}
//			vo.setDevice(d);
//			DeviceGroup group =  id2Groups.get(Integer.parseInt(d.getWord1()));
//			
//			if(null ==group )
//			{
//				continue;
//			}
//			String name = group.getGroupName();
//			vo.setGroupName(name);
//			String type = t.getName();
//			vo.setEquipType(type);
//			vo.setUnit(t.getUnit());
//			vo.setImgUrl(t.getTypeImg());
//			if (type.equals("温度")) {
//				vo.setRecord(hd.getTemp());
//			} else if (type.equals("湿度")) {
//				vo.setRecord(hd.getHumi());
//			} else if (type.equals("co2浓度")) {
//				vo.setRecord(hd.getCo2concent());
//			} else if (type.equals("光照强度")) {
//				vo.setRecord(hd.getIllumination());
//			}
//			vos.add(vo);
//		}
		return vos;
	}
	
	

	

}
