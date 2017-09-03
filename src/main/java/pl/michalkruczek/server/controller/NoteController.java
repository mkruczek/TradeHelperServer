package pl.michalkruczek.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.*;
import pl.michalkruczek.server.dto.NoteDto;
import pl.michalkruczek.server.model.Note;
import pl.michalkruczek.server.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikr on 03/09/17.
 */

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    public NoteRepository noteRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNote(@RequestBody NoteDto noteDto) throws ParseException{

        Note note = new Note();

        note.setId(noteDto.getId());
        note.setTitle(noteDto.getTitle());
        note.setNote(noteDto.getNote());

        noteRepository.save(note);

        return "Add note: " + note.getTitle();
    }

    @RequestMapping("/all")
    public List<NoteDto> allNote(){
        List<Note> noteList = noteRepository.findAll();
        List<NoteDto> noteDtoList = new ArrayList<NoteDto>();

        for (Note note : noteList) {
            NoteDto noteDto = new NoteDto();

            noteDto.setId(note.getId());
            noteDto.setTitle(note.getTitle());
            noteDto.setNote(note.getNote());

            noteDtoList.add(noteDto);
        }

        return noteDtoList;
    }

    @RequestMapping("/{id}")
    public NoteDto singleNote(@PathVariable long id){
        Note note = noteRepository.findOne(id);
        NoteDto noteDto = new NoteDto();

        noteDto.setId(note.getId());
        noteDto.setTitle(note.getTitle());
        noteDto.setNote(note.getNote());

        return noteDto;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String updateNote(@PathVariable long id, @RequestBody NoteDto noteDto){

        Note note = noteRepository.findOne(id);

        note.setTitle(noteDto.getTitle());
        note.setNote(noteDto.getNote());

        noteRepository.save(note);

        return "Add note: " + note.getTitle();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteNote(@PathVariable long id){

        String noteName = noteRepository.findOne(id).getTitle();

        noteRepository.delete(id);

        return "Delete company [" + noteName + "].";
    }

    @RequestMapping("/find/{title}")
    public List<NoteDto> findByDescription(@PathVariable String title){
        List<Note> noteList = noteRepository.getByDescriptionLike(title);
        List<NoteDto> noteDtoList = new ArrayList<NoteDto>();

        for (Note note : noteList) {
            NoteDto noteDto = new NoteDto();

            noteDto.setTitle(note.getTitle());
            noteDto.setNote(note.getNote());

            noteDtoList.add(noteDto);
        }

        return noteDtoList;
    }
}
