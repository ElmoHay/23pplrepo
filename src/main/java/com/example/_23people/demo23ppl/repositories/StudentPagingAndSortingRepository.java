package com.example._23people.demo23ppl.repositories;

import com.example._23people.demo23ppl.models.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPagingAndSortingRepository extends PagingAndSortingRepository<Student, Long>{
    
}