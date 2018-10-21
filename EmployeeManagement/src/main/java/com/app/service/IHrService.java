package com.app.service;

import java.util.List;

import com.app.entity.Employee;
import com.app.entity.Hr;

public interface IHrService {

	public void testData(Hr hr);

	public Hr getHrCred(long hrId, String password);
	public int save(Hr hrPersistance);

	public List<Hr> findByAll();

	public Hr getById(int id);

	public Hr update(Hr hr);

	public void delete(int id);

}
