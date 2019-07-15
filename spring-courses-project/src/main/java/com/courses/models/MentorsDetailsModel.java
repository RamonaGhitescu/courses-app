package com.courses.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "mentors")
public class MentorsDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;

	/*
	 * @OneToMany(mappedBy = "mentors", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private Set<CoursesDetailsModel> courses = new
	 * HashSet<CoursesDetailsModel>();
	 */
	public MentorsDetailsModel() {
		super();
	}

	public MentorsDetailsModel(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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
}
