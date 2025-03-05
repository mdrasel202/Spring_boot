package com.rasel.first_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasel.first_project.model.Student;
import com.rasel.first_project.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	private final StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		Student saveStudent = service.saveStudent(student);

		return saveStudent;
	}

	@GetMapping
	public List<Student> getStudents() {

		return service.getStudents();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
}
