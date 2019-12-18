package com.example._23people.demo23ppl.services;

import com.example._23people.demo23ppl.models.Course;
import com.example._23people.demo23ppl.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService{
    CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    public Iterable<Course> getAll()
    {
        return courseRepository.findAll();
    }
}