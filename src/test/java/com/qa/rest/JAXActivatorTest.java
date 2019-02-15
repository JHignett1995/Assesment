package com.qa.rest;

import static org.junit.Assert.*;

import org.junit.Test;

public class JAXActivatorTest {
	JAXActivator jax = new JAXActivator();
	
@Test
public void testJAX() {
	assertTrue(jax.exists());
}
}
