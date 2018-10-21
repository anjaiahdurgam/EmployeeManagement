package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminDAO;
import com.app.entity.Admin;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDAO iAdminDAO;

	public int save(Admin adminPersistance) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Admin> findByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin update(Admin adminPersistance) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public Admin getByCredentisl(int adminId, String password) {
		Admin admin = iAdminDAO.getByCredentisl(adminId, password);
		return admin;
	}

}
