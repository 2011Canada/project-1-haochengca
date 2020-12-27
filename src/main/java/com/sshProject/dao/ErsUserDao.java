package com.sshProject.dao;

import java.util.List;

import com.sshProject.entity.Ers_reimbursement;
import com.sshProject.entity.Ers_users;

public interface ErsUserDao {

	Ers_users allUsers();

	List<Ers_users> loginUser(Ers_users user);

	List<Ers_reimbursement> getAllReim(Ers_users user);

	void add(Ers_reimbursement ers_reimbursement);

	List<Ers_reimbursement> getAllReim();

	void approve(Ers_reimbursement ers_reimbursement);

}
