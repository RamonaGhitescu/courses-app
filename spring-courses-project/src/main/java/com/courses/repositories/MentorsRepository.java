package com.courses.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courses.models.MentorsDetailsModel;

@Repository
public interface MentorsRepository extends JpaRepository<MentorsDetailsModel, Long>{
	Optional<MentorsDetailsModel> findById(Long id);
}
