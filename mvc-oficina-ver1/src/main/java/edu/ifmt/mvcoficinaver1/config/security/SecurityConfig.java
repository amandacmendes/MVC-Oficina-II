package edu.ifmt.mvcoficinaver1.config.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
*/

//@Configuration
public class SecurityConfig {

	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception { http.authorizeHttpRequests((authz) ->
	 * authz.anyRequest().authenticated()).httpBasic(); return http.build(); }
	  */


/*
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring()
				.antMatchers("/n/aluno", "/create/aluno", "/js/**", "/css/**", "user", "role");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				// .antMatchers("/admin/**").hasRole("ADMIN")
				// .antMatchers("/anonymous*").anonymous()
				.antMatchers("/login*").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.loginProcessingUrl("/perform_login")
				.defaultSuccessUrl("/MinhasAtividades.html", true)
				.failureUrl("/Login.html?error=true");

		return http.build();

	}
*/
	
	
	/*
	@Bean
    public UserDetailsManager users(DataSource dataSource) {
        @SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder()
            .username("admin@admin.com.br")
            .password("123456")
            .roles("USER")
            .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        return users;
    }*/
}
