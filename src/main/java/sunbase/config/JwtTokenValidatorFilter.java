package sunbase.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenValidatorFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String jwt = request.getHeader(SecurityConstant.JWT_HEADER);
		
		if(jwt != null) {
			try {
			jwt = jwt.substring(7);
			
			SecretKey key = Keys.hmacShaKeyFor(SecurityConstant.JWT_KEY.getBytes());
			
			Claims claims = Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
			
			String username = String.valueOf(claims.get("username"));
			String authorities = String.valueOf(claims.get("authorities"));
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			} catch (Exception e) {
				throw new BadCredentialsException("Invalid Token received..");
			}
		}
		filterChain.doFilter(request, response);
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return request.getServletPath().equals("login") || request.getServletPath().equals("register");
	}
}
