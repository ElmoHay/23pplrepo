package com.example._23people.demo23ppl.services;

import java.net.URI;
import java.util.Optional;

import com.example._23people.demo23ppl.models.Course;
import com.example._23people.demo23ppl.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public Page<Course> getAllPaginate(Pageable pageable)
    {
        return courseRepository.findAll(pageable);
    }
    public Course getByID(Long entryID) {

        Optional<Course> courseOptional = courseRepository.findById(entryID);

        if(!courseOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A Course with ID nº "+ entryID.toString()
                +" could not be found. Please provide a valid ID and try again");
        }
        return courseOptional.get();
    }

    public ResponseEntity<Object> create(Course course){
        Course courseSaved = courseRepository.save(course);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(courseSaved.getId()).toUri();
            
        return ResponseEntity.created(location).build();
    }
}