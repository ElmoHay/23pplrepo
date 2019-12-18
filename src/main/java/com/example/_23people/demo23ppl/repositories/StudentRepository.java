package com.example._23people.demo23ppl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

import com.example._23people.demo23ppl.models.*;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>, JpaRepository<Student, Long>
{
    //PagingAndSortingRepository also extends from CrudRepository
    List<Student> findByCourseId(Long CourseId);
    Optional<Student> findByIdAndCourseId(Long id, Long CourseId);
}