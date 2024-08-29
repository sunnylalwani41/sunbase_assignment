package sunbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import sunbase.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired CustomerService customerService;
}
