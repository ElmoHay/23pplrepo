package com.example._23people.demo23ppl.controllers;

import com.example._23people.demo23ppl.models.Course;
import com.example._23people.demo23ppl.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("courses")
public class CourseController
{
    CourseService courseService;

    @Autowired
    public CourseController(CourseService service){
        this.courseService=service;
    }

    @GetMapping(path = "all")
    public @ResponseBody Iterable<Course> getAllCourses(){
        return courseService.getAll();
    }
}