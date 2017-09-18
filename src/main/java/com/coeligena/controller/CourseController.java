package com.coeligena.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.coeligena.model.Course;
import com.coeligena.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static Logger log = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@RequestMapping(value="/viewall", method=RequestMethod.GET)
	public String viewAllCourse(Model model) {

        List<Course> courseList = courseService.queryCourses();
        model.addAttribute(courseList);
		return "list";
	}

	// host:port/courses/view?courseid=1
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") int courseId, Model model) {
		
		log.debug("in viewcourse, courseId={}", courseId);
		
		Course course = courseService.getCourseById(courseId);
		model.addAttribute(course);
		
		return "success";
	}
	
	// host:port/courses/view2/{courseId} -- restful url
	@RequestMapping(value="/view2/{courseId}", method=RequestMethod.GET)
	public String viewCourse2(@PathVariable("courseId") int courseId, Map<String, Object> model) {
		
		log.debug("in viewcourse, courseId={}", courseId);
		
		Course course = courseService.getCourseById(courseId);
		model.put("course", course);
		
		return "success";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addCourse() {
		return "add";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCourse(@ModelAttribute Course course) {
		
		log.debug(ReflectionToStringBuilder.toString(course));
		
		// 业务操作，数据库持久化
		course.setCourseId(23);
		System.out.println("--" + course.getCourseName());
		
		return "redirect:view2/" + course.getCourseId();
	}

    @RequestMapping(value="/{courseId}",method=RequestMethod.GET)
    public @ResponseBody Course getCourseInJson(@PathVariable Integer courseId){
        return  courseService.getCourseById(courseId);
    }
}
