package com.bby.ants.entity;

public class Sender {
    private Integer id;

    private String sendername;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername == null ? null : sendername.trim();
    }
}