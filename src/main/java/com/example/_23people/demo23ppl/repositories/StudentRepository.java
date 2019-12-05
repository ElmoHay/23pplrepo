package com.example._23people.demo23ppl.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.example._23people.demo23ppl.models.*;

public interface StudentRepository extends StudentRepo<Student, Long>
{
    //List<Student> findByLast_name(String last_name);
    //Student findById(Long id);
}