package com.project.jNotes.controllers;

import com.project.jNotes.domens.Note;
import com.project.jNotes.domens.User;
import com.project.jNotes.forms.NoteForm;
import com.project.jNotes.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize("hasAuthority('USER')")
@RequestMapping("/notes")
@Controller
public class NoteController {
    private final UserService userService;

    public NoteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String findAll(Model model) {
        User user = userService.getCurrentUser();
        List<Note> notes = user.getNoteList();
        model.addAttribute("notes", notes);
        return "notes";
    }

    @GetMapping("/add")
    public String noteAdd() {
        return "notes-add";
    }

    @PostMapping("/add")
    public String noteAdd(@Valid NoteForm noteForm) {
        userService.addNote(noteForm);

        return "redirect:/notes";
    }

    @GetMapping("/{id}")
    public String noteDetails(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute(userService.getNoteById(id));
        return "notes-details";

    }

    @GetMapping("/{id}/edit")
    public String noteEdit(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute(userService.getNoteById(id));
        return "notes-edit";
    }

    @PostMapping("/{id}/edit")
    public String noteUpdate(@PathVariable(value = "id") Long noteId, NoteForm noteForm) {
        userService.editNoteById(noteId, noteForm);
        return "redirect:/notes";
    }

    @PostMapping("/{id}/remove")
    public String noteDelete(@PathVariable(value = "id") Long noteId) {
        userService.deleteNoteById(noteId);
        return "redirect:/notes";
    }
}
