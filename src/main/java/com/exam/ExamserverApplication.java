package com.exam;

import com.exam.entites.Role;
import com.exam.entites.User;
import com.exam.entites.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code...");

//		User user = new User();
//		user.setFirstName("Mayank");
//		user.setLastName("Shivhare");
//		user.setUsername("Mayank1");
//		user.setPassword(this.bCryptPasswordEncoder.encode("password"));
//		user.setEmail("mayank@gmail.com");
//		user.setProfile("default.jpg");
//
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("Admin");
//
//		Set<UserRole> userRoleset = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//
//		userRoleset.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleset);
//		System.out.println(user1);
	}
}
