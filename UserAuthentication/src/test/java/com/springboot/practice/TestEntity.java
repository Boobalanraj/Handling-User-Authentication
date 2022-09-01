package com.springboot.practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestEntity {

	@Test
	public void getAndSetPassword() {
		Users testUser = new Users();
		
		testUser.setPassword("mypassword");
		assertEquals(testUser.getPassword(),"mypassword");
	}
	
	@Test
	public void getAndSetName() {
		Users testUser = new Users();
		
		testUser.setName("dilip");
		assertEquals(testUser.getName(),"dilip");
	}
	
	@Test
	public void getAndSetEmail() {
		Users testUser = new Users();
		
		testUser.setEmail("dilip@email.com");
		assertEquals(testUser.getEmail(),"dilip@email.com");
	}
	
	@Test
	public void checkToString() {
		Users testUser = new Users();
		
		assertNotNull(testUser.toString());
	}
	
	@Test
	public void checkConstructor() {
		Users testUser = new Users("dilip","dilip@email.com","123");
		
		Users checkUser = new Users();
		checkUser.setName("dilip");
		checkUser.setEmail("dilip@email.com");
		checkUser.setPassword("123");
		
		assertEquals(testUser.getName(), checkUser.getName());
		assertEquals(testUser.getEmail(), checkUser.getEmail());
		assertEquals(testUser.getPassword(), checkUser.getPassword());
	}
	
	@Test
	public void testDefaultConstructor() {
		Users testUser = new Users();
		
		assertNotNull(testUser);
	}
}
