package sunbase.service;

import java.io.IOException;
import java.util.List;

import sunbase.exception.CustomerException;
import sunbase.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public List<Customer> getListOfCustomer(Integer pageNumber, String sortingField);
	
	public Customer getCustomerById(String uuId) throws CustomerException;
	
	public Customer deleteCustomerById(String uuId)throws CustomerException;
	
	public List<Customer> syncCustomer() throws IOException;
}