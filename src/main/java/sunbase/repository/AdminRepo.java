package sunbase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sunbase.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
	public Optional<Admin> findByUsername(String username);
}
