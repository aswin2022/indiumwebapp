package com.indium.courses.controllers;

import com.indium.courses.models.Course;
import com.indium.courses.repositories.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseController {

    private static final Logger LOGGER= LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/addCourse")
    public String addCourse(@ModelAttribute("course") Course course, ModelMap modelmap){
        courseRepository.save(course);
        modelmap.addAttribute("msg","Course added Successfully");
        List courseList = courseRepository.findAll();
        modelmap.addAttribute("courseList", courseList);
        return "courses/course";
    }

}
