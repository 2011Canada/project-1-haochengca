package com.sshProject.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sshProject.dao.ErsUserDao;
import com.sshProject.entity.Ers_reimbursement;
import com.sshProject.entity.Ers_users;

@Repository
@Transactional
public class ErsUserDaoImpl extends HibernateDaoSupport implements ErsUserDao {
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Ers_users allUsers() {

//		Session session = sessionFactory.getCurrentSession();

//		Ers_users user = (Ers_users) session.get(Ers_users.class, 1);
		return null;
	}

	@Override
	public List<Ers_users> loginUser(Ers_users user) {

		return getHibernateTemplate().findByExample(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Ers_reimbursement> getAllReim(Ers_users user) {

//		System.out.println(user);
		String hql = "from Ers_reimbursement where ers_author = " + user.getErs_users_id();
		List<Ers_reimbursement> ret = (List<Ers_reimbursement>) getHibernateTemplate().find(hql);
//		System.out.println(ret);

		return ret;
	}

	@Override
	public void add(Ers_reimbursement ers_reimbursement) {
		getHibernateTemplate().save(ers_reimbursement);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Ers_reimbursement> getAllReim() {
		String hql = "from Ers_reimbursement";
		List<Ers_reimbursement> ret = (List<Ers_reimbursement>) getHibernateTemplate().find(hql);

		return ret;
	}

	@Override
	public void approve(Ers_reimbursement ers_reimbursement) {
		Ers_reimbursement old = getHibernateTemplate().get(Ers_reimbursement.class, ers_reimbursement.getReimb_id());

		old.setReimb_status_id(ers_reimbursement.getReimb_status_id());
		old.setReimb_resolved(ers_reimbursement.getReimb_resolved());
		old.setErs_resolver(ers_reimbursement.getErs_resolver());

		getHibernateTemplate().update(old);
	}

}
