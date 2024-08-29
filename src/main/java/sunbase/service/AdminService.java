package sunbase.service;

import sunbase.exception.AdminException;
import sunbase.model.Admin;

public interface AdminService {
	public Admin registerAdmin(Admin admin) throws AdminException;
}