package com.coeligena.model;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

	private int courseId;
	
	private String courseName;

	@Id
	@Column(name = "courseId", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Column(name = "courseName", nullable = false, length = 32)
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
