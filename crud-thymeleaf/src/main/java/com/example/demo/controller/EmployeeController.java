package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository repository;

    @GetMapping("/displaytag")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		int count = (int) repository.count();
		int reminder = (int)(count/10);
		int totalPages = (count%10 == 0) ? reminder : ++reminder  ;
		return "redirect:/?pageNo="+totalPages;
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}

	@RequestMapping("/")
	public String findPaginated(@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "sortField", required = false, defaultValue = "id") String sortField,
			@RequestParam(value = "sortDir", required = false, defaultValue = "asc") String sortDir,
			Model model) {
 

		Page<Employee> page = employeeService.findPaginated(pageNo - 1, 10,sortField,sortDir);
		List<Employee> listEmployees = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("listEmployees", listEmployees);

		return "index";
	}
}
