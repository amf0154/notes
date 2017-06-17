package by.gsu.epamlab.service;

import by.gsu.epamlab.dao.NoteDao;
import by.gsu.epamlab.model.Note;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Gleb on 23.04.2017.
 */
@Service
public class NoteServiceImpl implements NoteService {
    private NoteDao noteDao;

    public void setNoteDao(NoteDao noteDao){
        this.noteDao = noteDao;
    }
    @Override
    @Transactional
    public void addNote(Note note) {
        this.noteDao.addNote(note);
    }

    @Override
    @Transactional
    public void updateNote(Note note) {
        this.noteDao.updateNote(note);

    }

    @Override
    @Transactional
    public void removeNote(int id) {
        this.noteDao.removeNote(id);

    }

    @Override
    @Transactional
    public Note getNoteById(int id) {
        return this.noteDao.getNoteById(id);
    }

    @Override
    @Transactional
    public List<Note> noteList() {
        return this.noteDao.noteList();
    }
}
