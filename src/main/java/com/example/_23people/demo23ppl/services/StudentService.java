package com.example._23people.demo23ppl.services;

import java.net.URI;
import java.util.Optional;

import com.example._23people.demo23ppl.exceptions.StudentNotFoundException;
import com.example._23people.demo23ppl.models.Student;
import com.example._23people.demo23ppl.repositories.StudentPagingAndSortingRepository;
import com.example._23people.demo23ppl.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class StudentService
{
    
    StudentRepository studentRepository;
    StudentPagingAndSortingRepository studentPagingandSortRepo;

    @Autowired
    StudentService(StudentRepository studentRepository, 
                   StudentPagingAndSortingRepository studentPageandSortRepo){
        this.studentRepository = studentRepository;
        this.studentPagingandSortRepo = studentPageandSortRepo;
    }

    public Iterable<Student> getAll(){
        return studentRepository.findAll();
    }

    public Page<Student> getAllPaginate(Pageable pageable)
    {
        return studentPagingandSortRepo.findAll(pageable);
    }
    //TO-DO: refactor
    public Student getByID(Long entryID) throws StudentNotFoundException {

        Optional<Student> studentOptional = studentRepository.findById(entryID);

        if(!studentOptional.isPresent()) {
            throw new StudentNotFoundException("I'm sorry, no student could be found "
                +"for the given the id: " + entryID.toString());
        }
        return studentOptional.get();
    }
    //TO-DO: refactor
    public ResponseEntity<Object> create(Student student){
        Student studentSaved = studentRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(studentSaved.getId()).toUri();
            
        return ResponseEntity.created(location).build();
    }
    //TO-DO: refactor
    public ResponseEntity<Object> put(Student student, Long id){
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(!studentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        student.setId(id);
        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }
    
    //TODO: commented lines to be used in post method and/or validation
    public void delete(Long id)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(!studentOptional.isPresent()) {
        	throw new StudentNotFoundException("No student with ID "+ id.toString() 
                +" could be found to be deleted");
            // throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A student with ID nº "+ id.toString()
                // +" could not be found. Please provide a valid ID and try again");
        }
        
        studentRepository.delete(studentRepository.findById(id).get());
    }
}