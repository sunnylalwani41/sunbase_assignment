package sunbase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspPageMappingController {
	@GetMapping("registrationAdmin")
	public String registrationAdmin() {
		return "registrationAdmin";
	}
	
	@GetMapping("customerDetail")
	public String customerDetail() {
		return "customerDetail";
	}
	
	@GetMapping("addCustomerDetail")
	public String addCustomerDetail() {
		return "addCustomerDetail";
	}
}
