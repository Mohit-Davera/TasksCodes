package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@Controller
public class StudentController {
	@Autowired
	StudentRepo repo;
	private int totalUsersCount;
	private int lastPageNo;
	private int pageSize=10;
	
	int lastPageCounter(int count) {
		int lastPage = 0;
		if (totalUsersCount % pageSize != 0)
			lastPage = (int) (totalUsersCount / pageSize) + 1;
		else
			lastPage = (int) (totalUsersCount / pageSize);
		return lastPage;	
	}

	@RequestMapping(value = "/addstudents")
	public String addstudents(@RequestParam("id") List<Integer> ids 
			,@RequestParam("name") List<String> names 
			,@RequestParam("tech") List<String> techs) 
	{
		
		List<Student> listOfStudents = new ArrayList<Student>();
		for(int i=0;i<ids.size();i++) {
			
			int id = ids.get(i);
			String name = names.get(i);
			String tech = techs.get(i);
			
			if(name=="" && tech=="")
				continue;
			
			listOfStudents.add(new Student(id,name,tech));
		}
		
		int beforeCount = (int)repo.count();
		int beforeSpace = 10-(beforeCount%10);
		int newEntries = listOfStudents.size();
		
		@SuppressWarnings("unused")
		List<Student> savedStudents = repo.saveAll(listOfStudents);
		
		totalUsersCount = (int) repo.count();
		lastPageNo = lastPageCounter(totalUsersCount);
		System.out.println(beforeCount+" "+newEntries+" " +totalUsersCount);
		
		if(beforeSpace < newEntries) {
			lastPageNo--;
		}		
		return ("redirect:/?d-16496-p="+lastPageNo);
	}

	@RequestMapping("/newstudent")
	public ModelAndView newStudent() {
		int lastIndex = (int) repo.count()+111;
		ModelAndView mv = new ModelAndView("newstudent.jsp");
		mv.addObject("lastIndex",lastIndex);
		return mv;
	}
	
	@RequestMapping("/newstudents")
	public ModelAndView newStudents() {
		int lastIndex = (int) repo.count()+111;
		ModelAndView mv = new ModelAndView("newstudents.jsp");
		mv.addObject("lastIndex",lastIndex);
		return mv;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageno) {
//		int pageNo = Integer.parseInt(pageno);
//		int lastPageNo;
//		Pageable pageable = PageRequest.of(pageNo, pageSize);
//		Page<Student> page = repo.findAll(pageable);
//		totalUsersCount = (int)repo.count();
//
//		if (totalUsersCount % pageSize != 0)
//			lastPageNo = (int) (totalUsersCount / pageSize) + 1;
//		else
//			lastPageNo = (int) (totalUsersCount / pageSize);

		ModelAndView mv = new ModelAndView("index.jsp");
//		List<Student> listOfStudents = page.getContent();
		List<Student> listOfStudents = repo.findAll();
//		mv.addObject("totalUsersCount",totalUsersCount);
//		mv.addObject("pageNo",pageNo);
//		mv.addObject("lastPageNo", lastPageNo);
		mv.addObject("listOfStudents", listOfStudents);
		return mv;
	}

	@RequestMapping(value = "/jumpto", method = RequestMethod.GET)
	public String jumpTo(@RequestParam(value = "pageNo") int pageNo) {
		if (pageNo >= repo.count()) {

		}
		return "redirect:/?pageNo=" + (pageNo - 1);
	}

	@RequestMapping("/addstudent")
	public String addStudent(Student student) {
		ModelAndView mv = new ModelAndView();
		repo.save(student);
		totalUsersCount = (int)repo.count();
		mv.addObject(student);
		mv.setViewName("index");
		lastPageNo = lastPageCounter(totalUsersCount);
		
		return ("redirect:/?d-16496-p="+lastPageNo);
	}

//	HOME PAGE SECTION
	
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/showall")
	public ModelAndView showAll() {
		List<Student> listOfStudents = repo.findAll();
		ModelAndView mv = new ModelAndView("showall.jsp");
		mv.addObject("listOfStudents", listOfStudents);
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateIndividual(@RequestParam("id") int id) {
		Student student = repo.findById(id).orElse(null);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update.jsp");
		mv.addObject(student);
		return mv;
	}

	@RequestMapping("/getstudent")
	public ModelAndView getStudent(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		if (repo.existsById(id)) {
			mv.setViewName("showstudent.jsp");
			Student student = repo.findById(id).orElse(null);
			mv.addObject(student);
		} else
			mv.setViewName("notPresent.jsp");
		return mv;
	}

	@RequestMapping("/getstudentgt")
	public ModelAndView getStudentGT(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("showall.jsp");
		List<Student> listOfStudents = repo.findByIdGreaterThan(id - 1);
		mv.addObject("listOfStudents", listOfStudents);
		return mv;
	}

	@RequestMapping("/deleted")
	public ModelAndView deleteStudent(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		Student student = repo.findById(id).orElse(null);
		if (repo.existsById(id)) {
			repo.delete(repo.findById(id).orElse(null));
		} else {
			mv.setViewName("notPresent.jsp");
			return mv;
		}
		mv.addObject(student);
		mv.setViewName("deleted.jsp");
		return mv;
	}

	@PostMapping("/student")
	public Student addPostStudent(Student student) {
		
		repo.save(student);
		return student;
	}
}
