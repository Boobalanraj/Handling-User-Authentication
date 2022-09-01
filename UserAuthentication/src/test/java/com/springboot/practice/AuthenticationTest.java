package com.springboot.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest

public class AuthenticationTest {

	  @Autowired
	    private TestEntityManager entityManager;

	    @Autowired
	    private UserRepository userRepository;

	    
	    @Test
	    public void returnUserFromName() {
	        Users testUser = new Users();
	        testUser.setName("newTest");
	        testUser.setEmail("test@email.com");
	        testUser.setPassword("testpw");
	        entityManager.persist(testUser);
	        entityManager.flush();

	        Users found = userRepository.findByName(testUser.getName());

	        assertEquals(found.getName(), testUser.getName());
	    }

	    @Test
	    public void passwordNotNull() {
	    	
			Iterable<Users> users = userRepository.findAll();
			for(Users u: users)
				assertNotNull(u.getPassword());
	    }

	    @Test
	    public void nameNotNull() {
	    	
			Iterable<Users> users = userRepository.findAll();
			for(Users u: users)
				assertNotNull(u.getName());
	    }

	    @Test
	    public void emailNotNull() {
	    	
			Iterable<Users> users = userRepository.findAll();
			for(Users u: users)
				assertNotNull(u.getEmail());
	    }

}
