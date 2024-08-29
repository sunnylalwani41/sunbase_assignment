package sunbase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth ->{
			auth
			.requestMatchers(HttpMethod.POST,"/register").permitAll()
			.requestMatchers(HttpMethod.GET, "/customers").hasRole("ADMIN")
			.anyRequest().authenticated();
			})
			.csrf(csrf -> csrf.disable())
			.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
}
