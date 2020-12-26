package com.sshProject.service;

import java.util.List;

import com.sshProject.entity.Ers_users;

public interface ErsUserService {

	Ers_users allUsers();

	List<Ers_users> loginUser(Ers_users user);

}
