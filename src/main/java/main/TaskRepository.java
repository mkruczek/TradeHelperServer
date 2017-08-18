package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mikr on 18/08/17.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {


    public List<Task> findByDone(Boolean done);

    @Query("select t from Task t where t.description like %?1%")
    public List<Task> getByDescriptionLike(String search);
}
