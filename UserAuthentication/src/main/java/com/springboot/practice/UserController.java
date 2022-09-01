package com.springboot.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("/login")
	public String login() {
		return "index";
	}
	
	@GetMapping("/allusers")
	public @ResponseBody String alldata() {
		Iterable<Users> alluser = repo.findAll();
		return "<html>\n"
		 		+ "<head>\n"
		 		+ "	<style>\n"
		 		+ "		.center {\n"
		 		+ "	  		text-align: center;\n"
		 		+ "	  	}\n"
		 		+ "	  	\n"
		 		+ "	</style>\n"
		 		+ "</head>\n"
		 		+ "<body style=\"background-color:lightblue;\">\n"
		 		+ "	<div class=\"center\">\n"
		 		+ "<h1>Feedback Table</h1>\n"
        		+ alluser.toString()
		        + "	</div>\n"
		 		+ "</body>\n"
		 		+ "</html>";
		}
	@PostMapping("/login")
	public String login(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("password") String password) {
		Users userName = new Users(name, email, password);
		repo.save(userName);
		System.out.println("login");
		return "Login successfully";
	}
}

