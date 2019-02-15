package com.qa.business;

import javax.inject.Inject;
import com.qa.persistence.repository.Repository;
import com.qa.util.JSONUtil;
public class TraineeServiceImpl implements Service {

	@Inject
	private Repository repo;
	
	@Inject
	JSONUtil util;
	
	public String createA(String createThis) {
		return repo.createA(createThis);
	}

	public String getA(Long theID) {
		return repo.getA(theID);
	}

	public String getAll() {
		return repo.getAll();
	}

	public String updateA(String updateToThis, Long theID) {
		return repo.updateA(theID, updateToThis);
	}

	public String deleteA(Long theID) {
		return repo.deleteA(theID);
	}

	public void setRepo(Repository repo) {
		this.repo = repo;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
