package com.project.jNotes.controllers;

import com.project.jNotes.domens.Note;
import com.project.jNotes.domens.User;
import com.project.jNotes.forms.NoteForm;
import com.project.jNotes.service.NoteService;
import com.project.jNotes.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@PreAuthorize("hasAuthority")
@Controller
public class NoteController {
    private final UserService userService;
    private final NoteService noteService;



    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping()
    public String findAll(Model model) {
        User user = userService.getCurrentUser();
        Iterable<Note> notes = noteService.findAllByUserId(user.getId());
        model.addAttribute("notes", notes);
        return "notes";
    }

    @GetMapping("/add")
    public String noteAdd() {
        return "notes-add";
    }


    @PostMapping("/notes/add")
    public String noteAdd(@Valid NoteForm form) throws IOException {
        noteService.addNote(form);
        return "redirect:/notes";
    }

    @GetMapping("/{id}")
    public String noteDetails(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.getCurrentUser();
        if (noteService.findByIdAndUserId(id, user.getId()).isPresent()) {
            return "notes-details";
        } else {
            return "redirect:/notes";
        }
    }

    @GetMapping("/{id}/edit")
    public String noteEdit(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getCurrentUser();
         if (noteService.findByIdAndUserId(id, user.getId()).isPresent()) {
            return "notes-edit";
        } else {
            return "redirect:/notes";
        }
    }

    @PostMapping("/{id}/edit")
    public String noteUpdate(@PathVariable(value = "id") long id, NoteForm form) throws IOException {
        noteService.addNote(form);
        return "redirect:/notes";
    }

    @PostMapping("/{id}/remove")
    public String noteDelete(@PathVariable(value = "id") long id) {
        User user = userService.getCurrentUser();
        Optional<Note> note = noteService.findByIdAndUserId(id, user.getId());
        if (note.isPresent()) {
            noteService.delete(note.get());
        }
        return "redirect:/notes";
    }
}
