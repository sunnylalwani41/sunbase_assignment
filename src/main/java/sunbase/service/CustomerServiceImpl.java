package sunbase.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sunbase.model.Customer;
import sunbase.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		customer.setUuid(UUID.randomUUID().toString());
		
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> getListOfCustomer(Integer pageNumber, Integer numberOfCustomer, String sortingField,
			String sortingOrder) {
		Sort sort = null;
		
		if(sortingOrder.equals("asc")) {
			sort = Sort.by(sortingField).ascending();
		}
		else {
			sort = Sort.by(sortingField).descending();
		}
		
		Pageable pageable = PageRequest.of(pageNumber-1, numberOfCustomer, sort);
		Page<Customer> page= customerRepo.findAll(pageable);
		
		return page.getContent();
	}

	@Override
	public Customer getCustomerById(String uuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomerById(String uuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> syncCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
}
