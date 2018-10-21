package com.app.service;

import java.util.List;

import com.app.entity.Admin;

public interface IAdminService {

	
	public Admin getByCredentisl(int adminId, String password);
	public int save(Admin adminPersistance);

	public List<Admin> findByAll();

	public Admin getById(int id);

	public Admin update(Admin adminPersistance);

	public void delete(int id);

}
