/*
 * package com.ibolit.ibolituser.model;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired 
	private UserDataRepo userRepo;
	
	@Autowired 
	private JwtUnil jwtUtil;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// getting authorization header and validation
		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(StringUtils.hasText(header) || !header.startsWith("Bearer ")){
			chain.doFilter(request, response);
			return;
		}
		
		final String token = header.split(" ")[1].trim();
		UserDetails userDetails = userRepo
			.findByUsername(jwtUtil.getUsernameFromToken(token));
		//Get jwt token and validate
		
		if(!jwtUtil.validateToken(token, userDetails)) {
			chain.doFilter(request, response);
			return;
		}
		
		UsernamePasswordAuthenticationToken
			authentication = new UsernamePasswordAuthenticationToken(
					userDetails,null,
					userDetails == null?
							List.of():userDetails.getAuthorities()
							);
		authentication.setDetails(
				new WebAuthenticationDetailsSource().buildDetails(request);
				);
		SecurityContexHolder.getContex().setAuthentication(authentication);
		
	}
}
*/
