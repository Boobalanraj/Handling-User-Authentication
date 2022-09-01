package com.springboot.practice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestWeb {

	  @LocalServerPort
	    private int port;


	    @Autowired
	    private UserController controller;




	    @Autowired
	    private MockMvc mockMvc;


	    @Test
	    public void shouldReturnDefaultMessage() throws Exception {
	        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	    }

	    @Test
	    public void checkLoginPage() throws Exception {
	        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().is4xxClientError());
	    }
	    
	    @Test
	    public void checkUsersPage() throws Exception {
	        this.mockMvc.perform(get("/allusers")).andDo(print()).andExpect(status().isOk());
	    }
	
}
