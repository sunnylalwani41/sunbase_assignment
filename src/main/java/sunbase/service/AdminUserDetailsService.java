package sunbase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import sunbase.model.Admin;
import sunbase.repository.AdminRepo;

public class AdminUserDetailsService implements UserDetailsService{
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Admin> opt = adminRepo.findByUsername(username);
		
		if(opt.isPresent()) {
			Admin admin = opt.get();
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			authorities.add(new SimpleGrantedAuthority(admin.getRole()));
			
			return new User(admin.getUsername(), admin.getPassword(), authorities);
		}
		else {
			throw new BadCredentialsException("Admin detail not found");
		}
	}
}