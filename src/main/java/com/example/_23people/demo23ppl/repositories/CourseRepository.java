package com.example._23people.demo23ppl.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example._23people.demo23ppl.models.*;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long>
{
    //PagingAndSortingRepository also extends from CrudRepository
    //List<Course> findByLast_name(String last_name);
    //Course findById(Long id);
}