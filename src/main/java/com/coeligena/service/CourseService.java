package com.coeligena.service;

import com.coeligena.model.Course;

import java.util.List;

public interface CourseService {

	void addCourse(Course course);

	List<Course> queryCourses();

	Course getCourseById(int courseId);
}
