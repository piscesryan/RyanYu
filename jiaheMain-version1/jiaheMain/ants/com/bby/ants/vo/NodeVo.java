package com.bby.ants.vo;

import java.io.Serializable;
import java.util.Date;

public class NodeVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int nodeId;
	private String belongDeive;
	private String belongTransmitter;
	private String channel;
	private int value;
	private Date createDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNodeId() {
		return nodeId;
	}
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	public String getBelongDeive() {
		return belongDeive;
	}
	public void setBelongDeive(String belongDeive) {
		this.belongDeive = belongDeive;
	}
	public String getBelongTransmitter() {
		return belongTransmitter;
	}
	public void setBelongTransmitter(String belongTransmitter) {
		this.belongTransmitter = belongTransmitter;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
