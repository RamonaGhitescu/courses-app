package com.courses.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.models.CoursesDetailsModel;
import com.courses.models.StudentsDetailsModel;
import com.courses.repositories.StudentsRepository;

@Service
public class StudentsService {
	@Autowired
	private StudentsRepository studentRepository;

	private static List<StudentsDetailsModel> students = new ArrayList<>();
	private static long courseID = 0;
	private static long studentID = 0;
	static {
		CoursesDetailsModel course1 = new CoursesDetailsModel(++courseID, "Angular",
				"Fully understand the architecture behind an Angular 8 application and how to use it");
		CoursesDetailsModel course4 = new CoursesDetailsModel(++courseID, "CSS",
				"Learn CSS for the first time or brush up your CSS skills and dive in even deeper. EVERY web developer has to know CSS.");
		StudentsDetailsModel student1 = new StudentsDetailsModel(++studentID, "Student1", "StudentTest1",
				new ArrayList<>(Arrays.asList(course1)));
		StudentsDetailsModel student2 = new StudentsDetailsModel(++studentID, "Student2", "StudentTest2",
				new ArrayList<>(Arrays.asList(course4)));

		students.add(student1);
		students.add(student2);
	}

	public List<StudentsDetailsModel> findAllStudents() {
		return students;
	}

	public StudentsDetailsModel findStudentById(Long studentId) {
		for (StudentsDetailsModel student : students) {
			if (student.getId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

	public List<CoursesDetailsModel> findCourses(Long studentId) {
		StudentsDetailsModel student = findStudentById(studentId);

		if (student == null) {
			return null;
		}

		return student.getCourses();
	}

	public CoursesDetailsModel findCourseByIdStudentId(Long studentId, Long courseId) {
		StudentsDetailsModel student = findStudentById(studentId);

		if (student == null) {
			return null;
		}

		for (CoursesDetailsModel course : student.getCourses()) {
			if (course.getId().equals(courseId)) {
				return course;
			}
		}

		return null;
	}

	public CoursesDetailsModel addCourse(Long studentId, CoursesDetailsModel course) {
		StudentsDetailsModel student = findStudentById(studentId);

		if (student == null) {
			return null;
		}
		student.getCourses().add(course);

		return course;
	}

	public Optional<StudentsDetailsModel> findById(Long id) {
		return studentRepository.findById(id);
	}

	public StudentsDetailsModel save(StudentsDetailsModel student) {
		return studentRepository.save(student);
	}

	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}
	
    public Iterable<StudentsDetailsModel> saveAllStudents(List<StudentsDetailsModel> students) {
        return studentRepository.saveAll(students);
    }
}
