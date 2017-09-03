package pl.michalkruczek.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.michalkruczek.server.model.Note;

import java.util.List;

/**
 * Created by mikr on 03/09/17.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {

    public List<Note> findByUserId(Long id);

    @Query("select n from Note n where n.title like %?1%")// TODO nie działa
    public List<Note> getByDescriptionLike(String search);

}
