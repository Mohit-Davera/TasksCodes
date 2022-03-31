package com.example.demo;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.PrincipalPassword;
import com.example.demo.models.User;

@Controller
public class HomeResource {
	@Autowired
	UserRepository repo;
	
	@Autowired
    PasswordEncoder passwordEncoder;

	@RequestMapping("/")
	public String home() {
		return "welcome.jsp";
	}
	
//	@RequestMapping("/login")
//	public String login() {
//		return "login.jsp";
//	}
	
	@RequestMapping("/signin")
	public ModelAndView signin() {
		ModelAndView mv = new ModelAndView("register.jsp");
		mv.addObject("userForm",new NewPassword());
		return mv;
	}

	@GetMapping("/guest")
	@ResponseBody
	public String user() {
		return ("<h1>Welcome guest</h1>"
				+ "<a href=\"update\">Update Password</a><br>"
				+ "<a href=\"logout\">Logout</a><br> ");
	}

	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return ("<h1>Hello Admin</h1>"
				+ "<a href=\"/showall\">Show all records</a><br>"
				+ "<a href=\"update\">Update Password</a><br>");
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("userForm") NewPassword pas) {
		String roles = "GUEST";
		if(repo.existsByUserName(pas.getUsername()))
		{
			return "already.jsp";
		}
		User user = new User();
		user.setUserName(pas.getUsername());
		user.setPassword(passwordEncoder.encode(pas.getPassword()));
		user.setRoles(roles);
		user.setActive(true);
		repo.save(user);
		
		String redirectUrl = "/login";
		return "redirect:" + redirectUrl;
	}
	
	@RequestMapping("/404")
	public ModelAndView register(@RequestParam("uname") String userName,
			@RequestParam("pass") String password,
			@RequestParam("roles") String role) {
		
		String roles = "USER";
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setRoles(roles);
		user.setActive(true);
		repo.save(user);
		System.out.println(role);
		
		ModelAndView mv = new ModelAndView("welcome.jsp");
		mv.addObject("userName", userName);
		return mv;
	}
	
	@RequestMapping("/showall")
	public ModelAndView showall() {
		ModelAndView mv = new ModelAndView("showall.jsp");
		List<User> listOfUsers = repo.findAll();
		mv.addObject("listOfUsers",listOfUsers);
		return mv;
	}
	
	@RequestMapping("/active")
	public String active(@RequestParam("userName") String userName) {
		User db_user = repo.findByUserName(userName).orElse(null);
		db_user.setActive(true);
		String redirectUrl = "/showall";
		repo.save(db_user);
		return "redirect:" + redirectUrl;	
	}
	
	@RequestMapping("/deactive")
	public String deactive(@RequestParam("userName") String userName) {
		User db_user = repo.findByUserName(userName).orElse(null);
		db_user.setActive(false);
		
		String redirectUrl = "/showall";
		repo.save(db_user);
		return "redirect:" + redirectUrl;	
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("userName") String userName) {
		User db_user = repo.findByUserName(userName).orElse(null);
		System.out.println(db_user);
		repo.deleteById(db_user.getId());
		String redirectUrl = "/showall";
		return "redirect:" + redirectUrl;	
	}
	
	@RequestMapping(value = "/update")
    public ModelAndView updatepage(Principal principal) {
		ModelAndView mv =new ModelAndView("update.jsp");
		User user = repo.findByUserName(principal.getName()).orElse(null);
		mv.addObject("user",user);
		mv.addObject("userForm",new NewPassword());
        return mv;
    }
	
//	@RequestMapping(value="/updateuser")
//	@ResponseBody
//	public String changePassword(Principal principal,@RequestParam("password") String password) {
//		User user = repo.findByUserName(principal.getName()).orElse(null);
//		System.out.println(password);
//		user.setPassword(passwordEncoder.encode(password));
//		repo.save(user);
//		return "<h1>updated</h1>";
//	}

	@PostMapping(value="/updateuser")
	@ResponseBody
	public String changePassword(@ModelAttribute("userForm") NewPassword data) {
		User user = repo.findByUserName(data.getUsername()).orElse(null);
		user.setPassword(passwordEncoder.encode(data.getPassword()));
		repo.save(user);
		return "<h1>updated</h1>";
	}
	
	
	
	

}
