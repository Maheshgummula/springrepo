
package com.jwtexample.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwtexample.helper.JwtUtilHelperClass;
import com.jwtexample.service.CustomerUserDetailService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private CustomerUserDetailService detailService;

	@Autowired
	private JwtUtilHelperClass helperClass;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestHeaderToken = request.getHeader("Authorization");//HttpHeaders.AUTHORIZATION
		String Username = null;
		String jwtToken = null; 
		
		if (requestHeaderToken != null && requestHeaderToken.startsWith("Bearer ")) {
			jwtToken = requestHeaderToken.substring(7);

			try {
				Username = helperClass.extractUsername(jwtToken);
			} catch (Exception e) {
				e.printStackTrace();
			}
			UserDetails userDetails = this.detailService.loadUserByUsername(Username);
			if (Username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails,null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else {
				System.out.println("not vallid");
			}
		}
		filterChain.doFilter(request, response);
	}

}
