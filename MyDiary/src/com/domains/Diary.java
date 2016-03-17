package com.domains;

import java.io.Serializable;

public class Diary implements Serializable{

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private int id;
	private String title;
	private String content;
	private String time;

	public Diary(int id, String title, String content, String time) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.title = title;
		this.content = content;
		this.time = time;
	}

	public Diary() {
		// TODO Auto-generated constructor stub
	}
}
