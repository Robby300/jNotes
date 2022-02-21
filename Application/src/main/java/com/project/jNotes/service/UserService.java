package com.project.jNotes.service;

import com.project.jNotes.domens.Note;
import com.project.jNotes.domens.User;
import com.project.jNotes.forms.NoteForm;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(User user);

    User getCurrentUser();

    Note addNote(Note note);

    Note getNoteById(Long id);

    void editNoteById(long id, NoteForm form);

    void deleteNoteById(Long noteId);

    User findByUsername(String username);

    void deleteNote(Note note);
}
