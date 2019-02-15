package com.qa.persistence.repository;

public interface Repository {
	String getA(Long theID);
	String getAll();
	String createA(String createThis);
	String updateA(Long theID, String updateToThis);
	String deleteA(Long theID);
}
