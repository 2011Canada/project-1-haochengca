package com.sshProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ers_reimbursement_type {

	@Id
	@Column(name = "reimb_type_id", unique = true, nullable = false, length = 11)
	private int reimb_type_id;

	@Column(name = "reimb_type")
	private String reimb_type;

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}

	@Override
	public String toString() {
		return "Ers_reimbursement_type [reimb_type_id=" + reimb_type_id + ", reimb_type=" + reimb_type + "]";
	}

}
