package com.project.jNotes.service;

import com.project.jNotes.domens.Note;
import com.project.jNotes.forms.NoteForm;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface NoteService {
    Optional<Note> findByIdAndUserId(Long noteId, Long userId);

    Iterable<Note> findAllByUserId(Long id);

    void addNote(NoteForm form);

    Optional<Note> findById(Long id);

    void delete(Note note);
}
