package ijse.ws.instagram_clone.repository;

import ijse.ws.instagram_clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String getusername);

    User findUserByUsername(String username);
}
