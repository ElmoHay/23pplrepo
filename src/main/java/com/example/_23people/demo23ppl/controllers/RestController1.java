package com.example._23people.demo23ppl.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example._23people.demo23ppl.repositories.StudentRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.example._23people.demo23ppl.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class RestController1
{
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String index()
    {
        return "Hi!";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/page/{pageNumber}/size/{pageSize}")
    public @ResponseBody Iterable<Student> getAllStudentsPaginate(@PathVariable("pageNumber") String pageNumber, 
    @PathVariable("pageSize") String pageSize){
        Pageable pageable = PageRequest.of( Integer.parseInt(pageNumber), Integer.parseInt(pageSize));
        Page<Student> page =  studentRepository.findAll(pageable);

        // return studentRepository.findAll();
        return page.getContent();
    }
    @GetMapping(path = "/{entryID}")
    public ResponseEntity<Student> getStudentByID(@PathVariable("entryID") String entryID){
        Optional<Student> studentOptional = studentRepository.findById(Long.parseLong(entryID));
        if(!studentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentOptional.get());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Object> postStudent(@RequestBody Student student){

        Student studentSaved = studentRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(studentSaved.getId()).toUri();
            
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> putStudent (@RequestBody Student student, @PathVariable Long id){
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(!studentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        student.setId(id);
        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteStudent (@PathVariable Long id){
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(!studentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        studentRepository.delete(studentRepository.findById(id).get());
        return ResponseEntity.ok().build();
    }
}