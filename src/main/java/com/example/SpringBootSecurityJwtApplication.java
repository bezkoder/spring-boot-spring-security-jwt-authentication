package com.example;

import com.example.models.ERole;
import com.example.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import com.example.models.Role;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityJwtApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role role1 = new Role();
		role1.setName(ERole.ROLE_USER);

		Role role2 = new Role();
		role2.setName(ERole.ROLE_ADMIN);

		Role role3 = new Role();
		role3.setName(ERole.ROLE_MODERATOR);

		roleRepository.save(role1);
		roleRepository.save(role2);
		roleRepository.save(role3);

	}
}
