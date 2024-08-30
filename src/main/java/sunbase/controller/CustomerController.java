package sunbase.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sunbase.exception.CustomerException;
import sunbase.model.Customer;
import sunbase.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/customerAdd")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.ACCEPTED);
	}

	@PutMapping("/customerUpdate")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getCustomerList")
	public ResponseEntity<List<Customer>> getCustomerList(@RequestParam String field, @RequestParam String value) {
		return new ResponseEntity<> (customerService.getListOfCustomer(field, value), HttpStatus.OK);
	}

	@GetMapping("/getCustomerById/{uuId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable String uuId) throws CustomerException {
		return new ResponseEntity<Customer>(customerService.getCustomerById(uuId), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCustomer/{uuId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable String uuId) throws CustomerException {
		return new ResponseEntity<Customer>(customerService.deleteCustomerById(uuId), HttpStatus.OK);
	}

	@GetMapping("/getCustomerByRemoteApi")
	public ResponseEntity<List<Customer>> getCustomerByRemoteApi() throws IOException {
		return new ResponseEntity<>(customerService.syncCustomer(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer() throws IOException {
		return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.ACCEPTED);
	}
}