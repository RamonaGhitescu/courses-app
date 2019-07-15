package com.courses.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.courses.models.CoursesDetailsModel;
import com.courses.models.StudentsDetailsModel;
import com.courses.services.StudentsService;

@RequestMapping("/")
@RestController
public class StudentsController {
	private static final Logger logger = LoggerFactory.getLogger(StudentsController.class);

	@Autowired
	private StudentsService studentService;

	@GetMapping("/students-all")
	public ResponseEntity<List<StudentsDetailsModel>> findAll() {
		return ResponseEntity.ok(studentService.findAllStudents());
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<StudentsDetailsModel> findById(@PathVariable Long id) {
		Optional<StudentsDetailsModel> student = studentService.findById(id);
		if (!student.isPresent()) {
			logger.error("The student ID " + id + " does not exist");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(student.get());
	}

	@PostMapping("/students")
	public ResponseEntity<StudentsDetailsModel> createCourse(@Valid @RequestBody StudentsDetailsModel student) {
		return ResponseEntity.ok(studentService.save(student));
	}

	@PutMapping("/update-student/{id}")
	public ResponseEntity<StudentsDetailsModel> update(@PathVariable Long id,
			@Valid @RequestBody StudentsDetailsModel student) {
		if (!studentService.findById(id).isPresent()) {
			logger.error("The student ID " + id + " does not exist");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(studentService.save(student));
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<StudentsDetailsModel> delete(@PathVariable Long id) {
		if (!studentService.findById(id).isPresent()) {
			logger.error("The student ID " + id + " does not exist");
			ResponseEntity.badRequest().build();
		}
		studentService.deleteById(id);

		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/students/{studentId}/courses")
	public List<CoursesDetailsModel> retrieveCoursesForStudent(@PathVariable Long studentId) {
		return studentService.findCourses(studentId);
	}
	
	@GetMapping("/students/{studentId}/courses/{courseId}")
	public CoursesDetailsModel retrieveDetailsForCourse(@PathVariable Long studentId,
			@PathVariable Long courseId) {
		return studentService.findCourseByIdStudentId(studentId, courseId);
	}
	
	@PostMapping("/students/{studentId}/courses")
	public ResponseEntity<Void> registerStudentForCourse(
			@PathVariable Long studentId, @RequestBody CoursesDetailsModel newCourse) {

		CoursesDetailsModel course = studentService.addCourse(studentId, newCourse);

		if (course == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(course.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
}
