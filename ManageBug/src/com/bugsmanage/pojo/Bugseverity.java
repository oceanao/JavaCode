package com.bugsmanage.pojo;

import java.io.Serializable;

public class Bugseverity implements Serializable{
    private Integer bugseverity_id;

    private String severity;
    private String remark;

    public Integer getBugseverity_id() {
        return bugseverity_id;
    }

    public void setBugseverity_id(Integer bugseverity_id) {
        this.bugseverity_id = bugseverity_id;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity == null ? null : severity.trim();
    }

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}