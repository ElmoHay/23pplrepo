package com.example._23people.demo23ppl.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.example._23people.demo23ppl.services.StudentService;


import com.example._23people.demo23ppl.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class StudentController
{
    
    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String index()
    {
        return "Hi!";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // TODO: replace the call to use PagingAndSortingRepository, delete the route param's ...
    @GetMapping(path = "/page/{pageNumber}/size/{pageSize}")
    public @ResponseBody Iterable<Student> getAllStudentsPaginate(@PathVariable("pageNumber") Long pageNumber, 
    @PathVariable("pageSize") Long pageSize){
        return studentService.getAllStudentsPaginate(pageNumber, pageSize);
    }
    @GetMapping(path = "/{entryID}")
    public ResponseEntity<Student> getStudentByID(@PathVariable("entryID") Long entryID){
        return studentService.getStudentByID(entryID);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Object> postStudent(@RequestBody Student student){

        return studentService.createStudent(student);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> putStudent (@RequestBody Student student, @PathVariable Long id){
        return studentService.putTheStudent(student, id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id){
        return studentService.DelTheStudent(id);
    }
}