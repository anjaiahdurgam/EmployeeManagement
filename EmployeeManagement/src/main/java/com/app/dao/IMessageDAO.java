package com.app.dao;

import java.util.List;

import com.app.entity.Message;

public interface IMessageDAO {

	public int insert(Message message);

	public void delete(int msgId);

	public List<Message> findAll();

	public Message findById(int msgId);

	public void update(Message message);

}
