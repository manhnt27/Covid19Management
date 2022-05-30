package com.manhnt27.spring_boot;

import com.manhnt27.spring_boot.Model.Admin.Admin;
import com.manhnt27.spring_boot.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Covid19ManagementApplication {

	public static void main(String[] args)  {
		SpringApplication.run(Covid19ManagementApplication.class, args);
	}

}
