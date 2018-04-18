package com.entity;

import java.io.Serializable;
import java.util.Date;

public class Students implements Serializable {
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", birthday="
				+ birthday + ", description=" + description + ", avgscore="
				+ avgscore + "]";
	}
	private String id;
	private String name;
	private String birthday;
	private String description;
	private String avgscore;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(String string) {
		this.avgscore = string;
	}
	

}
