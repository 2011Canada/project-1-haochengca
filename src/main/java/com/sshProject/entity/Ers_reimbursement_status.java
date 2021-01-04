package com.sshProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ers_reimbursement_status {

	@Id
	@Column(name = "reimb_status_id", unique = true, nullable = false, length = 11)
	private int reimb_status_id;

	@Column(name = "reimb_status")
	private String reimb_status;

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

}
