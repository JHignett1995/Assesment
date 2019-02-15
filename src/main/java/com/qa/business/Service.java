package com.qa.business;

public interface Service {
	String createA(String createThis);
	String getA(Long theID);
	String getAll();
	String updateA(String updateToThis, Long theID);
	String deleteA(Long theID);
}
