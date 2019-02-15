package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainer;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomDBRepositoryTest {
	@InjectMocks
	private ClassroomDBRepository repo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private static final String MOCK_DATA_ARRAY = "[{\"classroomID\":1,\"trainerID\":1}]";

	private static final String MOCK_OBJECT = "{\"classroomID\":1,\"trainerID\":1}";
	
	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	//Create Test
	@Test
	public void createTest() {
		String reply = repo.createA(MOCK_OBJECT);
		assertEquals(reply, "{\"message\": \"Classroom added\"}");
	}
	//Read Test
	@Ignore
	public void readAllTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Classroom> classrooms = new ArrayList<Classroom>();
		classrooms.add(new Classroom());
		Mockito.when(query.getResultList()).thenReturn(classrooms);
		assertEquals(MOCK_DATA_ARRAY, repo.getAll());
	}
	@Ignore
	public void readATest() {
		Mockito.when(manager.find(Classroom.class, 1L)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Classroom.class));
		assertEquals(MOCK_OBJECT,repo.getA(1L));
	}
	//Update Test
	@Test
	public void updateTest() {
		assertEquals("{\"message\": \"Classroom sucessfully Updated\"}",repo.updateA(1L, MOCK_OBJECT));
	}
	//Delete Test
	@Test
	public void deleteTest() {
		String reply = repo.deleteA(1L);
		assertEquals(reply, "{\"message\": \"Classroom sucessfully deleted\"}");
	}
}
