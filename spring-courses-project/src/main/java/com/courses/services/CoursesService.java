package com.courses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.models.CoursesDetailsModel;
import com.courses.repositories.CoursesRepository;

@Service
public class CoursesService {

	@Autowired
	private CoursesRepository courseRepository;
	/*
	 * @Autowired private MentorsRepository mentorRepository;
	 */

	public List<CoursesDetailsModel> findAll() {
		return courseRepository.findAll();
	}

	public Optional<CoursesDetailsModel> findById(Long id) {
		return courseRepository.findById(id);
	}

	/*
	 * public Optional<CoursesDetailsModel> findCourseByMentorId(Long mentorID,
	 * MentorsDetailsModel mentors) { return
	 * courseRepository.findByMentorId(mentorID, mentors); }
	 */

	public CoursesDetailsModel save(CoursesDetailsModel course) {
		return courseRepository.save(course);
	}

	public void deleteById(Long id) {
		courseRepository.deleteById(id);
	}
	
    public Iterable<CoursesDetailsModel> saveAllCourses(List<CoursesDetailsModel> courses) {
        return courseRepository.saveAll(courses);
    }
}
