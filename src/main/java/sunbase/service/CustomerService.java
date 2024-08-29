package sunbase.service;

import java.util.List;

import sunbase.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public List<Customer> getListOfCustomer(Integer pageNumber, Integer numberOfCustomer, String sortingField, String sortingOrder);
	
	public Customer getCustomerById(String uuId);
	
	public Customer deleteCustomerById(String uuId);
	
	public List<Customer> syncCustomer();
}