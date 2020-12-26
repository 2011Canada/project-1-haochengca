package com.sshProject.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sshProject.dao.ErsUserDao;
import com.sshProject.entity.Ers_users;

@Repository
@Transactional
public class ErsUserDaoImpl implements ErsUserDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Ers_users allUsers() {

		Session session = sessionFactory.getCurrentSession();

		Ers_users user = (Ers_users) session.get(Ers_users.class, 1);
		return user;
	}

	@Override
	public List<Ers_users> loginUser(Ers_users user) {
		List<Ers_users> ulist = null;
		Session session = sessionFactory.getCurrentSession();

		Criteria c = session.createCriteria(Ers_users.class);

		Example example = Example.create(user);
		c.add(example);
		ulist = c.list();

		return ulist;
	}

}
