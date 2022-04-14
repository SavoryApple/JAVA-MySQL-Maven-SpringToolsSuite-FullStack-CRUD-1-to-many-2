package com.seannavery.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seannavery.studentroster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
    // this method retrieves all the books from the database
    List<Student> findAll();
    // this method finds books with descriptions containing the search string
//    List<Book> findByDescriptionContaining(String search); //be CAREFUL with these bottom three
    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
}
