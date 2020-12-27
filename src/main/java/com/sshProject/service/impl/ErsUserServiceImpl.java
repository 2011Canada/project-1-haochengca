package com.sshProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshProject.dao.ErsUserDao;
import com.sshProject.entity.Ers_reimbursement;
import com.sshProject.entity.Ers_users;
import com.sshProject.service.ErsUserService;

@Service
public class ErsUserServiceImpl implements ErsUserService {

	@Autowired
	private ErsUserDao ersUserdao;

	@Override
	public Ers_users allUsers() {
		return ersUserdao.allUsers();

	}

	@Override
	public List<Ers_users> loginUser(Ers_users user) {

		return ersUserdao.loginUser(user);
	}

	@Override
	public List<Ers_reimbursement> allreim(Ers_users user) {

		return ersUserdao.getAllReim(user);
	}

	@Override
	public void add(Ers_reimbursement ers_reimbursement) {
		ersUserdao.add(ers_reimbursement);

	}

	@Override
	public List<Ers_reimbursement> allreim() {
		return ersUserdao.getAllReim();
	}

	@Override
	public void approve(Ers_reimbursement ers_reimbursement) {

		ersUserdao.approve(ers_reimbursement);
	}

}
