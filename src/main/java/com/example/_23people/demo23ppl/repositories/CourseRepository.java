package com.example._23people.demo23ppl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example._23people.demo23ppl.models.*;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long>
{
    //PagingAndSortingRepository also extends from CrudRepository
    //List<Course> findByLast_name(String last_name);
    //Course findById(Long id);
	@Procedure(name="getcourses")
	public List<?> getCourses();
}