package com.bugsmanage.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Bugfile implements Serializable  {
	
    private Integer bugfile_id;

    private String filename;
    
    private Integer bug_id;

    private Date creat_time;

    public Integer getBugfile_id() {
        return bugfile_id;
    }

    public void setBugfile_id(Integer bugfile_id) {
        this.bugfile_id = bugfile_id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getBug_id() {
        return bug_id;
    }

    public void setBug_id(Integer bug_id) {
        this.bug_id = bug_id;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }



	@Override
	public String toString() {
		return "Bugfile [bugfile_id=" + bugfile_id + ", filename=" + filename + ",  bug_id=" + bug_id
				+ ", creat_time=" + creat_time + "]";
	}


}