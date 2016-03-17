package com.domains.domains.Sjtg;

import java.io.Serializable;

public class Contents_Sjtg implements Serializable{

	private Integer id;
	private String tilte;
	private String subTilte;
	private String content;
	private String time;

	public String getTilte() {
		return tilte;
	}

	public void setTilte(String tilte) {
		this.tilte = tilte;
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

	public String getSubTilte() {
		return subTilte;
	}

	public void setSubTilte(String subTilte) {
		this.subTilte = subTilte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
