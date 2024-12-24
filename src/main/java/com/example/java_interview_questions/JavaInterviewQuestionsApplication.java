package com.example.java_interview_questions;

import com.example.java_interview_questions.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootApplication
public class JavaInterviewQuestionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaInterviewQuestionsApplication.class, args);
	}

	@Bean
	@ApplicationScope
	
	public Employee getEmployee(){
		return new Employee("name");
	}

}
