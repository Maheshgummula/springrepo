package com.demo.security;

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

@Component
public class SuccessHandlerForAll implements AuthenticationSuccessHandler {

	RedirectStrategy strategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		boolean hasCustomerRole = false;
		boolean hasEmployeeRole = false;
		boolean hasAdminRole = false;
		Collection<? extends GrantedAuthority> authority = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authority) {
			if (grantedAuthority.getAuthority().equals("Customer")) {
				hasCustomerRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("Admin")) {
				hasAdminRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("Employee")) {
				hasEmployeeRole = true;
				break;
			}
		}
		if (hasCustomerRole) {
			strategy.sendRedirect(request, response, "/customer");
		} else if (hasAdminRole) {
			strategy.sendRedirect(request, response, "/admin");
		} else if (hasEmployeeRole) {
			strategy.sendRedirect(request, response, "/emp");
		} else {
			throw new IllegalStateException();
		}

	}

}
