package com.app.dao;

import java.util.List;

import com.app.entity.Employee;
import com.app.entity.Hr;

public interface IHrDAO {

	public void testData(Hr hr);

	public Hr getHrCred(long hrId, String password);

	public int save(Hr hr);

	public List<Hr> findAllDetails();

	public Hr getById(int hrId);

	public Hr updateHrDetails(Hr hr);

	public void deleteHr(int hrId);
}
