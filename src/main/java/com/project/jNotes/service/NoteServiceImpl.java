package com.project.jNotes.service;

import com.project.jNotes.domens.Note;
import com.project.jNotes.forms.NoteForm;
import com.project.jNotes.repo.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Optional<Note> findByIdAndUserId(Long noteId, Long userId) {
        return noteRepository.findByIdAndUserId(noteId, userId);
    }

    @Override
    public Iterable<Note> findAllByUserId(Long userId) {
        return noteRepository.findAllByUserId(userId);
    }

    @Override
    public void addNote(NoteForm form) {
        Note note = Note.builder()
                .text(form.getText())
                .creationTime(LocalDateTime.now())
                .build();
        noteRepository.save(note);
    }

    @Override
    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public void delete(Note note) {
        noteRepository.delete(note);
    }
}
