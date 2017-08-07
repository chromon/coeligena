package com.coeligena.service.impl;

import com.coeligena.dao.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeligena.model.Course;
import com.coeligena.service.CourseService;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;

    @Override
	public void addCourse(Course course) {
		this.courseDAO.addCourse(course);
	}

    @Override
	public List<Course> queryCourses() {
		return this.courseDAO.queryCourses();
	}

	public Course getCourseById(int courseId) {
		Course course = new Course();
		course.setCourseId(courseId);
		course.setCourseName("Java");
		return course;
	}

}
