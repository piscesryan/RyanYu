package com.bby.ants.entity;

import java.util.Date;

public class Alarminfo {
    private Long id;

    private String monitorpointsname;

    private String sendercomp;

    private Integer temperature;

    private Date alarmtime;

    private String alarmtype;

    private Integer threshold;

    private String result;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonitorpointsname() {
        return monitorpointsname;
    }

    public void setMonitorpointsname(String monitorpointsname) {
        this.monitorpointsname = monitorpointsname == null ? null : monitorpointsname.trim();
    }

    public String getSendercomp() {
        return sendercomp;
    }

    public void setSendercomp(String sendercomp) {
        this.sendercomp = sendercomp == null ? null : sendercomp.trim();
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Date getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(Date alarmtime) {
        this.alarmtime = alarmtime;
    }

    public String getAlarmtype() {
        return alarmtype;
    }

    public void setAlarmtype(String alarmtype) {
        this.alarmtype = alarmtype == null ? null : alarmtype.trim();
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}