package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IMessageDAO;
import com.app.entity.Message;

@Service
public class MesageServiceImpl implements IMessageService {

	@Autowired
	private IMessageDAO iMessageDAO;

	public int insert(Message message) {
		int message2 = iMessageDAO.insert(message);
		return message2;
	}

	public void delete(int msgId) {
		iMessageDAO.delete(msgId);
	}

	public List<Message> findAll() {
		List<Message> list = iMessageDAO.findAll();

		return list;
	}

	public Message findById(int msgId) {
		Message message = iMessageDAO.findById(msgId);
		return message;
	}

	public void update(Message message) {
		iMessageDAO.update(message);
	}

}
