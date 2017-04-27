package com.bugsmanage.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Bug implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer bug_id;

    private String summary;

    private Bugseverity bugseverity;

    private Integer bug_status;

    private User reporter;

    private Project project;//.............

    private User handler;

    private String bug_comment;

    private String bug_os;

    private String bug_description;
    
    private Integer bug_result;

    private Date submite_time;
    
 

	public Integer getBug_id() {
		return bug_id;
	}

	public void setBug_id(Integer bug_id) {
		this.bug_id = bug_id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Bugseverity getBugseverity() {
		return bugseverity;
	}

	public void setBugseverity(Bugseverity bugseverity) {
		this.bugseverity = bugseverity;
	}

	public Integer getBug_status() {
		return bug_status;
	}

	public void setBug_status(Integer bug_status) {
		this.bug_status = bug_status;
	}

	public User getReporter() {
		return reporter;
	}

	public void setReporter(User reporter) {
		this.reporter = reporter;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getHandler() {
		return handler;
	}

	public void setHandler(User handler) {
		this.handler = handler;
	}

	public String getBug_comment() {
		return bug_comment;
	}

	public void setBug_comment(String bug_comment) {
		this.bug_comment = bug_comment;
	}

	public String getBug_os() {
		return bug_os;
	}

	public void setBug_os(String bug_os) {
		this.bug_os = bug_os;
	}

	public String getBug_description() {
		return bug_description;
	}

	public void setBug_description(String bug_description) {
		this.bug_description = bug_description;
	}

	public Integer getBug_result() {
		return bug_result;
	}

	public void setBug_result(Integer bug_result) {
		this.bug_result = bug_result;
	}

	public Date getSubmite_time() {
		return submite_time;
	}

	public void setSubmite_time(Date submite_time) {
		this.submite_time = submite_time;
	}


    
    
}