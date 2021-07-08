package edu.maharishi.se.lab9.application.controllar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.maharishi.se.lab9.application.domain.Student;
import edu.maharishi.se.lab9.application.service.StudentService;

@RestController
@RequestMapping(path = "/eregistrar/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping("/register")
	public String addStudent(@RequestBody Student student) throws Exception {
		return studentService.addStudent(student);
	}

	@GetMapping("/get/{idGet}")
	public Student getStudent(@PathVariable("idGet") Integer idGet) {
		return studentService.getStudentById(idGet);
	}
	
	@PutMapping("/update/{idUpdate}")
	public String updateStudent(@PathVariable("idUpdate") Integer idUpdate) 
			throws Exception {
		return studentService.updateStudent(idUpdate);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) throws Exception {
		return studentService.deleteStudent(id);
	}

}
