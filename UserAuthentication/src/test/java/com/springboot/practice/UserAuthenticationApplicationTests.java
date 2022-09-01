package com.springboot.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserAuthenticationApplicationTests {

	
	@Autowired
	private UserService userService;
	
	@Test
	void contextLoads() {
	}

	
	@Test
	void testServiceCall() {
		Iterable<Users> users = userService.allUsers();
		Integer count = 0;
		
		for(Users u: users)
			count++;
		
		assertNotEquals(count, 0);
	}
	


	@Test
	void countUsers() {
		Iterable<Users> users = userService.allUsers();
		Integer count = 0;
		
		for(Users u: users)
			count++;
		
		assertEquals(count, 4);
	}
	
	@Test
	void checkAllUsers() {
		Iterable<Users> users = userService.allUsers();
		
		for(Users u: users)
			assertNotNull(u);
	}

}
