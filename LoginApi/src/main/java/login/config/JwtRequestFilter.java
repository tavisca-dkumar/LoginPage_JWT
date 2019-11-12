package login.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import login.service.JwtUserDetailsService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws IOException, ServletException {
		final String requestHeader= request.getHeader("Authorization");
		String jwtToken=null;
		String username=null;
		if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
			jwtToken=requestHeader.substring(7);
			try {
				username=jwtTokenUtil.getUserNameFormToken(jwtToken);
			}catch(IllegalArgumentException e) {
				throw new IllegalArgumentException("unable to get token",e);
			}
		}
		System.out.println("yjgjf");
		System.out.println(SecurityContextHolder.getContext());
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails=jwtUserDetailsService.loadUserByUsername(username);
			if(jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
						usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						// After setting the Authentication in the context, we specify
						// that the current user is authenticated. So it passes the
						// Spring Security Configurations successfully.
						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
						System.out.println(SecurityContextHolder.getContext());
			}
			
		}
		chain.doFilter(request, response);
		
	}

}
