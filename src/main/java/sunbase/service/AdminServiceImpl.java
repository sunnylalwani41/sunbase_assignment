package sunbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sunbase.model.Admin;
import sunbase.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Admin registerAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
}
