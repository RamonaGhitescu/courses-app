package com.courses.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courses.models.StudentsDetailsModel;

@Repository
public interface StudentsRepository extends JpaRepository<StudentsDetailsModel, Long>{
	Optional<StudentsDetailsModel> findById(Long id);
}
