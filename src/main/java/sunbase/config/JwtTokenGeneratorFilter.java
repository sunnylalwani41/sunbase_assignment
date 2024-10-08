package sunbase.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (null != authentication) {
			SecretKey key = Keys.hmacShaKeyFor(SecurityConstant.JWT_KEY.getBytes());
			
			String jwt = Jwts.builder()
				.setIssuer("Sunbase")
				.setSubject("JWT Token")
				.claim("username", authentication.getName())
				.claim("authorities", populateAuthorities(authentication.getAuthorities()))
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+ 3600000)) // millisecond expiration time of around 8 hours
				.signWith(key).compact();
		
			response.setHeader(SecurityConstant.JWT_HEADER, jwt);
		}
		filterChain.doFilter(request, response);
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		// TODO Auto-generated method stub
		return !request.getServletPath().equals("login");		
	}
	
	private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
		Set<String> authoritiesSet = new HashSet<>();
		
		for (GrantedAuthority authority : collection) {
			authoritiesSet.add(authority.getAuthority());
		}
		
		return String.join(",", authoritiesSet);
	}
}
