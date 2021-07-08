package edu.maharishi.se.lab9.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.maharishi.se.lab9.application.domain.Student;
import edu.maharishi.se.lab9.application.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	public StudentRepository studentRepository;

	public List<Student> getStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	public String addStudent(Student student) throws Exception {
		try {
			studentRepository.save(student);
			return "Student was created successfully";
		} catch (Exception e) {
			throw new Exception("Exception: " + e);
		}
	}

	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).orElse(null);
	}

	public String updateStudent(Integer id) throws Exception {
		try {
			Student student = getStudentById(id);
			if (student != null) {
				student.setFirstName("First Name updated");
				student.setLastName("Second Name updated");
				studentRepository.save(student);
				return "Student was updated successfully";
			}
			return "Student not found";
		} catch (Exception e) {
			throw new Exception("Exception: " + e);
		}
	}

	public String deleteStudent(Integer id) throws Exception {
		try {
			studentRepository.deleteById(id);
			return "Student was deleted successfully";
		} catch (Exception e) {
			throw new Exception("Exception: " + e);
		}
	}

}
