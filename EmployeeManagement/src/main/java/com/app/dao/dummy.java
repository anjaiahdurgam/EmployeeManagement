package com.app.dao;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Lob;

import com.app.entity.Department;

public class dummy {
	
	
	
public static void main(String[] args) {

	String s="anji";
	String s1=new String("anji");
	
	System.out.println(s.hashCode());
	System.out.println(s1.hashCode());
	
	
	
	System.out.println(s==s1);
	System.out.println(s.equals(s1));

}
}
