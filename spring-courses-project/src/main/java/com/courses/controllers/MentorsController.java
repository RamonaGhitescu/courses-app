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

import com.courses.models.MentorsDetailsModel;
import com.courses.services.MentorsService;

@RequestMapping("/")
@RestController
public class MentorsController {
	private static final Logger logger = LoggerFactory.getLogger(MentorsController.class);

	@Autowired
	private MentorsService mentorService;

	@GetMapping("/mentors-all")
	public ResponseEntity<List<MentorsDetailsModel>> findAll() {
		return ResponseEntity.ok(mentorService.findAll());
	}

	@GetMapping("/mentors/{id}")
	public ResponseEntity<MentorsDetailsModel> findById(@PathVariable Long id) {
		Optional<MentorsDetailsModel> mentor = mentorService.findById(id);
		if (!mentor.isPresent()) {
			logger.error("The mentor ID " + id + " does not exist");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(mentor.get());
	}

	@PostMapping("/mentors")
	public ResponseEntity<MentorsDetailsModel> createCourse(@Valid @RequestBody MentorsDetailsModel mentor) {
		return ResponseEntity.ok(mentorService.save(mentor));
	}

	@PutMapping("/update-mentor/{id}")
	public ResponseEntity<MentorsDetailsModel> update(@PathVariable Long id,
			@Valid @RequestBody MentorsDetailsModel mentor) {
		if (!mentorService.findById(id).isPresent()) {
			logger.error("The mentor ID " + id + " does not exist");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(mentorService.save(mentor));
	}

	@DeleteMapping("/mentors/{id}")
	public ResponseEntity<MentorsDetailsModel> delete(@PathVariable Long id) {
		if (!mentorService.findById(id).isPresent()) {
			logger.error("The mentor ID " + id + " does not exist");
			ResponseEntity.badRequest().build();
		}
		mentorService.deleteById(id);

		return ResponseEntity.ok().build();
	}

}
