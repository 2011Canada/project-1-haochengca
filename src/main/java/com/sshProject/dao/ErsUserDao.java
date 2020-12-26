package com.sshProject.dao;

import java.util.List;

import com.sshProject.entity.Ers_users;

public interface ErsUserDao {

	Ers_users allUsers();

	List<Ers_users> loginUser(Ers_users user);

}
