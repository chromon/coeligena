package com.coeligena.dao.impl;

import com.coeligena.dao.CourseDAO;
import com.coeligena.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO{

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCourse(Course course) {
        this.getSession().save(course);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Course> queryCourses() {
        return (List<Course>) this.getSession().createQuery("from Course").list();
    }
}
