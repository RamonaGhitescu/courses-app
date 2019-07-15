package com.courses.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "courses")
public class CoursesDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String title;
	private String content;

	public CoursesDetailsModel() {
		super();

	}

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "mentorID", referencedColumnName = "id")
	 * 
	 * @OnDelete(action = OnDeleteAction.CASCADE) private MentorsDetailsModel
	 * mentors;
	 * 
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "courses_students", joinColumns = @JoinColumn(name =
	 * "courseID", referencedColumnName = "id"), inverseJoinColumns
	 * = @JoinColumn(name = "studentID", referencedColumnName = "id")) private
	 * List<StudentsDetailsModel> students = new ArrayList<StudentsDetailsModel>();
	 */
	public CoursesDetailsModel(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
