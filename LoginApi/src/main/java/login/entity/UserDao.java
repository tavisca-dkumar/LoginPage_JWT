package login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "credentialtable")
@Entity
public class UserDao {
    @Id
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    public String getUsername() {
		return username;
	}
    
    public String getPassword() {
        return password;
    }

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
