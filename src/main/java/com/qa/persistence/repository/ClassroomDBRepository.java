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

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;
@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements Repository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getA(Long theID) {
		return util.getJSONForObject(manager.find(Classroom.class, theID));
	}

	public String getAll() {
		Query query = manager.createQuery("SELECT c FROM CLASSROOM c");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}
	@Transactional(REQUIRED)
	public String createA(String createThis) {
		Classroom aClassroom = util.getObjectForJSON(createThis, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"Classroom added\"}";
	}
	@Transactional(REQUIRED)
	public String updateA(Long theID, String updateToThis) {
		deleteA(theID);
		createA(updateToThis);
		return "{\"message\": \"Classroom sucessfully Updated\"}";
	}
	@Transactional(REQUIRED)
	public String deleteA(Long theID) {
		manager.remove(getA(theID));
		return "{\"message\": \"Classroom sucessfully deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	
	

}
