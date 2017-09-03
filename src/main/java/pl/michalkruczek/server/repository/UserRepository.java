package pl.michalkruczek.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalkruczek.server.model.User;

/**
 * Created by mikr on 03/09/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByLogin(String login);

}
