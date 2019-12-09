package com.example._23people.demo23ppl.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example._23people.demo23ppl.services.StudentService;
import com.example._23people.demo23ppl.exceptions.StudentNotFoundException;
import com.example._23people.demo23ppl.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("students/")
public class StudentController
{
    // TODO:  
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

    
    @GetMapping(path = "/paginated")
    public @ResponseBody Iterable<Student> getAllStudentsPaginate(@RequestParam("pageNumber") Long pageNumber, 
    @RequestParam("pageSize") Long pageSize){
        return studentService.getAllStudentsPaginate(pageNumber, pageSize);
    }
     
    @GetMapping(path = "/{entryID}")
    public Student getStudentByID(@PathVariable("entryID") Long entryID){
        try {
            return studentService.getStudentByID(entryID);
        } catch(StudentNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
            		"I'm sorry, no student could be found for the given the id: "+entryID.toString(),ex);
        }        
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