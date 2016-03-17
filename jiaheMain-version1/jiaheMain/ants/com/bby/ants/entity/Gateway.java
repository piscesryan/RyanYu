package com.bby.ants.entity;

public class Gateway {
    private Integer id;

    private String name;

    private Integer networkid;

    private Integer hostid;

    private Integer channel;

    private String ip;

    private Integer port;

    private Integer buzzer;

    private Integer nodesnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNetworkid() {
        return networkid;
    }

    public void setNetworkid(Integer networkid) {
        this.networkid = networkid;
    }

    public Integer getHostid() {
        return hostid;
    }

    public void setHostid(Integer hostid) {
        this.hostid = hostid;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getBuzzer() {
        return buzzer;
    }

    public void setBuzzer(Integer buzzer) {
        this.buzzer = buzzer;
    }

    public Integer getNodesnum() {
        return nodesnum;
    }

    public void setNodesnum(Integer nodesnum) {
        this.nodesnum = nodesnum;
    }
}