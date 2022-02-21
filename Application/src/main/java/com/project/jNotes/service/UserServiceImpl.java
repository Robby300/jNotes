package com.project.jNotes.service;

import com.project.jNotes.domens.Note;
import com.project.jNotes.domens.User;
import com.project.jNotes.forms.NoteForm;
import com.project.jNotes.repo.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    public User getCurrentUser() {
        return (User) loadUserByUsername(getCurrentUsername());
    }

    @Override
    public Note addNote(Note note) {
        User user = getCurrentUser();
        List<Note> notes = user.getNoteList();
        /*Note note = Note.builder()
                .creationTime(LocalDateTime.now())
                .text(note.getText())
                .build();*/
        notes.add(note);
        user.setNoteList(notes);
        save(user);
        return note;
    }

    @Override
    public Note getNoteById(Long noteId) {
        return getCurrentUser()
                .getNoteList()
                .stream()
                .filter(note -> note.getId()
                        .equals(noteId)).findFirst().get();
    }

    @Override
    public void editNoteById(long noteId, NoteForm form) {
        User user = getCurrentUser();
        List<Note> notes = user.getNoteList();
        Optional<Note> noteById = notes.stream().filter(note -> note.getId().equals(noteId)).findFirst();
        noteById.ifPresent(note -> note.setText(form.getText()));
        user.setNoteList(notes);
        save(user);
    }

    @Override
    public void deleteNoteById(Long noteId) {
        User user = getCurrentUser();
        List<Note> notes = user.getNoteList();
        Optional<Note> noteById = notes.stream().filter(note -> note.getId().equals(noteId)).findFirst();
        noteById.ifPresent(notes::remove);
        user.setNoteList(notes);
        save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteNote(Note note) {
        deleteNoteById(note.getId());
    }
}
