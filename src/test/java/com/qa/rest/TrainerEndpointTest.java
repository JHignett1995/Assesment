package com.qa.rest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.TrainerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TrainerEndpointTest {
	@InjectMocks
	private TrainerEndpoint endpoint;

	@Mock
	private TrainerServiceImpl service;

	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void createA() {
		Mockito.when(service.createA(MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2,endpoint.createATrainer(MOCK_VALUE));
		Mockito.verify(service).createA(MOCK_VALUE);
	}

	@Test
	public void getA() {
		Mockito.when(service.getA(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE,endpoint.getATrainer(1L));
	}

	@Test
	public void getAll() {
		Mockito.when(service.getAll()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE,endpoint.getAllTrainers());
	}

	@Test
	public void updateA() {
		Mockito.when(service.updateA(MOCK_VALUE, 1L)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2,endpoint.updateATrainer(1L,MOCK_VALUE));
		Mockito.verify(service).updateA(MOCK_VALUE, 1L);
	}

	@Test
	public void deleteA() {
		Mockito.when(service.deleteA(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteATrainer(1L));
		Mockito.verify(service).deleteA(1L);
	}
}
