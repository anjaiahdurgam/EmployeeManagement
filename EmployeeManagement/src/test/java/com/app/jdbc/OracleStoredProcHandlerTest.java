package com.app.jdbc;

import java.util.Properties;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class OracleStoredProcHandlerTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@InjectMocks
	private OracleStoredProcHandlerTest orclStrdProHandlTest;
	
	@Mock
    private Properties prop;
	
	@Mock
	private CallableStatement callableStatement;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	

}
