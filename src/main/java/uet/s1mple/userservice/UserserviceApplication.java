package uet.s1mple.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uet.s1mple.userservice.domain.Role;
import uet.s1mple.userservice.domain.User;
import uet.s1mple.userservice.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return orgs -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Huong", "huong", "1", new ArrayList<>()));
			userService.saveUser(new User(null, "Hoan", "hoan", "1", new ArrayList<>()));
			userService.saveUser(new User(null, "Hoang", "hoang", "1", new ArrayList<>()));
			userService.saveUser(new User(null, "Lam", "lam", "1", new ArrayList<>()));

			userService.addRoleToUser("huong", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("hoan", "ROLE_ADMIN");
			userService.addRoleToUser("hoang", "ROLE_MANAGER");
			userService.addRoleToUser("lam", "ROLE_USER");
			userService.addRoleToUser("hoang", "ROLE_ADMIN");
		};
	}
}
