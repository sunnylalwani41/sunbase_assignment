package sunbase.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import sunbase.model.Admin;
import sunbase.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String>, PagingAndSortingRepository<Customer, String>{
	Page<Customer> findByFirstName(String firstName, Pageable pageable);
	
	Page<Customer> findByCity(String city, Pageable pageable);
	
	Page<Customer> findByEmail(String email, Pageable pageable);
	
	Page<Customer> findByPhone(String phone, Pageable pageable);
}
