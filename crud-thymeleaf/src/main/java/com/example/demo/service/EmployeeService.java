package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	};

	public void saveEmployee(Employee employee) {
		repository.save(employee);
	}

	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = repository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	public void deleteEmployeeById(long id) {
		repository.deleteById(id);
	}
	
	public Page<Employee> findPaginated(int pageNo,int pageSize,String sortField,String sortDir) {
		
		 Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
	            Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo,10,sort);
		return repository.findAll(pageable);
	}
	
	
}
