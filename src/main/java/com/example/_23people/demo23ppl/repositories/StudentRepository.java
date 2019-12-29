package com.example._23people.demo23ppl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import com.example._23people.demo23ppl.models.*;

public interface StudentRepository extends JpaRepository<Student, Long>
{
    //PagingAndSortingRepository also extends from CrudRepository
    List<Student> findByCourseId(Long CourseId);
    Optional<Student> findByIdAndCourseId(Long id, Long CourseId);
}