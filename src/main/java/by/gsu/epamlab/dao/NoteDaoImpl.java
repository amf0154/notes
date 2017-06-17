package by.gsu.epamlab.dao;

import by.gsu.epamlab.model.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Gleb on 23.04.2017.
 */
@Repository
public class NoteDaoImpl implements NoteDao {
    private static final Logger logger = LoggerFactory.getLogger(NoteDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addNote(Note note) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(note);
        logger.info("Note has been added. Note details:"+ note);
    }

    @Override
    public void updateNote(Note note) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(note);
        logger.info("Note has been changed. Note details:"+ note);
    }

    @Override
    public void removeNote(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Note note = (Note) session.load(Note.class, new Integer(id));
            if(note!=null){
                session.delete(note);
            }
        logger.info("Note has been deleted. Note details:"+ note);
    }

    @Override
    public Note getNoteById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Note note = (Note) session.load(Note.class, new Integer(id));
        logger.info("Note has been deleted. Note details:"+ note);
        return note;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Note> noteList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Note> noteList = session.createQuery("from Note").list();
        for(Note note: noteList){
            logger.info("NoteList: "+note);
        }
        return noteList;
    }
}
