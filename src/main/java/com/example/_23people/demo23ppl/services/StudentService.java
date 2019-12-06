package com.example._23people.demo23ppl.services;

import java.net.URI;
import java.util.Optional;

import com.example._23people.demo23ppl.models.Student;
import com.example._23people.demo23ppl.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;

    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Iterable<Student> getAllStudentsPaginate(Long pageNumber, Long pageSize)
    {
        Pageable pageable = PageRequest.of(pageNumber.intValue(), pageSize.intValue());
        Page<Student> page =  studentRepository.findAll(pageable);

        // return studentRepository.findAll();
        return page.getContent();
    }

    public ResponseEntity<Student> getStudentByID(Long entryID){
        Optional<Student> studentOptional = studentRepository.findById(entryID);
        if(!studentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentOptional.get());
    }

    public ResponseEntity<Object> createStudent(Student student){
        Student studentSaved = studentRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(studentSaved.getId()).toUri();
            
        return ResponseEntity.created(location).build();
    }

    public ResponseEntity<Object> putTheStudent(Student student, Long id){
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(!studentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        student.setId(id);
        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Object> DelTheStudent(Long id)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(!studentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        studentRepository.delete(studentRepository.findById(id).get());
        return ResponseEntity.ok().build();
    }
}