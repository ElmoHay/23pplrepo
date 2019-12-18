package com.example._23people.demo23ppl.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example._23people.demo23ppl.models.*;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>
{
    //PagingAndSortingRepository also extends from CrudRepository
    //List<Student> findByLast_name(String last_name);
    //Student findById(Long id);
}