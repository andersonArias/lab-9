package edu.maharishi.se.lab9.application.repository;

import org.springframework.data.repository.CrudRepository;

import edu.maharishi.se.lab9.application.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
