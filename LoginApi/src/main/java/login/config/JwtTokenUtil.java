package login.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Component
public class JwtTokenUtil {
	private static final long JWT_TOKEN_VALIDITY= 5 * 60 * 60;
	

	@Value("${jwt.secret}")
	private String secret;
	
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	public String getUserNameFormToken(String token) {
		return  getAllClaimsFromToken(token).getSubject();
		
	}	
	
	public Date getExpirationDateFormToken(String token) {
		return getAllClaimsFromToken(token).getExpiration();
		
	}
	
	public Boolean isTokenExpires(String token) {
		Date expiration = getExpirationDateFormToken(token);
		return expiration.before(new Date());
		}
	
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims= new HashMap<String,Object>();
		String userName=userDetails.getUsername();
		return doGenerateToken(claims, userName);
		
	}
	
	public String doGenerateToken(Map<String,Object> claims,String subject) {
		
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512,secret).compact();
		
	}
	
	//validatation of token
	public Boolean validateToken(String token,UserDetails userDetails) {
		final String username=getUserNameFormToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpires(token));
		
	}
	
}

