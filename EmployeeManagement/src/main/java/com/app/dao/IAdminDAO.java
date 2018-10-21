package com.app.dao;

import java.util.List;

import com.app.entity.Admin;

public interface IAdminDAO {

	
	public Admin getByCredentisl(int adminId, String password);
	public int save(Admin persistance);

	public List<Admin> findAllData();

	public Admin getById(int id);

	public Admin update(Admin admin);

	public void delete(int id);

}
