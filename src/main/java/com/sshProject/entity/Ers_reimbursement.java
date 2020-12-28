package com.sshProject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ers_reimbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reimb_id", unique = true, nullable = false, length = 11)
	private int reimb_id;

	@Column(name = "reimb_amount")
	private double reimb_amount;

	@Column(name = "reimb_submitted")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reimb_submitted;

	@Column(name = "reimb_resolved")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reimb_resolved;

	@Column(name = "reimb_description")
	private String reimb_description;

	@Column(name = "receipt")
	private String receipt;

	@ManyToOne
	@JoinColumn(name = "ers_author")
	private Ers_users ers_author;

	@ManyToOne
	@JoinColumn(name = "ers_resolver")
	private Ers_users ers_resolver;

	@ManyToOne
	@JoinColumn(name = "reim_type_id")
	private Ers_reimbursement_type reim_type_id;

	@ManyToOne
	@JoinColumn(name = "reimb_status_id")
	private Ers_reimbursement_status reimb_status_id;

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public Date getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(Date reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public Date getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(Date reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public Ers_users getErs_author() {
		return ers_author;
	}

	public void setErs_author(Ers_users ers_author) {
		this.ers_author = ers_author;
	}

	public Ers_users getErs_resolver() {
		return ers_resolver;
	}

	public void setErs_resolver(Ers_users ers_resolver) {
		this.ers_resolver = ers_resolver;
	}

	public Ers_reimbursement_type getReim_type_id() {
		return reim_type_id;
	}

	public void setReim_type_id(Ers_reimbursement_type reim_type_id) {
		this.reim_type_id = reim_type_id;
	}

	public Ers_reimbursement_status getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(Ers_reimbursement_status reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	@Override
	public String toString() {
		return "Ers_reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", receipt=" + receipt + ", ers_author=" + ers_author + ", ers_resolver=" + ers_resolver
				+ ", reim_type_id=" + reim_type_id + ", reimb_status_id=" + reimb_status_id + "]";
	}

	public Ers_reimbursement() {
		super();
	}

}
