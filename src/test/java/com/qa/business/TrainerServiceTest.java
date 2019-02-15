package com.qa.business;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.persistence.repository.Repository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TrainerServiceTest {
	@InjectMocks
	private TrainerServiceImpl service;

	@Mock
	private Repository repo;

	@Mock
	private JSONUtil util;
	
	private static final String MOCK_VALUE = "test_value";
	private static final String MOCK_OBJECT = "{\"room_id\":1,\"trainerID\":1}";

	@Before
	public void setup() {
		service.setRepo(repo);
		util = new JSONUtil();
		service.setUtil(util);
	}
	
	@Test
	public void createTest() {
		Mockito.when(repo.createA(MOCK_OBJECT)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, service.createA(MOCK_OBJECT));
		Mockito.verify(repo).createA(MOCK_OBJECT);
	}
	@Test
	public void getATest() {
		Mockito.when(repo.getA(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getA(1L));
	}
	@Test
	public void getAllTest() {
		Mockito.when(repo.getAll()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAll());
	}
	@Test
	public void updateTest() {
		Mockito.when(repo.updateA(1L, MOCK_VALUE)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT,service.updateA(MOCK_VALUE, 1L));
		Mockito.verify(repo).updateA(1L, MOCK_VALUE);
	}
	@Test
	public void deleteTest() {
		Mockito.when(repo.deleteA(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE,service.deleteA(1L));
		Mockito.verify(repo).deleteA(1L);
	}
}
