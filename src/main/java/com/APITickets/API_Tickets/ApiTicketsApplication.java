package com.APITickets.API_Tickets;

import com.APITickets.API_Tickets.Module.Utilisateurs;
import com.APITickets.API_Tickets.Repository.User_repository;
import com.APITickets.API_Tickets.enums.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class ApiTicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTicketsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(User_repository user_repository, PasswordEncoder passwordEncoder) {

		return args -> {
			System.out.println("Hello1");
			Optional<Utilisateurs> users = user_repository.findByNom("admin@admin.com");
			System.out.println("Hello2");
			if (users.isPresent()) {
				System.out.println("Hello3");
			}
			if (users.isEmpty()){
				System.out.println("Hello");
				Utilisateurs utilisateurs = new Utilisateurs();
				utilisateurs.setEmail("admin@admin.com");
				utilisateurs.setNom("admin@admin.com");
				utilisateurs.setRole(Role.ADMIN);
				utilisateurs.setMdp(passwordEncoder.encode("admin@admin.com"));
				user_repository.save(utilisateurs);
				System.out.println(users);
			}

		};
	}
}
