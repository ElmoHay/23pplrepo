package com.example._23people.demo23ppl.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example._23people.demo23ppl.services.StudentService;
import com.example._23people.demo23ppl.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("students")
public class StudentController
{
    private StudentService studentService;
    
    //for decoupling purposes (i.e allow testing) let class constructor takeover D.I.
    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String index()
    {
        return "Hi!";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Student> getAllStudents(){
        return studentService.getAll();
    }

    @GetMapping
    public @ResponseBody Page<Student> getAllStudentsPaginate(Pageable pageable) 
    {
        return studentService.getAllPaginate(pageable);
    }
     
    @GetMapping(path = "/{entryID}")
    public Student getStudentByID(@PathVariable("entryID") Long entryID){
        return studentService.getByID(entryID);
    }

    @PostMapping
    public ResponseEntity<Object> postStudent(@RequestBody Student student){

        return studentService.create(student);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> putStudent (@RequestBody Student student, @PathVariable Long id){
        return studentService.put(student, id);
    }

    //DONE: refactored
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id){
        studentService.delete(id);
    }
}