package com.coeligena.dao;

import com.coeligena.model.Course;

import java.util.List;

public interface CourseDAO {

    void addCourse(Course course);

    List<Course> queryCourses();
}
