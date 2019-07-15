package com.courses;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import com.courses.models.CoursesDetailsModel;
import com.courses.models.MentorsDetailsModel;
import com.courses.models.StudentsDetailsModel;
import com.courses.services.CoursesService;
import com.courses.services.MentorsService;
import com.courses.services.StudentsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringCoursesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoursesProjectApplication.class, args);
	}
	
	@Bean
	@Order(value = 1)
	CommandLineRunner runnerCourse(CoursesService course) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CoursesDetailsModel>> typeReference = new TypeReference<List<CoursesDetailsModel>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/courses.json");
			try {
				List<CoursesDetailsModel> courses = mapper.readValue(inputStream,typeReference);
				course.saveAllCourses(courses);
				System.out.println("Courses Saved!");
			} catch (IOException e){
				System.out.println("Unable to save courses: " + e.getMessage());
			}
		};
	}
	
	@Bean
	@Order(value = 2)
	CommandLineRunner runnerMentor(MentorsService mentor) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<MentorsDetailsModel>> typeReference = new TypeReference<List<MentorsDetailsModel>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/mentors.json");
			try {
				List<MentorsDetailsModel> mentors = mapper.readValue(inputStream,typeReference);
				mentor.saveAllMentors(mentors);
				System.out.println("Mentors Saved!");
			} catch (IOException e){
				System.out.println("Unable to save mentors: " + e.getMessage());
			}
		};
	}
	
	@Bean
	@Order(value = 3)
	CommandLineRunner runnerStudent(StudentsService student) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<StudentsDetailsModel>> typeReference = new TypeReference<List<StudentsDetailsModel>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/students.json");
			try {
				List<StudentsDetailsModel> students = mapper.readValue(inputStream,typeReference);
				student.saveAllStudents(students);
				System.out.println("Students Saved!");
			} catch (IOException e){
				System.out.println("Unable to save students: " + e.getMessage());
			}
		};
	}

}
