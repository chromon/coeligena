package com.coeligena.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

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
