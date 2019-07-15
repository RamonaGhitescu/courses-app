package com.courses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.models.MentorsDetailsModel;
import com.courses.repositories.MentorsRepository;

@Service
public class MentorsService {

	@Autowired
	private MentorsRepository mentorRepository;

	public List<MentorsDetailsModel> findAll() {
		return mentorRepository.findAll();
	}

	public Optional<MentorsDetailsModel> findById(Long id) {
		return mentorRepository.findById(id);
	}

	public MentorsDetailsModel save(MentorsDetailsModel mentor) {
		return mentorRepository.save(mentor);
	}

	public void deleteById(Long id) {
		mentorRepository.deleteById(id);
	}
	
    public Iterable<MentorsDetailsModel> saveAllMentors(List<MentorsDetailsModel> mentors) {
        return mentorRepository.saveAll(mentors);
    }
}
