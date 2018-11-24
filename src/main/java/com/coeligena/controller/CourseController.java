package com.coeligena.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.coeligena.model.Course;
import com.coeligena.service.CourseService;

import javax.annotation.Resource;


@Controller
@RequestMapping("/courses")
public class CourseController {

	private static Logger log = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@Resource
    private RedisTemplate redisTemplate;

	@ResponseBody
    @RequestMapping(value="/redis", method=RequestMethod.GET)
    public Course testRedis() {
	    Course c = new Course();
	    c.setCourseId(1);
	    c.setCourseName("test");

//        redisTemplate.opsForValue().set("course:" + c.getCourseId(), c);
//
//        Course c2 = (Course) redisTemplate.opsForValue().get("course:" + c.getCourseId());

        redisTemplate.convertAndSend("feedHandler", c);

//        redisTemplate.opsForZSet().add("zset=1","zset-1哈",1.0);
//        redisTemplate.opsForZSet().add("zset=1","zset-11哈",2.0);
//        redisTemplate.opsForZSet().add("zset=2","zset-2哈",3.0);
//        redisTemplate.opsForZSet().add("zset=3","zset-3哈",4.0);
//
//        System.out.println(redisTemplate.opsForZSet().range("zset=1", 0, -1));
//        System.out.println(redisTemplate.opsForZSet().range("zset=1", 0, 1));
//        System.out.println(redisTemplate.opsForZSet().range("zset=1", 0, 1).toArray()[0]);
//        System.out.println(redisTemplate.opsForZSet().rangeByScore("zset=1", 0 ,1));
//        System.out.println(redisTemplate.opsForZSet().remove("zset=1", "zset-1哈"));
//        System.out.println(redisTemplate.opsForZSet().range("zset=1", 0 ,10));

        redisTemplate.opsForZSet().add("fan6", "a", 1);
        redisTemplate.opsForZSet().add("fan6", "b", 3);
        redisTemplate.opsForZSet().add("fan6", "c", 2);
        redisTemplate.opsForZSet().add("fan6", "d", -1);
        //从排序集中获取开始和结束之间的元组(Tuple)。
        Set<TypedTuple<Object>> rangeWithScores = redisTemplate.opsForZSet().rangeWithScores("fan6", 0  , -1);
        Iterator<TypedTuple<Object>> iterator = rangeWithScores.iterator();
        while(iterator.hasNext()){
            TypedTuple<Object> next = iterator.next();
            System.out.println("value:"+next.getValue()+" score:"+next.getScore());

        }
        System.out.println("----------");
        Set<TypedTuple<Object>> rangeWithScores2 = redisTemplate.opsForZSet().reverseRangeWithScores("fan6", 0  , 2);
        Iterator<TypedTuple<Object>> iterator2 = rangeWithScores2.iterator();
        while(iterator2.hasNext()){
            TypedTuple<Object> next2 = iterator2.next();
            System.out.println("value:"+next2.getValue()+" score:"+next2.getScore());

        }
        return c;
    }

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
