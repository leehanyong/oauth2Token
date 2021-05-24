package com.example.oauthtest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer // API ���� ����(�Ǵ� ���� ����)
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().anonymous();
		//http.authorizeRequests().antMatchers("/users").access("#oauth2.hasScope('read')");
		//http.authorizeRequests().anyRequest();
	}

}