package com.app.util;

import java.util.UUID;

public class CommanUtility {

	
	public static String getPassword()
	{//
     	return	UUID.randomUUID().toString().replace("-", "").substring(0, 7);
     	
     	
	}
	
	
	
}
