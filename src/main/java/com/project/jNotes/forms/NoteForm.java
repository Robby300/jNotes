package com.project.jNotes.forms;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class NoteForm {
    @NotEmpty
    @Length(max = 511)
    private String text;

}
