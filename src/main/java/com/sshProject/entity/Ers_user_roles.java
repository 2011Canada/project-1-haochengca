package com.sshProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ers_user_roles {

	@Id
	@Column(name = "ers_user_role_id", unique = true, nullable = false, length = 11)
	private int ers_user_role_id;

	@Column(name = "user_role")
	private String user_role;

	public int getErs_user_role_id() {
		return ers_user_role_id;
	}

	public void setErs_user_role_id(int ers_user_role_id) {
		this.ers_user_role_id = ers_user_role_id;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

}
