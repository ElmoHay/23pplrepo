package com.example._23people.demo23ppl.controllers;

import com.example._23people.demo23ppl.models.Course;
import com.example._23people.demo23ppl.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping
    public @ResponseBody Page<Course> getAllStudentsPaginate(Pageable pageable) 
    {
        return courseService.getAllPaginate(pageable);
    }
     
    @GetMapping(path = "/{entryID}")
    public Course getCourseByID(@PathVariable("entryID") Long entryID) throws ResponseStatusException {
        return courseService.getByID(entryID);
    }

    @PostMapping
    public ResponseEntity<Object> postCourse(@RequestBody Course course){
        return courseService.create(course);
    }
}