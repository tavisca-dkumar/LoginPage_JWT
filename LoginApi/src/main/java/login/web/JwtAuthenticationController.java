package login.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import login.config.JwtTokenUtil;
import login.entity.JwtRequest;
import login.entity.JwtResponse;
import login.entity.UserDto;
import login.service.JwtUserDetailsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class JwtAuthenticationController {
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody UserDto user){
		return new ResponseEntity<>(userDetailsService.save(user),HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationtoken(@RequestBody JwtRequest request){
		authenticate(request.getUsername(), request.getPassword());
		final UserDetails userDetails=userDetailsService.loadUserByUsername(request.getUsername());
		final String token=jwtTokenUtil.generateToken(userDetails);
		return new ResponseEntity<>(new JwtResponse(token),HttpStatus.OK);
	}
	
	
	private void authenticate(String username,String password) {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e) {
			throw new DisabledException("usr disable",e);
		}catch (BadCredentialsException e) {
			throw new BadCredentialsException("invalid",e);
		}
		
		
	}

}
