package com.project.jNotes.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jNotes.domens.Note;
import com.project.jNotes.domens.User;
import com.project.jNotes.domens.Views;
import com.project.jNotes.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasAuthority('USER')")
@RequestMapping("restnotes")
@RestController
public class NoteRestController {
    private final UserService userService;

    public NoteRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    @JsonView(Views.Text.class)
    public List<Note> findAll() {
        User user = userService.getCurrentUser();
        return user.getNoteList();
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return userService.addNote(note);
    }


    @GetMapping("{id}")
    @JsonView(Views.FullNote.class)
    public Note noteDetails(@PathVariable(value = "id") Note note) {
        return note;
    }


    @PutMapping("{id}")
    public Note update(@PathVariable("id") Note noteFromDb,
                          @RequestBody Note note) {
        BeanUtils.copyProperties(note, noteFromDb, "id");
        return userService.addNote(noteFromDb);
    }

    @PostMapping("{id}")
    public void delete(@PathVariable(value = "id") Note note) {
        userService.deleteNote(note);
    }
}
