package sunbase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import sunbase.model.Admin;
import sunbase.repository.AdminRepo;

@Component
public class MyAuthentication implements AuthenticationProvider{
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		
		Optional<Admin> opt = adminRepo.findByUsername(username);
		
		if (opt.isEmpty())
			throw new BadCredentialsException("No User registerd with this details");
		else {
			Admin admin= opt.get();
		if (passwordEncoder.matches(pwd, admin.getPassword())) {
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			authorities.add(new SimpleGrantedAuthority(admin.getRole()));
			
			return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
		}
		else
			throw new BadCredentialsException("Invalid Password");
		}
	}
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
