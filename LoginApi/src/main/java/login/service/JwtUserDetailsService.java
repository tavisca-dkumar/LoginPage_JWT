package login.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import login.entity.UserDao;
import login.entity.UserDto;
import login.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		UserDao user= repo.findByUsername(username);
		if(user!=null) {
			return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
		}
		else 
			throw new UsernameNotFoundException(username +" not found ");
		
	}
	public UserDao save(UserDto user) {
		UserDao newUser = new UserDao();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return repo.save(newUser);
	}

}
