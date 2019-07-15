package com.courses.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "students")
public class StudentsDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	@Transient
	 private List<CoursesDetailsModel> courses;
	 
	
	/*
	 * @ManyToMany(mappedBy = "students") private List<CoursesDetailsModel> courses
	 * =new ArrayList<>();
	 */
	 
	public StudentsDetailsModel() {
		super();
	}

	public StudentsDetailsModel(Long id, String firstName, String lastName, List<CoursesDetailsModel> courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<CoursesDetailsModel> getCourses() {
		return courses;
	}

	public void setCourses(List<CoursesDetailsModel> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return String.format(
				"Student [id=%s, firstName=%s, lastName=%s, email=%s, courses=%s]", id,
				firstName, lastName, email, courses);
	}

}
