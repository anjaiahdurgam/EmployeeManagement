package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Employee;
import com.app.entity.Message;

@Repository("iMessageDAO")
@Transactional
public class MessageDAOImpl implements IMessageDAO {
	@Autowired
	SessionFactory sessionFactory;

	public MessageDAOImpl() {
		super();
	}

	public MessageDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public int insert(Message message) {

		int msgId = (Integer) sessionFactory.getCurrentSession().save(message);

		return msgId;
	}

	public void delete(int msgId) {
		Session session = sessionFactory.getCurrentSession();
		Message message = (Message) sessionFactory.getCurrentSession().get(Message.class, msgId);

		if (session != null) {
			session.update(message);

		}

	}

	@SuppressWarnings("unchecked")
	public List<Message> findAll() {
		String string = "from Message m ";
		List<Message> messages = sessionFactory.getCurrentSession().createQuery(string).list();
		return messages;
	}

	public Message findById(int msgId) {
		Message message = (Message) sessionFactory.getCurrentSession().get(Message.class, msgId);
		return message;
	}

	public void update(Message message) {

		Session session = sessionFactory.getCurrentSession();
		session.update(message);
	}

}
