package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.persistence.domain.Trainer;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TrainerDBRepositoryTest {
	@InjectMocks
	private TrainerDBRepository repo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private static final String MOCK_DATA_ARRAY = "[{\"id\":1,\"firstName\":\"Matt\",\"lastName\":\"Hunt\"}]";

	private static final String MOCK_OBJECT = "{\"id\":1,\"firstName\":\"Matt\",\"lastName\":\"Hunt\"}";
	
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
		assertEquals(reply, "{\"message\": \"Trainer added\"}");
	}
	//Read Test
	@Test
	public void readAllTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainer> trainers = new ArrayList<Trainer>();
		trainers.add(new Trainer(1L,"Matt","Hunt"));
		Mockito.when(query.getResultList()).thenReturn(trainers);
		assertEquals(MOCK_DATA_ARRAY, repo.getAll());
	}
	@Test
	public void readATest() {
		Mockito.when(manager.find(Trainer.class, 1L)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Trainer.class));
		assertEquals(MOCK_OBJECT,repo.getA(1L));
	}
	//Update Test
	@Test
	public void updateTest() {
		assertEquals("{\"message\": \"Trainer sucessfully Updated\"}",repo.updateA(1L, MOCK_OBJECT));
	}
	//Delete Test
	@Test
	public void deleteTest() {
		String reply = repo.deleteA(1L);
		assertEquals(reply, "{\"message\": \"Trainer sucessfully deleted\"}");
	}
}
