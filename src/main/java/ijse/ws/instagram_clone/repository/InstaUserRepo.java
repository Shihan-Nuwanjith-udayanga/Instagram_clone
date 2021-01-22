package ijse.ws.instagram_clone.repository;

import ijse.ws.instagram_clone.entity.InstaUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstaUserRepo extends CrudRepository<InstaUser, Long> {
}

