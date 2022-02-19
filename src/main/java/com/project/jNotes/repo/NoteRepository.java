package com.project.jNotes.repo;

import com.project.jNotes.domens.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NoteRepository extends CrudRepository<Note, Long> {
    /*Iterable<Note> findAllByUserId(Long userId);

    Optional<Note> findByIdAndUserId(Long noteId, Long userId);

    void delete(Note note);*/
}
