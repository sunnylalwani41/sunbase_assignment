package sunbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import sunbase.exception.AdminException;
import sunbase.model.Admin;
import sunbase.service.AdminService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) throws AdminException {
		System.out.println("hc");
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		admin.setRole("ADMIN");
		
		admin = adminService.registerAdmin(admin);
		
		return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
	}
}