package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.User;
import com.example.demo.services.RDPService;

@Controller
public class RDPController {
	@Autowired
	private RDPService service;
@GetMapping("/calendar")
public String Calendar() {
	return "calendar";
}
@GetMapping("/gallery")
public String Gallerry() {
	return "gallery";
}
@GetMapping("/users")
public String Users(Model model) {
	List<User> userList = service.ListAll();
	model.addAttribute("userList",userList);
	return "users";
}
@RequestMapping(value = "/register", method = RequestMethod.POST)
public String saveUser(@ModelAttribute("user") User usr) {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String encodedPassword = passwordEncoder.encode(usr.getPassword());
	usr.setPassword(encodedPassword);
    service.Save(usr);
    return "redirect:/users";
}
}
