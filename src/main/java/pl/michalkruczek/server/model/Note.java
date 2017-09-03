package pl.michalkruczek.server.model;

import javax.persistence.*;

/**
 * Created by mikr on 03/09/17.
 */
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
