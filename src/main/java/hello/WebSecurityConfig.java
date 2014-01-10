package hello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.config.annotation.authentication.configurers.InMemoryClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.OAuth2ServerConfigurer;
import org.springframework.security.oauth2.provider.token.InMemoryTokenStore;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final String applicationName = "restservice";

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.requestMatchers()
				.and()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
				.and()
			.apply(new OAuth2ServerConfigurer())
			.tokenStore(new InMemoryTokenStore())
			.resourceId(applicationName);
	}
	// @formatter:on

	// @formatter:off
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(new InMemoryUserDetailsManager(getUserDetails()))
				.and()
			.apply(new InMemoryClientDetailsServiceConfigurer())
				.withClient("clientapp")
				.resourceIds(applicationName)
				.scopes("read", "write")
				.authorities("USER")
				.authorizedGrantTypes("password")
				.secret("123456");
	}
	// @formatter:on

	private static final Collection<UserDetails> getUserDetails() {
		List<UserDetails> userDetails = new ArrayList<UserDetails>();
		userDetails.add(new User("user", "password", AuthorityUtils.createAuthorityList(
				"USER", "read", "write")));
		return userDetails;
	}

}
