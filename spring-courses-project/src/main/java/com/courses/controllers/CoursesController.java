package com.courses.controllers;

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

import com.courses.models.CoursesDetailsModel;
import com.courses.services.CoursesService;
@RequestMapping("/")
@RestController
public class CoursesController {

	private static final Logger logger = LoggerFactory.getLogger(CoursesController.class);

	@Autowired
	private CoursesService courseService;
	
	@GetMapping("/courses-all")
	public ResponseEntity<List<CoursesDetailsModel>> findAll() {
		return ResponseEntity.ok(courseService.findAll());
	}

	@GetMapping("/courses/{id}")
	public ResponseEntity<CoursesDetailsModel> findById(@PathVariable Long id) {
		Optional<CoursesDetailsModel> course = courseService.findById(id);
		if (!course.isPresent()) {
			logger.error("The course ID " + id + " does not exist");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(course.get());
	}

	@PostMapping("/courses")
	public ResponseEntity<CoursesDetailsModel> createCourse(@Valid @RequestBody CoursesDetailsModel course) {
		return ResponseEntity.ok(courseService.save(course));
	}

	@PutMapping("/update-course/{id}")
	public ResponseEntity<CoursesDetailsModel> update(@PathVariable Long id,
			@Valid @RequestBody CoursesDetailsModel course) {
		if (!courseService.findById(id).isPresent()) {
			logger.error("The course ID " + id + " does not exist");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(courseService.save(course));
	}

	@DeleteMapping("/courses/{id}")
	public ResponseEntity<CoursesDetailsModel> delete(@PathVariable Long id) {
		if (!courseService.findById(id).isPresent()) {
			logger.error("The course ID " + id + " does not exist");
			ResponseEntity.badRequest().build();
		}
		courseService.deleteById(id);

		return ResponseEntity.ok().build();
	}

}
