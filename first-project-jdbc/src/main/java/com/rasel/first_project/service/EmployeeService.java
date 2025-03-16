package com.rasel.first_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rasel.first_project.model.Employee;
import com.rasel.first_project.repository.EmployeeRepository;

//@Slf4j
@Service
public class EmployeeService {

	private final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public Employee saveEmployee(Employee employee) {
		int save = repository.save(employee);
		return getEmpById(save);
	}

	public Employee getEmpById(int id) {
		Optional<Employee> byId = repository.findById(id);
		return byId.get();
	}

	public List<Employee> getAllEmp() {
		List<Employee> all = repository.findAll();
		return all;
	}

	public void deleteById(int id) {
		repository.deleteById(id);

	}

}
