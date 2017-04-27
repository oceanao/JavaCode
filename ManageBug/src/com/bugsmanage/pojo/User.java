package com.bugsmanage.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private Integer user_id;

    private String student_num;

    private String username;

    private String password;

    private Integer role;

    private Date register_time;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getStudent_num() {
        return student_num;
    }

    public void setStudent_num(String student_num) {
        this.student_num = student_num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password ;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", student_num=" + student_num + ", username=" + username + ", password="
				+ password + ", role=" + role + ", register_time=" + register_time + "]";
	}
}