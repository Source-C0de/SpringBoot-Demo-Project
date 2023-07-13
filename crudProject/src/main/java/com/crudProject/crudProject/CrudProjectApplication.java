package com.crudProject.crudProject;

import com.crudProject.crudProject.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.example.crudupdate.controller","com.example.crudupdate.service"})
public class CrudProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectApplication.class, args);
	}

	@Autowired
	private userRepository UserRepository;

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Student student1 = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");
		 * studentRepository.save(student1);
		 *
		 * Student student2 = new Student("Sanjay", "Jadhav", "sanjay@gmail.com");
		 * studentRepository.save(student2);
		 *
		 * Student student3 = new Student("tony", "stark", "tony@gmail.com");
		 * studentRepository.save(student3);
		 */

	}


}
