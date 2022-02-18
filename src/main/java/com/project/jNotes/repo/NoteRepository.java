package com.project.jNotes.repo;

import com.project.jNotes.domens.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
