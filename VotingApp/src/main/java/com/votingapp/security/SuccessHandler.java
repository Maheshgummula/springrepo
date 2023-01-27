package com.votingapp.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.votingapp.enums.Roles;
@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

	RedirectStrategy strategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		
		boolean hasVotervalue=false;
		boolean hasAdminvalue=false;
		

		Collection<? extends GrantedAuthority> authority = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authority) {
			if (grantedAuthority.getAuthority().equals(Roles.VOTER.toString())) {
				hasVotervalue = true;
				break;
			} else if (grantedAuthority.getAuthority().equals(Roles.ADMIN.toString())) {
				hasAdminvalue = true;
				break;
			}
		}
		if (hasVotervalue) {
			strategy.sendRedirect(request, response, "voter/getVotingPage");
		} else if (hasAdminvalue) {
			strategy.sendRedirect(request, response, "/admin");
		}else {
			throw new IllegalStateException();
		}
		
	}

}
