package sunbase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sunbase.exception.AdminException;
import sunbase.model.Admin;
import sunbase.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		Optional<Admin> alreadyRegister = adminRepo.findByUsername(admin.getUsername());
		
		if(alreadyRegister.isEmpty())
			return adminRepo.save(admin);
		
		throw new AdminException("This username already registered.");
	}
}