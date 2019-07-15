package com.courses.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courses.models.CoursesDetailsModel;

@Repository
public interface CoursesRepository extends JpaRepository<CoursesDetailsModel, Long> {
	Optional<CoursesDetailsModel> findById(Long id);

//	Optional<CoursesDetailsModel> findByMentorId(Long MentorID, MentorsDetailsModel mentors);
}
