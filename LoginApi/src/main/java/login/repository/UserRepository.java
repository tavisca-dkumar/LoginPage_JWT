package login.repository;

import login.entity.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao,String> {
	UserDao findByUsername(String username);
}
