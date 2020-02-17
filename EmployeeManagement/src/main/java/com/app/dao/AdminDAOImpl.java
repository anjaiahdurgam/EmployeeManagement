package com.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Admin;
import com.app.entity.Employee;

@Repository
@Transactional
public class AdminDAOImpl implements IAdminDAO {
	@Autowired
	private SessionFactory sessionfactory;

	public AdminDAOImpl() {
	}

	public AdminDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	public int save(Admin persistance) {
		return 0;
	}

	public List<Admin> findAllData() {
		return null;
	}

	public Admin getById(int id) {
		return null;
	}

	public Admin update(Admin admin) {
		return null;
	}

	public void delete(int id) {

	}

	@SuppressWarnings("unchecked")
	public Admin getByCredentisl(int adminId, String password) {
		Session session = sessionfactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Admin.class);
		criteria.add(Restrictions.eq("adminId", adminId));
		criteria.add(Restrictions.eq("password", password));
		List<Admin> list = criteria.list();
		Admin admin = new Admin();
		if (list.size() > 0) {
			admin = list.get(0);
		}
		return admin;
	}
}