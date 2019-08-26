package com.bootcamp.Ujian.Webservice;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.Ujian.model.User;
import com.bootcamp.controller.Controller;
import com.bootcamp.Ujian.model.User;
import com.bootcamp.Ujian.model.Personnel;
import com.bootcamp.Ujian.model.Personnel;

@RestController
public class ServiceController {

	@GetMapping(path = "hello-world")
	public User HelloWorld() {

	

		User user = new User();
		user.setId(2);
		user.setUsername("aldi");
		user.setEmail("aldi@klien1.co.id");
		return user;
	}

	@GetMapping(path = "/hello/input/{isi}/{isi2}")
	public String HelloVariable(@PathVariable String isi, @PathVariable String isi2) {

		return String.format("Helo nama saya adalah %s , dan teman saya adalah %s", isi, isi2);

	}

	@GetMapping(path = "perpustakaan/anggota/all")

	public List<Personnel> getAllPersonnel() {

		return Controller.getInstance().getAllPersonnel();

	}

	@GetMapping(path = "perpustakaan/personnel/search/{name}")

	public List<Personnel> getAllPersonnel(@PathVariable String name) {

		return Controller.getInstance().searchid("id");

	}
	
	
	@PostMapping(path = "programmer/personnel/add")
	public void addPersonnel (@RequestBody Personnel personnel ) {
		System.out.println(personnel);
		Controller.getInstance().saveDataPersonnel(personnel);
		
	}

}
