package by.gsu.epamlab.dao;

import by.gsu.epamlab.model.Note;

import java.util.List;

/**
 * Created by Gleb on 23.04.2017.
 */
public interface NoteDao {
  public void addNote(Note note);
  public void updateNote(Note note);
  public void removeNote(int id);
  public Note getNoteById(int id);
  public List<Note> noteList();
}
