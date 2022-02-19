package com.project.jNotes.service;

import com.project.jNotes.domens.Note;
import com.project.jNotes.domens.User;
import com.project.jNotes.forms.NoteForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void save(User user);

    User getCurrentUser();

    List<Note> getNotes(Long userId);

    void addNote(NoteForm noteForm);

    Note getNoteById(Long id);

    void editNoteById(long id, NoteForm form);

    void deleteNoteById(Long noteId);

    User findByUsername(String username);
}
