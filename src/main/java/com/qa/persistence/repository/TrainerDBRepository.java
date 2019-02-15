package com.qa.persistence.repository;
import java.util.Collection;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainer;
import com.qa.util.JSONUtil;
@Transactional(SUPPORTS)
@Default
public class TrainerDBRepository implements Repository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getA(Long theID) {
		return util.getJSONForObject(manager.find(Trainer.class, theID));
	}

	public String getAll() {
		Query query = manager.createQuery("SELECT c FROM Trainer c");
		Collection<Trainer> trainers = (Collection<Trainer>) query.getResultList();
		return util.getJSONForObject(trainers);
	}
	@Transactional(REQUIRED)
	public String createA(String createThis) {
		Trainer aTrainer = util.getObjectForJSON(createThis, Trainer.class);
		manager.persist(aTrainer);
		return "{\"message\": \"Trainer added\"}";
	}
	@Transactional(REQUIRED)
	public String updateA(Long theID, String updateToThis) {
		deleteA(theID);
		createA(updateToThis);
		return "{\"message\": \"Trainer sucessfully Updated\"}";
	}
	@Transactional(REQUIRED)
	public String deleteA(Long theID) {
		manager.remove(getA(theID));
		return "{\"message\": \"Trainer sucessfully deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	
	

}
