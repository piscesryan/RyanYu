package com.bby.ants.entity;

public class Monitorpoints {
    private Long id;

    private String address;

    private String name;

    private String remark;

    private Float earlyWarning;

    private Float emergency;

    private Float beyondBounds;

    private Long compid;

    private Long gatewayid;

    private String sendername;

    private Integer channel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Float getEarlyWarning() {
        return earlyWarning;
    }

    public void setEarlyWarning(Float earlyWarning) {
        this.earlyWarning = earlyWarning;
    }

    public Float getEmergency() {
        return emergency;
    }

    public void setEmergency(Float emergency) {
        this.emergency = emergency;
    }

    public Float getBeyondBounds() {
        return beyondBounds;
    }

    public void setBeyondBounds(Float beyondBounds) {
        this.beyondBounds = beyondBounds;
    }

    public Long getCompid() {
        return compid;
    }

    public void setCompid(Long compid) {
        this.compid = compid;
    }

    public Long getGatewayid() {
        return gatewayid;
    }

    public void setGatewayid(Long gatewayid) {
        this.gatewayid = gatewayid;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername == null ? null : sendername.trim();
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}