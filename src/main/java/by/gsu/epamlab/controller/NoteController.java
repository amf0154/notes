package by.gsu.epamlab.controller;

import by.gsu.epamlab.model.Note;
import by.gsu.epamlab.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Gleb on 23.04.2017.
 */
@Controller
public class NoteController {
    private NoteService noteService;

    @Autowired(required = true)
    @Qualifier(value = "noteService")
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "notes" , method = RequestMethod.GET)
    public String listNotes(Model model){
        model.addAttribute("note", new Note());
        model.addAttribute("noteList", this.noteService.noteList());

        return "notes";

    }

    @RequestMapping(value = "/notes/add", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("note") Note note){
        if(note.getId() ==0){
            this.noteService.addNote(note);
        }else{
            this.noteService.updateNote(note);
        }
        return "redirect:/notes";
    }

    @RequestMapping("/remove/{id}")
    public String removeNote(@PathVariable("id") int id){
        this.noteService.removeNote(id);
        return "redirect:/notes";
    }

    @RequestMapping("edit/{id}")
        public String editNote(@PathVariable("id") int id, Model model){
        model.addAttribute("note", this.noteService.getNoteById(id));
        model.addAttribute("noteList", this.noteService.noteList());

        return "notes";
        }

        @RequestMapping("notedata/{id}")
    public String noteData(@PathVariable("id") int id, Model model){
            model.addAttribute("note", this.noteService.getNoteById(id));
            return "notedata";
    }
}
