package com.bugsmanage.pojo;

import java.io.Serializable;

public class Project implements Serializable{
	
    private Integer pro_id;

    private String pro_name;

    private String pro_description;
    
    private String pro_version;

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name == null ? null : pro_name.trim();
    }

    public String getPro_description() {
        return pro_description;
    }

    public void setPro_description(String pro_description) {
        this.pro_description = pro_description == null ? null : pro_description.trim();
    }

	public String getPro_version() {
		return pro_version;
	}

	public void setPro_version(String pro_version) {
		this.pro_version = pro_version;
	}

	@Override
	public String toString() {
		return "Project [pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_description=" + pro_description
				+ ", pro_version=" + pro_version + "]";
	}
    
}