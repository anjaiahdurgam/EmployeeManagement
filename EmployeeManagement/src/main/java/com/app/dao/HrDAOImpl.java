package com.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Employee;
import com.app.entity.Hr;

@Repository
@Transactional
public class HrDAOImpl implements IHrDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public HrDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public HrDAOImpl() {
	}

	public int save(Hr hr) {
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(hr);
		hr.getAddress().setHr(hr);
		session.save(hr.getAddress());
		return id;
	}

	public List<Hr> findAllDetails() {
		String string = "from Hr h";
		List hrList = sessionFactory.getCurrentSession().createQuery(string).list();
		return hrList;
	}

	public Hr getById(int hrId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Hr updateHrDetails(Hr hr) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteHr(int hrId) {
		// TODO Auto-generated method stub

	}

	public void testData(Hr hr) {
		Session session = sessionFactory.getCurrentSession();
		session.save(hr.getAddress());
		// session.save(Address);
		session.save(hr);

	}

	public Hr getHrCred(long hrId, String password) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Hr.class);
		criteria.add(Restrictions.eq("id", hrId));
		criteria.add(Restrictions.eq("password", password));
		List<Hr> hrList = criteria.list();

		Hr hr = new Hr();
		if (hrList.size() > 0) {
			hr = hrList.get(0);

		}
		return hr;
	}

}
