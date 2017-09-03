package pl.michalkruczek.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.michalkruczek.server.model.Task;

import java.util.List;

/**
 * Created by mikr on 18/08/17.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findByUserId(Long userId);

}
