package edu.neiu.magecraft.data;

import edu.neiu.magecraft.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

    User findByUsername(String username);

    User findByEmail(String email);
}
