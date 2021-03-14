package com.aws.codestar.projecttemplates.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aws.codestar.projecttemplates.SpringApplicationContex;
import com.aws.codestar.projecttemplates.dto.UserDto;
import com.aws.codestar.projecttemplates.service.UserService;
import com.aws.codestar.projecttemplates.ui.request.model.UserLoginRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager autherticationManager;

	public AuthenticationFilter(AuthenticationManager autherticationManager) {

		this.autherticationManager = autherticationManager;
	}
        
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
		    	UserLoginRequestModel creds = new ObjectMapper()
					.readValue(request.getInputStream(), UserLoginRequestModel.class);
		    	
		    	return  autherticationManager.authenticate(	new UsernamePasswordAuthenticationToken
					(creds.getEmail(), creds.getPassword(), new ArrayList<>()));		
			}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response
			, FilterChain chain,	Authentication authResult) throws IOException, ServletException {
		
		
		
		 String userName = ((User) authResult.getPrincipal()).getUsername();  
		 String token = Jwts.builder()
				       .setSubject(userName)
				       .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				       .signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret()).compact();
		
		  UserService  userService = (UserService) SpringApplicationContex.getBean("userServiceImp");
		  UserDto usertDto      = userService.getUser(userName);
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+token);
		response.addHeader("User_Id", usertDto.getUserId());
	}
	
}